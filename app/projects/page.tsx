import { prisma } from '@/lib/prisma';
import { Rocket, Hash, ImageOff } from 'lucide-react';
import Link from 'next/link';
import Image from 'next/image';
import { Badge } from '@/components/ui/badge';

export default async function ProjectsPage() {
  const projects = await prisma.project.findMany({
    where: { published: true },
    orderBy: [{ featured: 'desc' }, { order: 'asc' }],
  });

  return (
    <div className="max-w-6xl mx-auto">
      {/* 헤더 */}
      <header className="mb-8">
        <div className="flex items-center gap-3 mb-2">
          <Rocket className="w-8 h-8" />
          <h1 className="text-3xl font-bold">Projects</h1>
        </div>
        <p className="text-muted-foreground">
          개인 프로젝트와 사이드 프로젝트들을 소개합니다.
        </p>
      </header>

      {/* 프로젝트 카드 그리드 */}
      <div className="grid grid-cols-1 md:grid-cols-2 lg:grid-cols-3 gap-6">
        {projects.map((project) => (
          <Link
            key={project.id}
            href={`/projects/${project.id}`}
            className="group border rounded-xl overflow-hidden bg-card hover:shadow-lg transition-shadow"
          >
            {/* 썸네일 */}
            <div className="aspect-video bg-muted relative overflow-hidden">
              {project.thumbnail ? (
                <Image
                  src={project.thumbnail}
                  alt={project.title}
                  fill
                  className="object-cover group-hover:scale-105 transition-transform duration-300"
                />
              ) : (
                <div className="w-full h-full flex items-center justify-center bg-linear-to-br from-primary/10 to-primary/5">
                  <ImageOff className="w-12 h-12 text-muted-foreground/50" />
                </div>
              )}
            </div>

            {/* 카드 내용 */}
            <div className="p-4">
              <h2 className="text-xl font-semibold mb-2 group-hover:text-primary transition-colors">
                {project.title}
              </h2>

              {project.summary && (
                <p className="text-muted-foreground text-sm mb-3 line-clamp-2">
                  {project.summary}
                </p>
              )}

              {/* 기술 스택 */}
              {project.techStack.length > 0 && (
                <div className="flex flex-wrap gap-1.5">
                  {project.techStack.slice(0, 4).map((tech) => (
                    <Badge key={tech} variant="outline"
                      className="gap-1 hover:bg-primary hover:text-primary-foreground transition-colors"
                    >
                      <Hash className="w-3 h-3" />
                      {tech}
                    </Badge>
                  ))}
                  {project.techStack.length > 4 && (
                    <span className="text-xs text-muted-foreground">
                      +{project.techStack.length - 4}
                    </span>
                  )}
                </div>
              )}
            </div>
          </Link>
        ))}
      </div>

      {/* 프로젝트가 없을 때 */}
      {projects.length === 0 && (
        <div className="text-center py-20">
          <Rocket className="w-16 h-16 mx-auto text-muted-foreground/30 mb-4" />
          <p className="text-muted-foreground">아직 등록된 프로젝트가 없습니다.</p>
        </div>
      )}
    </div>
  );
}