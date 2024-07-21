import { jwtDecode } from 'jwt-decode';
import { useNavigate } from "react-router-dom"
import axios from 'axios';

const useAuth = () => {
    const navigate = useNavigate()

    const login = async (requestBody) => {
        try {
            const response = await axios.post('http://localhost:8000/user/token', requestBody);
            localStorage.setItem('accessToken', response.data.accessToken)
            localStorage.setItem('refreshToken', response.data.refreshToken)
            navigate('/')
        } catch (error) {
            throw error;
        }
    }

    const isValidToken = () => {
        const accessToken = localStorage.getItem('accessToken')

        if (accessToken) {
            try {
                const decodedToken = jwtDecode(accessToken)
                if (decodedToken.exp * 1000 > Date.now()) {
                    return true
                }
                removeLocalStorageTokens()
                return false
            } catch (error) {
                removeLocalStorageTokens()
                return false
            }
        }
        return false
    }

    const logout = () => {
        removeLocalStorageTokens()
        navigate("/login")
    }

    const removeLocalStorageTokens = () => {
        localStorage.removeItem('accessToken')
        localStorage.removeItem('refreshToken')
    }

    return { login, isValidToken, logout }
}

export default useAuth;