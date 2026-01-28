import { LoginForm } from "@/components/login-form"

export default function LoginPage() {
  return (
    <div className="relative w-full max-w-sm">
      <div className="absolute -top-10 -left-10 w-48 h-24 bg-primary/40 rounded-full blur-3xl -z-10" />
      <div className="absolute -bottom-2 -right-20 w-48 h-24 bg-ring/60 rounded-3xl blur-3xl -z-10" />
      <LoginForm />
    </div>
  )
}