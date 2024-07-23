import { Dialog, DialogTrigger, DialogContent, DialogTitle, DialogFooter, DialogClose } from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Button } from "@/components/ui/button"

import { Search } from "lucide-react"

import { useForm } from "react-hook-form"

import { saveCustomerAddress, updateCustomerAddress } from '../../services/customerService'
import { getAddressByZipcode } from '../../services/utilityService'
import { useState } from "react"

export function AddressFormDialog({ address, buttonText, title, whenWrite }) {

    const { register, handleSubmit, setValue, watch, reset } = useForm({ values: address })

    const zipcode = watch('zipcode');

    const [isModalOpen, setModalOpen] = useState(false)

    const handleSearchAddress = async () => {
        const address = await getAddressByZipcode(zipcode);
        setValue('street', address.street);
        setValue('district', address.district);
        setValue('city', address.city);
        setValue('state', address.state);
    }

    const onSubmit = async (data) => {
        try {
            if (!address) {
                await saveCustomerAddress(data);
            } else {
                await updateCustomerAddress(address.id, data);
            }
            whenWrite();
        } catch (error) {
            throw error;
        }
    }

    const openModal = () => {
        if (!address) {
            reset()
        }
        setModalOpen(!isModalOpen)
    }

    return (
        <Dialog open={isModalOpen} onOpenChange={openModal}>
            <DialogTrigger>
                <Button>{buttonText}</Button>
            </DialogTrigger>
            <DialogContent className='max-w-[425px] rounded-lg'>
                <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-2">
                    <DialogTitle>{title}</DialogTitle>
                    <div className="flex items-end gap-2">
                        <div className="w-full">
                            <Label htmlFor="zipcode">CEP</Label>
                            <Input id="zipcode" type="text" {...register('zipcode')} />
                        </div>
                        <Button type='button' onClick={handleSearchAddress}><Search /></Button>
                    </div>
                    <div>
                        <Label>Logradouro</Label>
                        <Input className='text-black' disabled {...register('street')} />
                    </div>
                    <div className="flex gap-2">
                        <div>
                            <Label htmlFor="number">Número</Label>
                            <Input id="number" {...register('number', { valueAsNumber: true })} />
                        </div>
                        <div>
                            <Label >Bairro</Label>
                            <Input className='text-black' disabled {...register('district')} />
                        </div>
                    </div>
                    <div className="flex gap-2">
                        <div>
                            <Label >Cidade</Label>
                            <Input className='text-black' disabled {...register('city')} />
                        </div>
                        <div>
                            <Label >Estado</Label>
                            <Input className='text-black' disabled {...register('state')} />
                        </div>
                    </div>
                    <DialogFooter className="flex-row justify-end gap-2 sm:space-x-0">
                        <DialogClose>
                            <Button type='button' variant='outline'>Cancelar</Button>
                        </DialogClose>
                        <DialogClose>
                            <DialogTrigger asChild>
                                <Button type='submit'>{buttonText}</Button>
                            </DialogTrigger>
                        </DialogClose>
                    </DialogFooter>
                </form>
            </DialogContent>
        </Dialog>
    )
}