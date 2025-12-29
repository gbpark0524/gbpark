// src/app/layout.tsx
import { SidebarProvider, SidebarTrigger } from "@/components/ui/sidebar"
import { AppSidebar } from "@/components/app-sidebar" // <-- 생성된 파일 경로 확인!
import "./globals.css";

export default function RootLayout({ children }: { children: React.ReactNode }) {
  return (
    <html lang="ko">
      <body className="antialiased">
        {/* 1. 가장 바깥을 Provider로 감쌉니다 */}
        <SidebarProvider>
          
          {/* 2. 사이드바 컴포넌트 배치 (왼쪽 고정) */}
          <AppSidebar />
          
          {/* 3. 메인 컨텐츠 영역 */}
          <main className="w-full">
            {/* 사이드바를 열고 닫는 트리거(햄버거 버튼) */}
            <div className="p-4 border-b flex items-center gap-2">
               <SidebarTrigger />
               <span className="font-bold">GBPARK Portfolio</span>
            </div>

            {/* 실제 page.tsx 내용이 들어가는 곳 */}
            <div className="p-6">
              {children}
            </div>
          </main>
          
        </SidebarProvider>
      </body>
    </html>
  );
}