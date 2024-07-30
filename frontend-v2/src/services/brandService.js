import axios from 'axios';

export async function getBrands() {
    try {
        const response = await axios.get('http://localhost:8000/brands')
        return response.data
    } catch (error) {
        throw error
    }
}