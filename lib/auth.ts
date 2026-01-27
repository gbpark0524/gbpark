import NextAuth from "next-auth"
import Google from "next-auth/providers/google"

export const { handlers, signIn, signOut, auth } = NextAuth({
  providers: [
    Google({
      clientId: process.env.AUTH_GOOGLE_ID!,
      clientSecret: process.env.AUTH_GOOGLE_SECRET!,
    }),
  ],
  callbacks: {
    async jwt({ token, account, profile }) {
      if (account && profile) {
        token.providerId = profile.sub // Google 고유 ID
        token.provider = account.provider // "google"
      }
      return token
    },
    async session({ session, token }) {
      session.user.providerId = token.providerId as string
      session.user.provider = token.provider as string
      return session
    },
  },
})
