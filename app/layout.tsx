// src/app/layout.tsx
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar";
import { AppSidebar } from "@/components/app-sidebar";
import { AuthProvider } from "@/components/auth-provider";
import { NavUser } from "@/components/nav-user";
import "./globals.css";

export default function RootLayout({
  children,
}: {
  children: React.ReactNode;
}) {
  return (
    <html lang="ko">
      <body className="antialiased min-h-svh flex flex-col">
        <AuthProvider>
          <SidebarProvider>
            <AppSidebar />
            <main className="flex-1 flex flex-col">
              <div className="p-4 border-b flex items-center justify-between">
                <div className="flex items-center gap-2">
                  <SidebarTrigger />
                  <span className="font-bold">Main</span>
                </div>
                <NavUser />
              </div>
              <div className="flex-1 flex items-center justify-center p-6">{children}</div>
            </main>
          </SidebarProvider>
        </AuthProvider>
      </body>
    </html>
  );
}
