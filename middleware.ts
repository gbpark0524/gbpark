import { auth } from "@/lib/auth";
import { NextResponse } from "next/server";

// 로그인 상태에서 접근 시 메인("/")으로 리다이렉트할 경로들
const REDIRECT_TO_MAIN_WHEN_LOGGED_IN = [
  "/login",
];

// 비로그인 상태에서 접근 시 로그인("/login")으로 리다이렉트할 경로들
const REDIRECT_TO_LOGIN_WHEN_NOT_LOGGED_IN = [
  "/admin",
];

export default auth((req) => {
  const isLoggedIn = !!req.auth;
  const pathname = req.nextUrl.pathname;

  if (isLoggedIn && REDIRECT_TO_MAIN_WHEN_LOGGED_IN.some(path => pathname.startsWith(path))) {
    return NextResponse.redirect(new URL("/", req.url));
  }

  if (!isLoggedIn && REDIRECT_TO_LOGIN_WHEN_NOT_LOGGED_IN.some(path => pathname.startsWith(path))) {
    return NextResponse.redirect(new URL("/login", req.url));
  }

  return NextResponse.next();
});

export const config = {
  matcher: [
    "/login",
    "/admin/:path*",
  ],
};
