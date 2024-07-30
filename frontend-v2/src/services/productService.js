import axios from 'axios';

export async function getProducts(filter) {
    try {
        const params = new URLSearchParams()

        if (filter.page !== null && filter.page !== undefined) {
            params.append('page', filter.page)
        }
        if (filter.sort !== null && filter.sort !== undefined) {
            params.append('sort', filter.sort)
        }

        const response = await axios.get(`http://localhost:8000/products?${params.toString()}`)
        return response.data
    } catch (error) {
        throw error
    }
}