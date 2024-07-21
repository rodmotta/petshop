import { Card } from "@/components/ui/card"

import { useEffect, useState } from "react"

import { getProducts } from '../services/productService'

export function Product() {
    const [products, setProducts] = useState({
        content: []
    })

    useEffect(() => {
        const fetchProducts = async () => {
            const products = await getProducts()
            setProducts(products)
        };
        fetchProducts();
    }, []);

    return (
        <div className="max-w-screen-lg mx-auto">
            <div className="flex flex-row gap-4">
                <div className="w-1/4 bg-gray-200">
                </div>
                <div className="w-3/4 grid grid-cols-3 gap-4">
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
            </div>
        </div>
    )
}