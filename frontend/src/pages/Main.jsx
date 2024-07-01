import Filter from '../components/Filter'
import Card from '../components/Card'
import { ShoppingCart, User, Search } from 'lucide-react'

function Main() {

    const products = [
        {
            name: "Racao",
            price: 250.00
        },
        {
            name: "Racao",
            price: 250.00
        },
        {
            name: "Racao",
            price: 250.00
        },
        {
            name: "Racao",
            price: 250.00
        },
        {
            name: "Racao",
            price: 250.00
        }
    ]

    return (
        <div className="grid grid-cols-5 divide-x-2 divide-y-2">
            <div className="p-4 col-span-1">
            </div>
            <div className="flex justify-between p-4 col-span-4">
                <div className="flex rounded-md border-2">
                    <input className="py-2 px-4"
                        type="text"
                        placeholder="Buscar produto"
                        name=""
                        id="" />
                    <div className="items-center p-2 cursor-pointer">
                        <Search onClick={null} />
                    </div>
                </div>
                <div className="flex gap-4">
                    <div className="items-center border-2 rounded-md p-2 cursor-pointer">
                        <ShoppingCart onClick={null} />
                    </div>
                    <div className="items-center border-2 rounded-md p-2 cursor-pointer">
                        <User onClick={null} />
                    </div>
                </div>


            </div>
            <div className="p-4 col-span-1">
                <Filter />
            </div>
            <div className="p-4 col-span-4">
                <div className="grid grid-cols-4 gap-4">
                    {products.map(product =>
                        <Card name={product.name} price={product.price} images={product.images}></Card>
                    )}
                </div>
            </div>
        </div>
    )
}

export default Main