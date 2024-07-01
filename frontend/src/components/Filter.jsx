import { useState } from 'react'
import { ChevronDown, ChevronUp } from 'lucide-react'

function Filter() {
    const [isBrandsOpen, setIsBrandsOpen] = useState(false);

    const toggleBrandsOpen = () => {
        setIsBrandsOpen(!isBrandsOpen);
    };

    const brands = [
        {
            id: 1,
            name: "PremieR Pet"
        },
        {
            id: 2,
            name: "Royal Canin"
        },
        {
            id: 3,
            name: "Golden"
        },
        {
            id: 4,
            name: "Whiskas"
        },
        {
            id: 5,
            name: "GranPlus"
        },
        {
            id: 6,
            name: "GoldeN"
        }
    ]

    return (
        <div>
            <div className='mb-4'>
                <div className="flex justify-between items-center cursor-pointer mb-2" onClick={toggleBrandsOpen}>
                    <h2 className="font-semibold">Marcas</h2>
                    {isBrandsOpen ? <ChevronUp size={20} /> : <ChevronDown size={20} />}
                </div>
                {isBrandsOpen && (
                    <div>
                        {brands.map(brand =>
                            <label key={brand.id} className="flex items-center mb-1">
                                <input
                                    type="checkbox"
                                    className="w-4 h-4 accent-purple-600" />
                                <span className="ml-2 text-md">{brand.name}</span>
                            </label>
                        )}
                    </div>
                )}
            </div>

            <div className="flex gap-2">
                <button className="flex-1 px-3 py-2 border-2 hover:border-purple-400 rounded-md items-center">Limpar</button>
                <button className="flex-1 px-3 py-2 bg-purple-300 hover:bg-purple-400 rounded-md items-center">Aplicar</button>
            </div>

        </div>
    )
}

export default Filter

{/*
<ul>
    <li>Ração</li>
    <li>Roupas e acessórios</li>
    <li>Brinquedos</li>
    <li>Coleiras e guias</li>
    <li>Caminhas e casinhas</li>
</ul>
*/}