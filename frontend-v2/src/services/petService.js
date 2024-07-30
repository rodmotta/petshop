import axios from 'axios';

export async function getPets() {
    try {
        const response = await axios.get('http://localhost:8000/pets')
        return response.data
    } catch (error) {
        throw error
    }
}