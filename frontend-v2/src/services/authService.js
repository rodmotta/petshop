import axios from 'axios';

export async function getToken(requestBody) {
    try {
        const response = await axios.post('http://localhost:8000/user/token', requestBody);
        localStorage.setItem('accessToken', response.data.accessToken)
        localStorage.setItem('refreshToken', response.data.refreshToken)
    } catch (error) {
        throw error;
    }
}