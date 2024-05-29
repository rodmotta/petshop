import image from '../assets/dog_food.png'

function Card({ name, price, images }) {

    return (
        <div className="border rounded-lg bg-gray-100">
            <div>
                <img className='rounded-t-lg' src={images == null ? image : images[0].url} />
            </div>
            <div className='flex flex-row p-4 justify-between'>
                <div>
                    <h2 className='text-sm'>{name}</h2>
                    <p className='text-lg'>R$: {price}</p>
                </div>
                <div className='content-center'>
                    <button type="button" class="text-white bg-blue-700 hover:bg-blue-800 font-medium rounded-lg text-sm p-2.5 text-center">
                        <svg class="w-[20px] h-[20px] text-gray-800 dark:text-white" aria-hidden="true" xmlns="http://www.w3.org/2000/svg" width="24" height="24" fill="none" viewBox="0 0 24 24">
                            <path stroke="currentColor" stroke-linecap="round" stroke-linejoin="round" stroke-width="1.3" d="M5 4h1.5L9 16m0 0h8m-8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm8 0a2 2 0 1 0 0 4 2 2 0 0 0 0-4Zm-8.5-3h9.25L19 7h-1M8 7h-.688M13 5v4m-2-2h4" />
                        </svg>
                    </button>
                </div>
            </div>
        </div>
    )
}

export default Card