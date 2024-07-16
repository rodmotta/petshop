import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"

import { LoaderCircle } from "lucide-react"

import { useState } from 'react'
import { useNavigate } from 'react-router-dom'

import { getToken } from '../services/authService'

export function Login() {

    const navigate = useNavigate()

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [isLoading, setLoading] = useState(false)

    const handleSubmit = async (event) => {
        setLoading(true)
        event.preventDefault()

        try {
            await getToken(username, password)
            navigate("/")
        } catch (error) {
            console.log(error)
            setLoading(false)
        }
    }

    return (
        <div className="m-8 flex justify-center">
            <Card className="w-96">
                <form onSubmit={handleSubmit}>
                    <CardHeader>
                        <CardTitle>Login</CardTitle>
                    </CardHeader>
                    <CardContent>
                        <div className="mb-4">
                            <Label>Email</Label>
                            <Input type="text" onChange={event => setUsername(event.target.value)} />
                        </div>
                        <div>
                            <Label>Senha</Label>
                            <Input type="password" onChange={event => setPassword(event.target.value)} />
                        </div>
                    </CardContent>
                    <CardFooter>
                        {isLoading
                            ? <Button disabled className="w-full"><LoaderCircle className="animate-spin" /></Button>
                            : <Button className="w-full" type="submit">Entrar</Button>}
                    </CardFooter>
                </form>
            </Card>
        </div>
    )
}