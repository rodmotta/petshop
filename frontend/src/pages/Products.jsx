import Card from "../components/Card"
import NavBar from "../components/NavBar";
import Pagination from "../components/Pagination"
import { searchProducts } from "../services/searchProducts"
import { useEffect, useState } from "react";

function Index() {

    const [products, setProducts] = useState([])
    const [data, setData] = useState({})
    const [currentPageNumber, setCurrentPageNumber] = useState(0)

    useEffect(() => {
        const fetchData = async (pageNumber = 0) => {
            try {
                const productsData = await searchProducts(pageNumber)
                setProducts(productsData.content)
                setData(productsData)
            } catch (error) {
                console.error('Erro ao buscar os produtos:', error)
            }
        };
        fetchData(currentPageNumber);
    }, [currentPageNumber])

    const onPageChange = (pageNumber) => {
        setCurrentPageNumber(pageNumber);
    }

    return (
        <>
            <NavBar />
            <div className="container mx-auto max-w-screen-lg p-4">

                <form className="max-w-md mx-auto mb-5">
                    <label htmlFor="default-search" className="mb-2 text-sm font-medium text-gray-900 sr-only">Search</label>
                    <div className="relative">
                        <div className="absolute inset-y-0 start-0 flex items-center ps-3 pointer-events-none">
                            <svg className="w-4 h-4 text-gray-500 " aria-hidden="true" xmlns="http://www.w3.org/2000/svg" fill="none" viewBox="0 0 20 20">
                                <path stroke="currentColor" strokeLinecap="round" strokeLinejoin="round" strokeWidth="2" d="m19 19-4-4m0-7A7 7 0 1 1 1 8a7 7 0 0 1 14 0Z" />
                            </svg>
                        </div>
                        <input type="search" id="default-search" className="block w-full p-4 ps-10 text-sm text-gray-900 border border-gray-300 rounded-lg bg-gray-50 focus:ring-blue-500 focus:border-blue-500" placeholder="Buscar rações, acessorios, etc" required />
                        <button type="submit" className="text-white absolute end-2.5 bottom-2.5 bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300 font-medium rounded-lg text-sm px-4 py-2">Buscar</button>
                    </div>
                </form>

                <div className="grid grid-cols-1 sm:grid-cols-2 md:grid-cols-3 lg:grid-cols-4 gap-4">
                    {products.map(product =>
                        <Card name={product.name} price={product.price} images={product.images}></Card>
                    )}
                </div>

                <Pagination
                    number={data.number}
                    first={data.first}
                    last={data.last}
                    onPageChange={onPageChange}
                />
            </div>
        </>
    )
}

export default Index