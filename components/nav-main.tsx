"use client";

import { type LucideIcon } from "lucide-react";
import { type ComponentType } from "react";

import {
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";
import Link from "next/link";

type IconType = LucideIcon | ComponentType<{ className?: string }>;

export function NavMain({
  items,
}: {
  items: {
    name: string;
    url: string;
    icon: IconType;
  }[];
}) {
  return (
    <SidebarMenu>
      {items.map((item) => (
        <SidebarMenuItem key={item.name}>
          <SidebarMenuButton asChild>
            <Link href={item.url}>
              <item.icon className="size-4" />
              <span>{item.name}</span>
            </Link>
          </SidebarMenuButton>
        </SidebarMenuItem>
      ))}
    </SidebarMenu>
  );
}
