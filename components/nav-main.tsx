"use client"

import { type LucideIcon, } from "lucide-react"
import { type ComponentType } from "react"

import {
  SidebarGroup,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar"
import Link from "next/link"

type IconType = LucideIcon | ComponentType<{ className?: string }>

export function NavMain({
  items,
}: {
  items: {
    name: string
    url: string
    icon: IconType
  }[]
}) {
  return (
    <SidebarGroup className="">
      <SidebarMenu>
        {items.map((item) => (
          <SidebarMenuItem key={item.name}>
            <SidebarMenuButton asChild>
              <Link href={item.url}>
                <item.icon />
                <span>{item.name}</span>
              </Link>
            </SidebarMenuButton>
          </SidebarMenuItem>
        ))}
      </SidebarMenu>
    </SidebarGroup>
  )
}
