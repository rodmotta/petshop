import image from '../assets/dog_food.png'
import IconButton from "../components/IconButton"
import { ShoppingCart } from 'lucide-react'

function Card({ name, price, images }) {

    let brl = new Intl.NumberFormat('pt-BR', {
        style: 'currency',
        currency: 'BRL',
    });

    return (
        <div className="border-2 rounded-lg divide-y-2">
            <img className='rounded-t-lg' src={images == null ? image : images[0].url} />
            <div className='p-3'>
                <h2 className='text-lg'>{name}</h2>
                <div className='flex justify-between items-center'>
                    <div>
                        <p className='text-gray-500'>Preço:</p>
                        <span className='text-lg font-bold'>{brl.format(price)}</span>
                    </div>
                    <div>
                        <IconButton Icon={ShoppingCart} />
                    </div>
                </div>
            </div>
        </div>
    )
}

export default Card