import Link from "next/link";
import { ArrowLeft } from "lucide-react";
import { Button } from "@/components/ui/button";
import { Card, CardContent, CardHeader, CardTitle } from "@/components/ui/card";

export const metadata = {
  title: "이용약관",
  description: "서비스 이용약관",
};

export default function TermsPage() {
  return (
    <div className="container max-w-3xl py-10">
      <Button variant="ghost" size="sm" asChild className="mb-4">
        <Link href="/login">
          <ArrowLeft className="mr-2 h-4 w-4" />
          돌아가기
        </Link>
      </Button>
      <Card>
        <CardHeader>
          <CardTitle className="text-2xl">이용약관</CardTitle>
        </CardHeader>
        <CardContent className="prose prose-neutral dark:prose-invert max-w-none space-y-6">
          <section>
            <h2 className="text-lg font-semibold">1. 서비스 안내</h2>
            <p className="text-muted-foreground">
              본 사이트는 개인 포트폴리오/블로그입니다.
            </p>
          </section>

          <section>
            <h2 className="text-lg font-semibold">2. 수집 정보</h2>
            <ul className="list-disc list-inside text-muted-foreground space-y-1">
              <li>OAuth 로그인 시 제공자의 고유 ID</li>
              <li>사용자가 직접 입력한 닉네임</li>
            </ul>
            <p className="text-muted-foreground mt-2">
              * 이메일, 실명 등 개인정보는 수집하지 않습니다.
            </p>
          </section>

          <section>
            <h2 className="text-lg font-semibold">3. 이용 목적</h2>
            <p className="text-muted-foreground">
              글 작성자 식별 및 서비스 이용 권한 관리
            </p>
          </section>

          <section>
            <h2 className="text-lg font-semibold">4. 보관 및 삭제</h2>
            <p className="text-muted-foreground">
              회원 탈퇴 요청 시 관련 정보는 즉시 삭제됩니다.
            </p>
          </section>

          <section>
            <h2 className="text-lg font-semibold">5. 문의</h2>
            <p className="text-muted-foreground">
              gbpark0524@gmail.com
            </p>
          </section>

          <p className="text-sm text-muted-foreground pt-4 border-t">
            최종 수정일: 2025년 1월
          </p>
        </CardContent>
      </Card>
    </div>
  );
}
