import { DefaultSession } from "next-auth"

declare module "next-auth" {
  interface Session {
    user: {
      providerId: string
      provider: string
    } & DefaultSession["user"]
  }
}

declare module "next-auth/jwt" {
  interface JWT {
    providerId?: string
    provider?: string
  }
}
