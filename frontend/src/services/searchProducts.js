import axios from 'axios';

export async function searchProducts(pageNumber) {
    try {
        const response = await axios.get(`http://localhost:8000/products?page=${pageNumber}&size=8`);
        return response.data
    } catch (error) {
        console.log(error)
        throw error;
    }
}