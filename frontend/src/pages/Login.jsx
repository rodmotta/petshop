import { useState } from 'react'
import InputText from '../components/InputText'
import SubmitButton from '../components/SubmitButton'
import { userToken } from '../services/userToken'
import Spinner from '../components/Spinner'
import { useNavigate } from "react-router-dom"

function Login() {

    const navigate = useNavigate()

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [loading, setLoading] = useState(false)

    const handleSubmit = async (event) => {
        event.preventDefault()
        toggleLoading()

        try {
            await userToken(username, password)
            navigate("/")
        } catch (error) {
            console.log(error)
            toggleLoading()
        }
    }

    const toggleLoading = () => setLoading(prevLoading => !prevLoading)

    return (
        <div className='flex justify-center items-center h-screen'>
            {loading && <Spinner />}
            <div className='w-80 p-5 bg-gray-100 border border-gray-300 rounded-lg'>
                <h1 className='text-3xl text-center mb-2 font-semibold'>Login</h1>
                <form onSubmit={handleSubmit}>
                    <InputText
                        label='Username'
                        type='text'
                        id='username'
                        name='username'
                        onChange={event => setUsername(event.target.value)}
                        required
                    />
                    <InputText
                        label='Password'
                        type='password'
                        id='password'
                        name='password'
                        onChange={event => setPassword(event.target.value)}
                        required
                    />
                    <SubmitButton text='Login' />
                </form>
                <div className='text-center mt-4'>
                    Don't have an account? Sign up
                </div>
            </div>
        </div>
    )
}

export default Login