// src/app/layout.tsx
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/app-sidebar";
import { AuthProvider } from "@/components/auth-provider";
import { NavUser } from "@/components/nav-user";
import "./globals.css";

const data = {
  user:null
  // user: {
  //   name: "gbpark",
  //   email: "gbpark0524@gmail.com",
  //   avatar: "",
  // },
};

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="ko">
      <body className="antialiased">
        <AuthProvider>
          <SidebarProvider>
            <AppSidebar />

            <main className="w-full">
              <div className="p-4 border-b flex items-center justify-between">
                <div className="flex items-center gap-2">
                  <SidebarTrigger />
                  <span className="font-bold">Main</span>
                </div>
                <NavUser user={data.user} />
              </div>
              <div className="p-6">{children}</div>
            </main>
          </SidebarProvider>
        </AuthProvider>
      </body>
    </html>
  );
}
