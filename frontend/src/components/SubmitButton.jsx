function InputText({ text }) {
    return (
        <input
            type='submit'
            value={text}
            className='text-white font-medium rounded-lg text-sm w-full px-5 py-2.5 text-center bg-blue-700 hover:bg-blue-800 focus:ring-4 focus:outline-none focus:ring-blue-300'
        />
    )
}

export default InputText