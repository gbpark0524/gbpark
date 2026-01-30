"use client";

import {
  Card,
  CardContent,
  CardDescription,
  CardHeader,
  CardTitle,
} from "@/components/ui/card";
import { LoginButton } from "@/components/login-button";

export function LoginForm() {
  return (
    <Card className="w-full max-w-md">
      <CardHeader className="space-y-1 text-center">
        <CardTitle className="text-2xl font-bold">Welcome</CardTitle>
        <CardDescription>Sign in to your account to continue</CardDescription>
      </CardHeader>
      <CardContent className="space-y-4">
        <LoginButton />
        <p className="text-center text-xs text-muted-foreground">
          로그인 시{" "}
          <a href="/terms" className="underline hover:text-foreground">
            이용약관
          </a>
          에 동의하는 것으로 간주합니다.
        </p>
      </CardContent>
    </Card>
  );
}
