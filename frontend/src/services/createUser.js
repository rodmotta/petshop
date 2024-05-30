import axios from 'axios';

export async function createUser(username, password, email, firstName, lastName) {
    try {
        await axios.post('http://localhost:8000/user', {
            username: username,
            password: password,
            email: email,
            firstName: firstName,
            lastName: lastName
        });
    } catch (error) {
        throw error;
    }
}