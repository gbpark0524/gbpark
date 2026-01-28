// src/app/page.tsx
import Link from "next/link";
import { BookOpen, Rocket } from "lucide-react";
import {
  Card,
  CardHeader,
  CardTitle,
  CardDescription,
} from "@/components/ui/card";
import { MY_LINKS } from "@links";
import { CARD_HOVER } from "@styles";

export default function Home() {
  return (
    <div className="w-full max-w-3xl text-center space-y-12">
  <header className="space-y-4">
    <h1 className="text-5xl font-extrabold tracking-tight">
      Hello, World!
    </h1>
    <p className="text-xl text-muted-foreground">
      I&apos;m GB Park.
    </p>
  </header>

  <div className="grid grid-cols-1 sm:grid-cols-2 gap-6 text-left">
        <Link href="/projects">
          <Card className={CARD_HOVER}>
            <CardHeader>
              <CardTitle className="flex items-center gap-3">
                <Rocket /> Projects
              </CardTitle>
              <CardDescription>
                진행했던 프로젝트를 확인해 보세요.
              </CardDescription>
            </CardHeader>
          </Card>
        </Link>
        <Link href={MY_LINKS.BLOG}>
          <Card className={CARD_HOVER}>
            <CardHeader>
              <CardTitle className="flex items-center gap-3">
                <BookOpen size={24} className="text-blue-500" /> Tech Blog
              </CardTitle>
              <CardDescription>
                개발하며 겪은 시행착오와 해결 과정을 기록합니다.
              </CardDescription>
            </CardHeader>
          </Card>
        </Link>
      </div>
    </div>
  );
}
