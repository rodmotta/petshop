import axios from 'axios';

export async function getCustomerAddreses() {
    try {
        const accessToken = localStorage.getItem('accessToken')
        const config = {
            headers: { Authorization: `Bearer ${accessToken}` }
        }
        const response =  await axios.get('http://localhost:8000/customer/adresses', config);
        return response.data
    } catch (error) {
        throw error;
    }
}