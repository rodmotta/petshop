import axios from 'axios';

export async function getCustomerAddreses() {
    try {
        const accessToken = localStorage.getItem('accessToken')
        const config = {
            headers: { Authorization: `Bearer ${accessToken}` }
        }
        const response = await axios.get('http://localhost:8000/customer/adresses', config);
        return response.data
    } catch (error) {
        throw error;
    }
}

export async function saveCustomerAddress(requestBody) {
    try {
        const accessToken = localStorage.getItem('accessToken')
        const config = {
            headers: { Authorization: `Bearer ${accessToken}` }
        }
        await axios.post('http://localhost:8000/customer/address', requestBody, config);
    } catch (error) {
        throw error;
    }
}

export async function updateCustomerAddress(addressId, requestBody) {
    try {
        const accessToken = localStorage.getItem('accessToken')
        const config = {
            headers: { Authorization: `Bearer ${accessToken}` }
        }
        await axios.put(`http://localhost:8000/customer/address/${addressId}`, requestBody, config);
    } catch (error) {
        throw error;
    }
}

export async function deleteCustomerAddress(addressId) {
    try {
        const accessToken = localStorage.getItem('accessToken')
        const config = {
            headers: { Authorization: `Bearer ${accessToken}` }
        }
        await axios.delete(`http://localhost:8000/customer/address/${addressId}`, config);
    } catch (error) {
        throw error;
    }
}