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
    const [confirmPassword, setConfirmPassword] = useState('')
    const [email, setEmail] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [loading, setLoading] = useState(false)

    const handleSubmit = async (event) => {
        event.preventDefault()
        toggleLoading()

        try {
            await createUser(username, password, email, firstName, lastName)
            navigate("/signin")
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
                <h1 className='text-3xl text-center mb-2 font-semibold'>Create account</h1>
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
                    <InputText
                        label='Confirm password'
                        type='password'
                        id='confirmPassword'
                        name='confirmPassword'
                        onChange={event => setConfirmPassword(event.target.value)}
                        required
                    />
                    <InputText
                        label='Email'
                        type='email'
                        id='email'
                        name='email'
                        onChange={event => setEmail(event.target.value)}
                        required
                    />
                    <InputText
                        label='First name'
                        type='text'
                        id='firstName'
                        name='firstName'
                        onChange={event => setFirstName(event.target.value)}
                        required
                    />
                    <InputText
                        label='Last name'
                        type='text'
                        id='lastName'
                        name='lastName'
                        onChange={event => setLastName(event.target.value)}
                        required
                    />
                    <SubmitButton text='Signup' />
                </form>
            </div>
        </div >
    )
}

export default CreateUser