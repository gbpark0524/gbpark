import NextAuth from "next-auth"
import Google from "next-auth/providers/google"
import { prisma } from '@/lib/prisma';

export const { handlers, signIn, signOut, auth } = NextAuth({
  providers: [
    Google({
      clientId: process.env.AUTH_GOOGLE_ID!,
      clientSecret: process.env.AUTH_GOOGLE_SECRET!,
    }),
  ],
  callbacks: {
    async signIn({ account, profile }) {
      if (!account || !profile) return false;

      await prisma.user.upsert({
        where: {
          provider_providerId: {
            provider: account.provider,
            providerId: profile.sub!,
          }
        },
        update: {},
        create: {
          provider: account.provider,
          providerId: profile.sub!,
        }
      })

      return true;
    },
    async jwt({ token, account, profile }) {
      if (account && profile) {
        token.providerId = profile.sub
        token.provider = account.provider
      }
      return token
    },
    async session({ session, token }) {
      const dbUser = await prisma.user.findUnique({
        where: {
          provider_providerId: {
            provider: token.provider as string,
            providerId: token.providerId as string,
          }
        },
        include: { admin: true }
      })

      if (session.user) {
        session.user.id = dbUser?.id ?? ""
        session.user.nickname = dbUser?.nickname ?? null
        session.user.isAdmin = !!dbUser?.admin
        session.user.providerId = token.providerId as string
        session.user.provider = token.provider as string
      }

      return session
    },
  },
})
