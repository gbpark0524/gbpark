// src/app/layout.tsx
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar"
import { AppSidebar } from "@/components/app-sidebar"
import { AuthProvider } from "@/components/auth-provider"
import { LoginButton } from "@/components/login-button"
import "./globals.css";

export default function RootLayout({ children }: { children: React.ReactNode }) {
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
                  <span className="font-bold">GBPARK Portfolio</span>
                </div>
                <LoginButton />
              </div>

              <div className="p-6">
                {children}
              </div>
            </main>
            
          </SidebarProvider>
        </AuthProvider>
      </body>
    </html>
  );
}
