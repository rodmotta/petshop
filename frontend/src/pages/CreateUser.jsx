import { useState } from 'react'
import InputText from '../components/InputText'
import SubmitButton from '../components/SubmitButton'
import { createUser } from '../services/createUser'
import Spinner from '../components/Spinner'
import { useNavigate } from "react-router-dom"

function CreateUser() {

    const navigate = useNavigate()

    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [loading, setLoading] = useState(false)

    const handleInputChange = (event) => {
        const { name, value } = event.target
        if (name === 'username') {
            setUsername(value)
        } else if (name === 'password') {
            setPassword(value)
        } else if (name === 'email') {
            setEmail(value)
        } else if (name === 'firstName') {
            setFirstName(value)
        } else if (name === 'lastName') {
            setLastName(value)
        }
    }

    const handleSubmit = async (event) => {
        event.preventDefault()
        toggleLoading()

        try {
            await createUser(username, password, email, firstName, lastName)
            navigate("/signin")
        } catch (error) {
            console.log(error)
        } finally {
            toggleLoading()
        }
    }

    const toggleLoading = () => {
        setLoading(prevLoading => !prevLoading)
    }

    return (
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
                    <InputText
                        label='Email'
                        type='email'
                        id='email'
                        name='email'
                        value={email}
                        onChange={handleInputChange}
                        required
                    />
                    <InputText
                        label='First name'
                        type='text'
                        id='firstName'
                        name='firstName'
                        value={firstName}
                        onChange={handleInputChange}
                        required
                    />
                    <InputText
                        label='Last name'
                        type='text'
                        id='lastName'
                        name='lastName'
                        value={lastName}
                        onChange={handleInputChange}
                        required
                    />
                    <SubmitButton text='Signup' />
                </form>
            </div>
        </div >
    )
}

export default CreateUser