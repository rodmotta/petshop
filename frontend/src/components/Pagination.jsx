function Pagination({ number, size, numberOfElements, first, last, totalPages, totalElements, onPageChange }) {

    return (
        <>
            <button className="p-3"
                disabled={first}
                onClick={() => onPageChange(number - 1)}
            >
                Previous
            </button>
            <button className="p-3">
                {number + 1}
            </button>
            <button className="p-3"
                disabled={last}
                onClick={() => onPageChange(number + 1)}
            >
                Next
            </button>
        </>
    )
}

export default Pagination