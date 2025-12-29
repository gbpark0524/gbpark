# GB Park Portfolio

개인 포트폴리오 웹사이트입니다.

## Tech Stack

- **Framework**: Next.js 16, React 19
- **Language**: TypeScript
- **Database**: Supabase (PostgreSQL)
- **ORM**: Prisma 7
- **Styling**: Tailwind CSS 4, shadcn/ui
- **Markdown**: react-markdown, remark-gfm, rehype-highlight

## Getting Started

### 1. 의존성 설치

```bash
npm install
```

### 2. 환경변수 설정

`.env` 파일 생성:

```env
DATABASE_URL="postgresql://..."
DIRECT_URL="postgresql://..."
```

### 3. Prisma 클라이언트 생성

```bash
npx prisma generate
```

### 4. 개발 서버 실행

```bash
npm run dev
```

[http://localhost:3000](http://localhost:3000) 에서 확인

## Prisma 명령어

```bash
# 스키마 → DB 반영
npx prisma db push

# 클라이언트 재생성
npx prisma generate

# DB 초기화
npx prisma migrate reset
```

## 배포

Vercel + Supabase 조합으로 배포됩니다.
