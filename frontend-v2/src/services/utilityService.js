import axios from 'axios';

export async function getAddressByZipcode(zipcode) {
    try {
        const response =  await axios.get(`http://localhost:8000/utility/brazil-zipcode/${zipcode}/address`);
        return response.data
    } catch (error) {
        throw error;
    }
}