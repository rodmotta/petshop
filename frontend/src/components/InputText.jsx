function InputText({ label, type, id, name, value, onChange, required }) {
    return (
        <div className='mb-4'>
            <label
                htmlFor={id}
                className='font-medium block mb-2'>
                {label}
            </label>
            <input
                className='block w-full p-2.5 text-sm rounded-lg border border-gray-300 focus:ring-2 focus:outline-none focus:ring-blue-500'
                type={type}
                id={id}
                name={name}
                value={value}
                onChange={onChange}
                required={required}
            />
        </div>
    )
}

export default InputText