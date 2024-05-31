import { useState } from 'react'

function SearchBar({ onSearch }) {

    const [query, setQuery] = useState('')

    const handleInputChange = (event) => {
        setQuery(event.target.value)
    };

    const handleSearchClick = () => {
        onSearch(query)
        setQuery('')
    }

    const handleKeyPress = (event) => {
        if (event.key === 'Enter') {
            handleSearchClick()
        }
    }

    return (
        <div className='flex gap-4'>
            <input className='w-full px-4 text-md rounded-lg border border-gray-300 focus:ring-2 focus:outline-none focus:ring-blue-500' type="text"
                name=""
                id=""
                value={query}
                onChange={handleInputChange}
                onKeyPress={handleKeyPress} //ajustar
                placeholder="Search for food, toys, accessories, etc."
                required
            />
            <button className='text-white p-3 rounded-lg bg-blue-700 hover:bg-blue-800'
                id=''
                onClick={handleSearchClick}>
                <svg xmlns="http://www.w3.org/2000/svg" viewBox="0 0 24 24" fill="currentColor" className="size-6">
                    <path fillRule="evenodd" d="M10.5 3.75a6.75 6.75 0 1 0 0 13.5 6.75 6.75 0 0 0 0-13.5ZM2.25 10.5a8.25 8.25 0 1 1 14.59 5.28l4.69 4.69a.75.75 0 1 1-1.06 1.06l-4.69-4.69A8.25 8.25 0 0 1 2.25 10.5Z" clipRule="evenodd" />
                </svg>
            </button>
        </div>
    )
}

export default SearchBar