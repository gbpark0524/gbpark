"use client"

import { signIn, useSession } from "next-auth/react"
import { Button } from "@/components/ui/button"
import { GoogleIcon } from "./icons/google"

export function LoginButton() {
  const { data: session, status } = useSession()

  if (status === "loading") {
    return (
      <button 
        disabled
        className="w-full flex items-center justify-center gap-3 px-4 py-3 bg-white border border-[#747775] rounded-md text-sm font-medium text-[#1F1F1F]"
        style={{ fontFamily: 'Roboto, sans-serif' }}
      >
        Loading...
      </button>
    )
  }

  if (session) {return null}

  return (
    <Button
      onClick={() => signIn("google", { callbackUrl: "/" })}
      className="w-full h-10 flex items-center justify-center gap-2.5 px-3 py-2.5 bg-white border border-[#747775] rounded-md hover:bg-[#F8F9FA] transition-colors"
      style={{ fontFamily: 'Roboto, sans-serif' }}
    >
      <GoogleIcon className="size-5"/>
      <span className="text-[#1F1F1F] text-sm font-medium leading-5">
        Sign in with Google
      </span>
    </Button>
  )
}