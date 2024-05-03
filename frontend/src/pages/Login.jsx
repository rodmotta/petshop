import { useState } from 'react'
import InputText from '../components/InputText'
import SubmitButton from '../components/SubmitButton'
import { userToken } from '../services/userToken'

function Login() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [loading, setLoading] = useState(false)

    const handleInputChange = (event) => {
        const { name, value } = event.target
        if (name === 'username') {
            setUsername(value);
        } else if (name === 'password') {
            setPassword(value);
        }
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        setLoading(true)
        await userToken(username, password)
        setLoading(false)
    }

    return (
        <>
            <div className='flex justify-center items-center h-screen'>
                <div className='w-80 p-5 bg-gray-100 border border-gray-300 rounded-lg'>
                    <form onSubmit={handleSubmit}>
                        <InputText
                            label='Usuário'
                            type='text'
                            id='username'
                            name='username'
                            value={username}
                            onChange={handleInputChange}
                            required
                        />
                        <InputText
                            label='Senha'
                            type='password'
                            id='password'
                            name='password'
                            value={password}
                            onChange={handleInputChange}
                            required
                        />
                        <SubmitButton text='Entrar' loading={loading} />
                    </form>
                </div>
            </div>
        </>
    )
}

export default Login