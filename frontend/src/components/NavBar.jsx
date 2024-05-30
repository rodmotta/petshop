import { useState } from "react"
import { useNavigate } from "react-router-dom"

function NavBar() {

    const [loginOptionVisible, setLoginOptionVisible] = useState(false)
    const navigate = useNavigate()

    const toggleLoginOption = () => {
        return setLoginOptionVisible(!loginOptionVisible)
    }

    return (
        <nav className="bg-blue-600 p-4 shadow-md">
            <div className="container mx-auto flex justify-between items-center">
                <div className="text-white text-2xl font-bold">
                    <a onClick={() => navigate("/")}>
                        PETSHOP
                    </a>
                </div>
                <ul className="flex space-x-4">
                    <li>
                        <a className="text-white hover:text-gray-300"
                            onClick={() => navigate("/")}>
                            Home
                        </a>
                    </li>

                    <li>
                        <a className="text-white hover:text-gray-300"
                            onClick={() => navigate("/products")}>
                            Products
                        </a>
                    </li>
                    <li>
                        <a className="text-white hover:text-gray-300">
                            About
                        </a>
                    </li>
                </ul>
                <div className="flex gap-4">
                    <div>
                        <svg className="text-white size-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor">
                            <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 10.5V6a3.75 3.75 0 1 0-7.5 0v4.5m11.356-1.993 1.263 12c.07.665-.45 1.243-1.119 1.243H4.25a1.125 1.125 0 0 1-1.12-1.243l1.264-12A1.125 1.125 0 0 1 5.513 7.5h12.974c.576 0 1.059.435 1.119 1.007ZM8.625 10.5a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Zm7.5 0a.375.375 0 1 1-.75 0 .375.375 0 0 1 .75 0Z" />
                        </svg>
                    </div>
                    <div onClick={toggleLoginOption}>
                        <svg className="text-white size-7" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 24 24" strokeWidth={1.5} stroke="currentColor">
                            <path strokeLinecap="round" strokeLinejoin="round" d="M15.75 6a3.75 3.75 0 1 1-7.5 0 3.75 3.75 0 0 1 7.5 0ZM4.501 20.118a7.5 7.5 0 0 1 14.998 0A17.933 17.933 0 0 1 12 21.75c-2.676 0-5.216-.584-7.499-1.632Z" />
                        </svg>
                        {loginOptionVisible &&
                            <div className="absolute right-0 mt-2 w-48 bg-white border rounded-md shadow-lg z-20">
                                <ul>
                                    <li onClick={() => navigate("/signin")} className="px-4 py-2 hover:bg-gray-100 cursor-pointer">Login</li>
                                    <li onClick={() => navigate("/signup")} className="px-4 py-2 hover:bg-gray-100 cursor-pointer">Signup</li>
                                </ul>
                            </div>
                        }
                    </div>
                </div>
            </div>
        </nav>
    )
}

export default NavBar