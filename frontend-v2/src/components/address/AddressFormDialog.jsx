import { Dialog, DialogTrigger, DialogContent, DialogTitle, DialogFooter, DialogClose } from "@/components/ui/dialog"
import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Button } from "@/components/ui/button"

import { Search } from "lucide-react"

import { useForm } from "react-hook-form"

import { saveCustomerAddress, updateCustomerAddress } from '../../services/customerService'
import { getAddressByZipcode } from '../../services/utilityService'

export function AddressFormDialog({ address, buttonText, title }) {

    const { register, handleSubmit, setValue, watch } = useForm({ values: address })

    const zipcode = watch('zipcode');

    const handleSearchAddress = async () => {
        const address = await getAddressByZipcode(zipcode);
        setValue('street', address.street);
        setValue('district', address.district);
        setValue('city', address.city);
        setValue('state', address.state);
    }

    const onSubmit = (data) => {
        if (address === undefined) {
            saveCustomerAddress(data)
            return
        }
        updateCustomerAddress(address.id, data)
    }

    return (
        <Dialog>
            <DialogTrigger>
                <Button>{buttonText}</Button>
            </DialogTrigger>
            <DialogContent className='sm:max-w-[425px]'>

                <form onSubmit={handleSubmit(onSubmit)} className="flex flex-col gap-2">
                    <DialogTitle>{title}</DialogTitle>

                    <div className="flex items-end gap-2">
                        <div className="w-full">
                            <Label htmlFor="zipcode">CEP</Label>
                            <Input id="zipcode" type="text" {...register('zipcode')} />
                        </div>
                        <Button type='button' onClick={() => handleSearchAddress()}><Search /></Button>
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

                    <DialogFooter>
                        <DialogClose>
                            <Button type='button' variant='outline'>Cancelar</Button>
                        </DialogClose>
                        <Button type='submit'>{buttonText}</Button>
                    </DialogFooter>

                </form>
            </DialogContent>
        </Dialog>
    )
}