import image from '../assets/dog_food.png'

function Card({ name, price, images }) {

    return (
        <div className="border rounded-lg">
            <img className='rounded-t-lg' src={images == null ? image : images[0].url} />
            <div className='p-3'>
                <div>
                    <h2 className='text-lg'>{name}</h2>
                    <p className='text-gray-600 text-md'>${price.toFixed(2)}</p>
                    <button type="button" className="w-full mt-3 text-sm p-2.5 flex items-center justify-center text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg">
                        Add to cart
                        <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="size-6 ml-3">
                            <path d="M2.25 2.25a.75.75 0 0 0 0 1.5h1.386c.17 0 .318.114.362.278l2.558 9.592a3.752 3.752 0 0 0-2.806 3.63c0 .414.336.75.75.75h15.75a.75.75 0 0 0 0-1.5H5.378A2.25 2.25 0 0 1 7.5 15h11.218a.75.75 0 0 0 .674-.421 60.358 60.358 0 0 0 2.96-7.228.75.75 0 0 0-.525-.965A60.864 60.864 0 0 0 5.68 4.509l-.232-.867A1.875 1.875 0 0 0 3.636 2.25H2.25ZM3.75 20.25a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0ZM16.5 20.25a1.5 1.5 0 1 1 3 0 1.5 1.5 0 0 1-3 0Z" />
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    )
}

export default Card