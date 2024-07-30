import axios from 'axios';

export async function getCategories() {
    try {
        const response = await axios.get('http://localhost:8000/categories')
        return response.data
    } catch (error) {
        throw error
    }
}