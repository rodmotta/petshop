import { Card } from "@/components/ui/card"
import { Select, SelectContent, SelectGroup, SelectItem, SelectLabel, SelectTrigger, SelectValue } from "@/components/ui/select"
import { Pagination, PaginationContent, PaginationEllipsis, PaginationItem, PaginationLink, PaginationNext, PaginationPrevious } from "@/components/ui/pagination"
import { Checkbox } from "@/components/ui/checkbox"

import { useEffect, useState } from "react"

import { getProducts } from '../services/productService'
import { getBrands } from '../services/brandService'
import { getPets } from '../services/petService'
import { getCategories } from '../services/categoryService'
import { Navbar } from "@/features/navbar/Navbar";

export function Shop() {
    const [products, setProducts] = useState({
        content: []
    })
    const [brands, setBrands] = useState([])
    const [pets, setPets] = useState([])
    const [categories, setCategories] = useState([])

    const [filter, setFilter] = useState({
        page: null,
        size: null,
        sort: null
    })

    useEffect(() => {
        const fetchProducts = async () => {
            const products = await getProducts(filter)
            setProducts(products)
        };
        const fetchBrands = async () => {
            const brands = await getBrands()
            setBrands(brands)
        };
        const fetchPets = async () => {
            const pets = await getPets()
            setPets(pets)
        };
        const fetchCategories = async () => {
            const categories = await getCategories()
            setCategories(categories)
        };
        fetchProducts();
        fetchBrands();
        fetchPets();
        fetchCategories();
    }, [filter]);

    const handleSortSelectChange = (value) => {
        setFilter(prevFilter => ({
            ...prevFilter,
            sort: value
        }));
    };

    return (
        <>
            <Navbar />
            <div className="max-w-screen-lg mx-auto">
                <div className="flex flex-row">
                    <div className="w-1/4 p-4">

                        <div className="mb-4">
                            <h3 className="text-md font-medium mb-2">
                                Animais
                            </h3>
                            {pets.map(pet => (
                                <div id={pet.id}>
                                    <Checkbox id={pet.name} />
                                    <label htmlFor={pet.name} className="text-md font-medium ml-2">
                                        {pet.name}
                                    </label>
                                </div>
                            ))}
                        </div>

                        <div className="mb-4">
                            <h3 className="text-md font-medium mb-2">
                                Marcas
                            </h3>
                            {brands.map(brand => (
                                <div id={brand.id}>
                                    <Checkbox id={brand.name} />
                                    <label htmlFor={brand.name} className="text-md font-medium ml-2">
                                        {brand.name}
                                    </label>
                                </div>
                            ))}
                        </div>

                        <div className="mb-4">
                            <h3 className="text-md font-medium mb-2">
                                Categorias
                            </h3>
                            {categories.map(category => (
                                <div id={category.id}>
                                    <Checkbox id={category.name} />
                                    <label htmlFor={category.name} className="text-md font-medium ml-2">
                                        {category.name}
                                    </label>
                                </div>
                            ))}
                        </div>
                    </div>
                    <div className="w-3/4 px-4">
                        <div className="flex justify-between py-4">
                            <p>{`Mostrando ${products.numberOfElements}-12 de ${products.totalElements} resultados.`}</p>
                            <Select onValueChange={handleSortSelectChange} >
                                <SelectTrigger className="w-[180px]">
                                    <SelectValue placeholder="Ordenar por" />
                                </SelectTrigger>
                                <SelectContent>
                                    <SelectGroup>
                                        <SelectLabel>Ordenar por</SelectLabel>
                                        <SelectItem value="price,ASC">Menor preço</SelectItem>
                                        <SelectItem value="price,DESC">Maior preço</SelectItem>
                                    </SelectGroup>
                                </SelectContent>
                            </Select>
                        </div>
                        <div className="grid grid-cols-3 gap-4">
                            {products.content.map(product => (
                                <Card key={product.id}>
                                    <img className="rounded-t-xl" src="https://images.petz.com.br/fotos/1656078196199.jpg" alt="" />
                                    <div className="p-4">
                                        <p className="font-bold">{product.name}</p>
                                        <p>{product.price}</p>
                                    </div>
                                </Card>
                            ))}
                        </div>
                        <div className="py-4">
                            <Pagination>
                                <PaginationContent>
                                    <PaginationItem>
                                        <PaginationPrevious href="#" />
                                    </PaginationItem>
                                    <PaginationItem>
                                        <PaginationLink href="#">1</PaginationLink>
                                    </PaginationItem>
                                    <PaginationItem>
                                        <PaginationLink href="#" isActive>
                                            2
                                        </PaginationLink>
                                    </PaginationItem>
                                    <PaginationItem>
                                        <PaginationLink href="#">3</PaginationLink>
                                    </PaginationItem>
                                    <PaginationItem>
                                        <PaginationEllipsis />
                                    </PaginationItem>
                                    <PaginationItem>
                                        <PaginationNext href="#" />
                                    </PaginationItem>
                                </PaginationContent>
                            </Pagination>
                        </div>
                    </div>
                </div>
            </div>
        </>
    )
}