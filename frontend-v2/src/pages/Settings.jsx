import { Navbar } from "@/features/navbar/Navbar"

import { getCustomerAddreses } from '../services/customerService'
import { useEffect, useState } from "react"
import { AddressCard } from "@/features/address/AddressCard"
import { AddressFormDialog } from "@/features/address/AddressFormDialog"
import useAuth from "@/hooks/useAuth"

export function Settings() {
    const [addreses, setAddreses] = useState([])
    const { isValidToken, logout } = useAuth()

    useEffect(() => {
        if (isValidToken()) {
            const fetchAddreses = async () => {
                const addreses = await getCustomerAddreses()
                setAddreses(addreses)
            };
            fetchAddreses()
            return
        }
        logout()
    }, []);

    const handleWhenWrite = async () => {
        const updatedAddreses = await getCustomerAddreses();
        setAddreses(updatedAddreses);
    }

    return (
        <>
            <Navbar />
            <div className="max-w-screen-lg mx-auto">
                <div className="grid grid-cols-7 gap-4 p-4">
                    <div className="col-span-2">
                        <ul>
                            <li className="px-4 py-2 rounded-lg font-semibold">Meus pedidos</li>
                            <li className="px-4 py-2 rounded-lg font-semibold bg-slate-100">Meus enderecos</li>
                        </ul>
                    </div>
                    <div className="col-span-5 flex flex-col gap-4">

                        <div className='flex justify-end'>
                            <AddressFormDialog buttonText={'Adicionar'} title={'Novo endereço'} whenWrite={handleWhenWrite} />
                        </div>

                        {addreses.map(address => (
                            <AddressCard key={address.id} address={address} whenWrite={handleWhenWrite} />
                        ))}

                    </div>
                </div>
            </div >
        </>
    )
}
