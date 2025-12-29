// src/app/page.tsx
import Link from "next/link";
import { BookOpen, FileText} from "lucide-react";
import { GithubIcon } from '@/components/icons/github';

export default function Home() {
  return (
    <main className="max-w-4xl mx-auto px-6 py-12">
      <header className="mb-12">
        <h2 className="text-4xl font-extrabold">Hello, World!</h2>
        <p className="text-lg text-gray-600">
          <span>I&apos;m GB Park.</span>
          <br />
        </p>
      </header>

      {/* 카드 그리드: 모바일은 1줄(grid-cols-1), 중간 화면부터는 2줄(md:grid-cols-2) */}
      <div className="grid grid-cols-1 md:grid-cols-2 gap-6">
        {/* 링크 1: GitHub */}
        <a
          href="https://github.com/gbpark0524"
          target="_blank"
          className="group p-6 border rounded-2xl hover:border-black transition-all bg-white shadow-sm"
        >
          <div className="flex items-center gap-3 mb-2">
            <GithubIcon/>
            <h3 className="font-bold text-xl">GitHub</h3>
          </div>
          <p className="text-gray-500 text-sm">
            진행했던 프로젝트와 소스 코드를 확인해 보세요.
          </p>
        </a>

        {/* 링크 2: 기술 블로그 */}
        <Link
          href="/dashboard"
          className="group p-6 border rounded-2xl hover:border-black transition-all bg-white shadow-sm"
        >
          <div className="flex items-center gap-3 mb-2">
            <BookOpen size={24} className="text-blue-500" />
            <h3 className="font-bold text-xl">Tech Blog</h3>
          </div>
          <p className="text-gray-500 text-sm">
            개발하며 겪은 시행착오와 해결 과정을 기록합니다.
          </p>
        </Link>

        {/* 링크 3: 추천 - Resume (이력서) */}
        <a
          href="/resume"
          className="hidden group p-6 border rounded-2xl hover:border-black transition-all bg-white shadow-sm"
        >
          <div className="flex items-center gap-3 mb-2">
            <FileText size={24} className="text-green-500" />
            <h3 className="font-bold text-xl">Resume</h3>
          </div>
          <p className="text-gray-500 text-sm">
            상세 경력 기술서와 보유 기술 스택을 정리했습니다.
          </p>
        </a>
      </div>
    </main>
  );
}
