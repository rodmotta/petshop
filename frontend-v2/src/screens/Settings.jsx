import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Navbar } from "../components/Navbar"

import { getCustomerAddreses } from '../services/customerService'
import { getAddressByZipcode } from '../services/utilityService'
import { useEffect, useState } from "react"
import { AddressDialog } from "@/components/AddressDialog"



export function Settings() {
    const [addreses, setAddreses] = useState([])
    const [zipcode, setZipcode] = useState(null)
    const [address, setAddress] = useState({})
    const [zipCodeLoading, setZipCodeLoading] = useState(false)

    const handleZipcode = async (zipcode) => {
        const address = await getAddressByZipcode(zipcode)
        setAddress(address)
    }

    const handleAddressNumber = async (event) => {
        const value = event.target.value
        address.number = value
        setAddress(address)
    }

    useEffect(() => {
        const fetchData = async () => {
            try {
                const addreses = await getCustomerAddreses()
                setAddreses(addreses)
            } catch (error) {
                console.error('Erro ao buscar os produtos:', error);
            }
        };
        fetchData();
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
                            <AddressDialog/>
                        </div>

                        {addreses.map(address => (
                            <Card key={address.id}>
                                <CardHeader className='p-4 pb-0'>
                                    <CardTitle>{`${address.street}, ${address.number}`}</CardTitle>
                                </CardHeader>
                                <CardContent className='p-4 pb-0'>
                                    <p>{`${address.district}, ${address.city} - ${address.state}`}</p>
                                    <p>{address.zipCode}</p>
                                </CardContent>
                                <CardFooter className='flex gap-4 p-4'>
                                    <Button type="" variant='outline'>Editar</Button>
                                    <Button type="" variant='outline'>Excluir</Button>
                                </CardFooter>
                            </Card>
                        ))}

                    </div>
                </div>
            </div >
        </>
    )
}
