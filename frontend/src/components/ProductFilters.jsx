function ProductFilters({ orderChange }) {
    return (
        <div>
            <label
                className="block font-medium mb-2"
                htmlFor="order">
                Order by:
            </label>
            <select
                className="w-full p-1.5 text-md rounded-lg border border-gray-300 focus:ring-2 focus:outline-none focus:ring-blue-500"
                id="order"
                onChange={orderChange}>
                <option value='' selected>None</option>
                <option value='price,ASC'>Lowest price</option>
                <option value='price,DESC'>Highest price</option>
            </select>
        </div>
    )
}

export default ProductFilters