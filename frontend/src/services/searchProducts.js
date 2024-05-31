import axios from 'axios';

export async function searchProducts(pageNumber, order, query) {
    try {
        const response = await axios.get(`http://localhost:8000/products?page=${pageNumber}&size=12&sort=${order}&name=${query}`);
        return response.data
    } catch (error) {
        throw error
    }
}