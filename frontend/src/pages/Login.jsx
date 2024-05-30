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

    const handleInputChange = (event) => {
        const { name, value } = event.target
        if (name === 'username') {
            setUsername(value)
        } else if (name === 'password') {
            setPassword(value)
        }
    }

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

    const toggleLoading = () => {
        setLoading(prevLoading => !prevLoading)
    }

    return (
        <>
            <div className='flex justify-center items-center h-screen'>
                <div className='w-80 p-5 bg-gray-100 border border-gray-300 rounded-lg'>
                    {loading && <Spinner />}
                    <form onSubmit={handleSubmit}>
                        <InputText
                            label='Username'
                            type='text'
                            id='username'
                            name='username'
                            value={username}
                            onChange={handleInputChange}
                            required
                        />
                        <InputText
                            label='Password'
                            type='password'
                            id='password'
                            name='password'
                            value={password}
                            onChange={handleInputChange}
                            required
                        />
                        <SubmitButton text='Login' />
                    </form>
                </div>
            </div>
        </>
    )
}

export default Login