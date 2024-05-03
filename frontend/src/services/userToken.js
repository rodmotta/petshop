import axios from 'axios';

export async function userToken(username, password) {
    try {
        const response = await axios.post('http://localhost:8000/user/token', {
            username: username,
            password: password
        });
        localStorage.setItem('accessToken', response.data.accessToken)
        localStorage.setItem('refreshToken', response.data.refreshToken)
    } catch (error) {
        console.log(error)
        throw error;
    }
}