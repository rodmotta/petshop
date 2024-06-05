import { useState } from "react"
import { useNavigate } from "react-router-dom"

function NavBar() {

    const [loginOptionVisible, setLoginOptionVisible] = useState(false)
    const navigate = useNavigate()

    const toggleLoginOption = () => {
        return setLoginOptionVisible(!loginOptionVisible)
    }

    return (
        <nav className="bg-blue-700 p-4 shadow-md">
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
                            <path strokeLinecap="round" strokeLinejoin="round" d="M2.25 3h1.386c.51 0 .955.343 1.087.835l.383 1.437M7.5 14.25a3 3 0 0 0-3 3h15.75m-12.75-3h11.218c1.121-2.3 2.1-4.684 2.924-7.138a60.114 60.114 0 0 0-16.536-1.84M7.5 14.25 5.106 5.272M6 20.25a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Zm12.75 0a.75.75 0 1 1-1.5 0 .75.75 0 0 1 1.5 0Z" />
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
                                    <li onClick={() => navigate("/signup")} className="px-4 py-2 hover:bg-gray-100 cursor-pointer">Create account</li>
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