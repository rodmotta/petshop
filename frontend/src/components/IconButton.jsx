function IconButton({ name, Icon, size }) {

    return (
        <div className='inline-flex gap-2 px-3 py-2 bg-purple-300 hover:bg-purple-400 rounded-md items-center cursor-pointer'>
            {name && <span className='font-semibold'>{name}</span>}
            {Icon && <Icon size={size} />}
        </div>
    )
}

export default IconButton