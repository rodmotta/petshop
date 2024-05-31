import Card from "../components/Card"
import NavBar from "../components/NavBar"
import Pagination from "../components/Pagination"
import ProductFilters from "../components/ProductFilters"
import SearchBar from "../components/SearchBar"
import Spinner from "../components/Spinner"
import { searchProducts } from "../services/searchProducts"
import { useEffect, useState } from "react"

function Index() {

    const [loading, setLoading] = useState(false)
    const [products, setProducts] = useState([])
    const [data, setData] = useState({})
    const [currentPageNumber, setCurrentPageNumber] = useState(0)
    const [order, setOrder] = useState('')
    const [searchQuery, setSearchQuery] = useState('')

    useEffect(() => {
        const fetchData = async (pageNumber, order, query) => {
            try {
                toggleLoading()
                const productsData = await searchProducts(pageNumber, order, query);
                setProducts(productsData.content);
                setData(productsData);
                toggleLoading()
            } catch (error) {
                console.error('Erro ao buscar os produtos:', error);
            }
        };
        fetchData(currentPageNumber, order, searchQuery);
    }, [currentPageNumber, order, searchQuery]);

    const onPageChange = (pageNumber) => {
        setCurrentPageNumber(pageNumber);
    }

    const handleOrderChange = (event) => {
        const value = event.target.value
        setOrder(value)
    }

    const handleSearch = (query) => {
        setSearchQuery(query)
        setCurrentPageNumber(0)
    }

    const toggleLoading = () => {
        setLoading(prevLoading => !prevLoading)
    }

    return (
        <>
            {loading && <Spinner />}
            <NavBar />
            <div className="container mx-auto max-w-screen-lg p-4">
                <div className="grid grid-cols-4 gap-4">
                    <div className="col-span-1 p-4 border rounded-lg bg-gray-100">
                        <ProductFilters orderChange={handleOrderChange} />
                    </div>
                    <div className="col-span-3">
                        <div className="mb-4">
                            <SearchBar onSearch={handleSearch} />
                            {searchQuery != "" && <span className="block mt-4">Results for "{searchQuery}"</span>}
                        </div>
                        <div className="grid grid-cols-3 gap-4">
                            {products.map(product =>
                                <Card name={product.name} price={product.price} images={product.images}></Card>
                            )}
                        </div>
                    </div>
                </div>
                <Pagination
                    number={data.number}
                    first={data.first}
                    last={data.last}
                    onPageChange={onPageChange} />
            </div>
        </>
    )
}

export default Index