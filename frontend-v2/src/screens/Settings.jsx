import { Navbar } from "../components/Navbar"

import { getCustomerAddreses } from '../services/customerService'
import { useEffect, useState } from "react"
import { AddressCard } from "@/components/address/AddressCard"
import { AddressFormDialog } from "@/components/address/AddressFormDialog"

export function Settings() {
    const [addreses, setAddreses] = useState([])

    useEffect(() => {
        const fetchAddreses = async () => {
            const addreses = await getCustomerAddreses()
            setAddreses(addreses)
        };
        fetchAddreses();
    }, []);

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
                            <AddressFormDialog buttonText={'Adicionar'} title={'Novo endereço'} />
                        </div>

                        {addreses.map(address => (
                            <AddressCard address={address} />
                        ))}

                    </div>
                </div>
            </div >
        </>
    )
}
