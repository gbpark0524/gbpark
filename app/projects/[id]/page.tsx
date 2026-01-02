import { prisma } from '@/lib/prisma';
import { notFound } from 'next/navigation';
import { ArrowLeft, ExternalLink, Calendar } from 'lucide-react';
import Link from 'next/link';
import Image from 'next/image';

import dynamic from 'next/dynamic';
import { GithubIcon } from "@/components/icons"
import { Skeleton } from '@/components/ui/skeleton';

const MarkdownContent = dynamic(
  () => import('@/components/markdown-content'),
  {
    loading: () => (
      <div className="space-y-3">
        <Skeleton className="h-6 w-1/3" />
        <Skeleton className="h-4 w-full" />
        <Skeleton className="h-4 w-full" />
        <Skeleton className="h-4 w-2/3" />
        <Skeleton className="h-32 w-full" />
        <Skeleton className="h-4 w-full" />
        <Skeleton className="h-4 w-3/4" />
      </div>
    ),
  }
);

export const revalidate = 3600;

interface Props {
  params: Promise<{ id: string }>;
}

export default async function ProjectDetailPage({ params }: Props) {
  const { id } = await params;
  
  const project = await prisma.project.findUnique({
    where: { id: parseInt(id) },
  });

  if (!project) {
    notFound();
  }

  const formatDate = (date: Date | null) => {
    if (!date) return null;
    return new Intl.DateTimeFormat('ko-KR', {
      year: 'numeric',
      month: 'long',
    }).format(date);
  };

  return (
    <div className="max-w-4xl mx-auto">
      {/* 뒤로가기 */}
      <Link
        href="/projects"
        className="inline-flex items-center gap-2 text-muted-foreground hover:text-foreground mb-6 transition-colors"
      >
        <ArrowLeft className="w-4 h-4" />
        <span>프로젝트 목록</span>
      </Link>

      {/* 썸네일 */}
      {project.thumbnail && (
        <div className="aspect-video relative rounded-xl overflow-hidden mb-8">
          <Image
            src={project.thumbnail}
            alt={project.title}
            fill
            className="object-cover"
          />
        </div>
      )}

      {/* 헤더 */}
      <header className="mb-8">
        <div className="flex items-center gap-3 mb-4">
          {project.featured && (
            <span className="bg-primary text-primary-foreground text-xs px-2 py-1 rounded-full">
              Featured
            </span>
          )}
        </div>

        <h1 className="text-4xl font-bold mb-4">{project.title}</h1>

        {project.summary && (
          <p className="text-xl text-muted-foreground">{project.summary}</p>
        )}
      </header>

      {/* 메타 정보 */}
      <div className="flex flex-wrap gap-6 mb-8 pb-8 border-b">
        {/* 기간 */}
        {(project.startDate || project.endDate) && (
          <div className="flex items-center gap-2 text-muted-foreground">
            <Calendar className="w-4 h-4" />
            <span>
              {formatDate(project.startDate)}
              {project.endDate && ` - ${formatDate(project.endDate)}`}
              {!project.endDate && project.startDate && ' - 진행중'}
            </span>
          </div>
        )}

        {/* 링크들 */}
        <div className="flex gap-4">
          {project.githubUrl && (
            <a
              href={project.githubUrl}
              target="_blank"
              rel="noopener noreferrer"
              className="inline-flex items-center gap-2 px-4 py-2 bg-secondary text-secondary-foreground rounded-lg hover:bg-secondary/80 transition-colors"
            >
              <GithubIcon className="w-4 h-4" />
              <span>GitHub</span>
            </a>
          )}
          {project.demoUrl && (
            <a
              href={project.demoUrl}
              target="_blank"
              rel="noopener noreferrer"
              className="inline-flex items-center gap-2 px-4 py-2 bg-primary text-primary-foreground rounded-lg hover:bg-primary/90 transition-colors"
            >
              <ExternalLink className="w-4 h-4" />
              <span>Live Demo</span>
            </a>
          )}
        </div>
      </div>

      {/* 기술 스택 */}
      {project.techStack.length > 0 && (
        <section className="mb-8">
          <h2 className="text-lg font-semibold mb-3">기술 스택</h2>
          <div className="flex flex-wrap gap-2">
            {project.techStack.map((tech) => (
              <span
                key={tech}
                className="px-3 py-1.5 bg-secondary text-secondary-foreground rounded-lg text-sm"
              >
                {tech}
              </span>
            ))}
          </div>
        </section>
      )}

      {/* 본문 (마크다운) */}
      {project.content && (
        <MarkdownContent content={project.content} />
      )}
    </div>
  );
}
