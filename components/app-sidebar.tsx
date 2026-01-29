"use client";

import * as React from "react";
import {
  House,
  GithubIcon,
  Rocket,
  BookOpen,
  Terminal,
} from "lucide-react";
import { MY_LINKS } from "@links";
import { NavMain } from "@/components/nav-main";
import {
  Sidebar,
  SidebarContent,
  SidebarGroup,
  SidebarHeader,
  SidebarMenu,
  SidebarMenuButton,
  SidebarMenuItem,
} from "@/components/ui/sidebar";

const data = {
  user: {
    name: "gbpark",
    email: "gbpark0524@gmail.com",
    avatar: "",
  },
  navMain: [
    {
      name: "Home",
      url: "/",
      icon: House,
    },
    {
      name: "Projects",
      url: "/projects",
      icon: Rocket,
    },
    {
      name: "GitHub",
      url: MY_LINKS.GITHUB,
      icon: GithubIcon,
    },
    {
      name: "Tech Blog",
      url: MY_LINKS.BLOG,
      icon: BookOpen,
    },
  ],
};

export function AppSidebar({ ...props }: React.ComponentProps<typeof Sidebar>) {
  return (
    <Sidebar collapsible="icon" {...props}>
      <SidebarHeader>
        <SidebarMenu>
          <SidebarMenuItem>
            <SidebarMenuButton
              size="lg"
              className="pointer-events-none hover:bg-transparent active:bg-transparent"
            >
              <div className="flex aspect-square size-8 items-center justify-center shrink-0 rounded-lg bg-primary text-primary-foreground">
                <Terminal className="size-4" />
              </div>
              <div className="flex flex-col gap-0.5 leading-none">
                <span className="font-semibold">GB Park</span>
              </div>
            </SidebarMenuButton>
          </SidebarMenuItem>
        </SidebarMenu>
      </SidebarHeader>
      <SidebarContent>
        <SidebarGroup>
          <NavMain items={data.navMain} />
        </SidebarGroup>
      </SidebarContent>
    </Sidebar>
  );
}
