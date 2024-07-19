import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"

import { LoaderCircle, EyeOff, Eye } from "lucide-react"

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'
import { useForm } from "react-hook-form"

import { getToken } from '../services/authService'

export function Login() {

    const { register, handleSubmit } = useForm()

    const navigate = useNavigate()

    const [isLoading, setLoading] = useState(false)
    const [showPassword, setShowPassword] = useState(false);

    const togglePasswordVisibility = () => {
        setShowPassword(!showPassword);
    };

    const onSubmit = async (data) => {
        setLoading(true)
        try {
            await getToken(data)
            navigate('/')
        } finally {
            setLoading(false)
        }
    }

    return (
        <div className="my-8 mx-4 flex justify-center">
            <Card className="w-96">
                <form onSubmit={handleSubmit(onSubmit)}>
                    <CardHeader>
                        <CardTitle>Login</CardTitle>
                    </CardHeader>
                    <CardContent className="flex flex-col gap-2">
                        <div>
                            <Label>Usuário</Label>
                            <Input type="text" {...register('username')} />
                        </div>
                        <div>
                            <Label>Senha</Label>
                            <div className="relative">
                                <Input type={showPassword ? "text" : "password"} className='pr-10' {...register('password')} />
                                <Button
                                    type="button"
                                    variant="ghost"
                                    className="absolute right-0 top-0 px-2 hover:bg-transparent"
                                    onClick={togglePasswordVisibility}
                                >
                                    {showPassword ? <Eye /> : <EyeOff />}
                                </Button>
                            </div>
                        </div>
                    </CardContent>
                    <CardFooter>
                        {isLoading
                            ? <Button className="w-full" disabled><LoaderCircle className="animate-spin" /></Button>
                            : <Button className="w-full" type="submit">Entrar</Button>}
                    </CardFooter>
                </form>
            </Card>
        </div>
    )
}