import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Dialog, DialogTrigger, DialogContent, DialogTitle, DialogDescription, DialogHeader, DialogFooter } from "@/components/ui/dialog"
import { Button } from "@/components/ui/button"

import { Search } from "lucide-react"

import { useState } from "react"

import { saveCustomerAddress } from '../services/customerService'
import { getAddressByZipcode } from '../services/utilityService'

export function AddressDialog({ buttonText, title }) {
    const [zipcode, setZipcode] = useState(null)
    const [address, setAddress] = useState({})

    const handleZipcode = async (zipcode) => {
        const address = await getAddressByZipcode(zipcode)
        setAddress(address)
    }

    const handleAddressNumber = (event) => {
        const value = event.target.value
        address.number = value
        setAddress(address)
    }

    return (
        <Dialog>
            <DialogTrigger>
                <Button>{buttonText}</Button>
            </DialogTrigger>
            <DialogContent className='sm:max-w-[425px]'>
                <DialogTitle>{title}</DialogTitle>
                <DialogDescription className="flex flex-col gap-2">

                    <div className="flex justify-between items-end gap-4">
                        <div className="w-full">
                            <Label htmlFor="">CEP</Label>
                            <Input type="text" onChange={event => setZipcode(event.target.value)} />
                        </div>
                        <Button onClick={() => handleZipcode(zipcode)}><Search /></Button>
                    </div>

                    <div>
                        <Label htmlFor="">Endereço</Label>
                        <Input className='text-black' disabled value={address.street} />
                    </div>

                    <div className="flex gap-4">
                        <div>
                            <Label htmlFor="">Número</Label>
                            <Input onChange={handleAddressNumber} />
                        </div>
                        <div>
                            <Label htmlFor="">Bairro</Label>
                            <Input className='text-black' disabled value={address.district} />
                        </div>
                    </div>

                    <div className="flex gap-4">
                        <div>
                            <Label htmlFor="">Cidade</Label>
                            <Input className='text-black' disabled value={address.city} />
                        </div>
                        <div>
                            <Label htmlFor="">Estado</Label>
                            <Input className='text-black' disabled value={address.state} />
                        </div>
                    </div>

                </DialogDescription>
                <DialogFooter>
                    <Button variant='outline'>Cancelar</Button>
                    <Button onClick={() => saveCustomerAddress(address)}>Adicionar</Button>
                </DialogFooter>
            </DialogContent>
        </Dialog>
    )
}