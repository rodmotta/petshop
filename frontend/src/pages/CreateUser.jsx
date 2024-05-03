import { useState } from 'react'
import InputText from '../components/InputText'
import SubmitButton from '../components/SubmitButton'
import { createUser } from '../services/createUser'

function CreateUser() {
    const [username, setUsername] = useState('')
    const [password, setPassword] = useState('')
    const [email, setEmail] = useState('')
    const [firstName, setFirstName] = useState('')
    const [lastName, setLastName] = useState('')
    const [loading, setLoading] = useState(false)

    const handleInputChange = (event) => {
        const { name, value } = event.target
        if (name === 'username') {
            setUsername(value);
        } else if (name === 'password') {
            setPassword(value);
        } else if (name === 'email') {
            setEmail(value);
        } else if (name === 'firstName') {
            setFirstName(value);
        } else if (name === 'lastName') {
            setLastName(value);
        }
    }

    const handleSubmit = async (event) => {
        event.preventDefault();

        setLoading(true)
        await createUser(username, password, email, firstName, lastName)
        setLoading(false)
    }

    return (
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
                        label='Nome'
                        type='text'
                        id='firstName'
                        name='firstName'
                        value={firstName}
                        onChange={handleInputChange}
                        required
                    />
                    <InputText
                        label='Sobrenome'
                        type='text'
                        id='lastName'
                        name='lastName'
                        value={lastName}
                        onChange={handleInputChange}
                        required
                    />
                    <SubmitButton text='Cadastrar' loading={loading} />
                </form>
            </div>
        </div >
    )
}

export default CreateUser