"use client";

import {
  BadgeCheck,
  Bell,
  CreditCard,
  LogIn,
  LogOut,
  Sparkles,
  UserRound,
} from "lucide-react";

import { Avatar, AvatarFallback, AvatarImage } from "@/components/ui/avatar";
import {
  DropdownMenu,
  DropdownMenuContent,
  DropdownMenuGroup,
  DropdownMenuItem,
  DropdownMenuLabel,
  DropdownMenuSeparator,
  DropdownMenuTrigger,
} from "@/components/ui/dropdown-menu";
import { Button } from "./ui/button";
import Link from "next/link";
import { useSession, signOut } from "next-auth/react";

export function NavUser() {
  const { data: session, status} = useSession();

  if (status === "loading") {
    return <div>Loading...</div>;
  }

  if (!session) {
    return (
      <Button variant="ghost" size="sm" className="gap-2" asChild>
        <Link href="/login">
          <LogIn className="h-4 w-4" />
          <span>Sign in</span>
        </Link>
      </Button>
    );
  }

  const user = session?.user;

  return (
    <DropdownMenu>
      <DropdownMenuTrigger asChild>
        <Button variant="ghost" size="icon">
          <div className="relative w-fit">
            <Avatar className="rounded-lg" size="lg">
              <AvatarImage src={user.image?.toString()} alt={user.name?.toString()} />
              <AvatarFallback>{user.name?.slice(0, 2).toUpperCase()}</AvatarFallback>
            </Avatar>
            <span className="border-background absolute -top-1.5 -right-1.5 size-3 rounded-full border-2 bg-amber-600 dark:bg-amber-400">
              <span className="sr-only">Away</span>
            </span>
          </div>
        </Button>
      </DropdownMenuTrigger>
      <DropdownMenuContent
        className="w-(--radix-dropdown-menu-trigger-width) min-w-56 rounded-lg"
        side="bottom"
        align="end"
        sideOffset={4}
      >
        <DropdownMenuLabel className="p-0 font-normal">
          <div className="flex items-center gap-2 px-1 py-1.5 text-left text-sm">
            <Avatar className="h-8 w-8 rounded-lg">
              <AvatarImage src={user.image?.toString()} alt={user.name?.toString()} />
              <AvatarFallback>{user.name?.slice(0, 2).toUpperCase()}</AvatarFallback>
            </Avatar>
            <div className="grid flex-1 text-left text-sm leading-tight">
              <span className="truncate font-medium">{user.name}</span>
              <span className="truncate text-xs">{user.email}</span>
            </div>
          </div>
        </DropdownMenuLabel>
        <DropdownMenuSeparator />
        <DropdownMenuGroup>
        <DropdownMenuItem className="cursor-pointer">
          <UserRound/>
          Profile
        </DropdownMenuItem>
        </DropdownMenuGroup>
        <DropdownMenuSeparator />
        <DropdownMenuItem className="cursor-pointer" onClick={() => signOut()}>
          <LogOut />
          Log out
        </DropdownMenuItem>
      </DropdownMenuContent>
    </DropdownMenu>
  );
}
