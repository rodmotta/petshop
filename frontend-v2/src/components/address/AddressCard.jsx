import { Dialog, DialogTrigger, DialogContent, DialogTitle, DialogDescription, DialogHeader, DialogFooter, DialogClose } from "@/components/ui/dialog"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"

import { deleteCustomerAddress } from "../../services/customerService"
import { AddressFormDialog } from "./AddressFormDialog"

export function AddressCard({ address }) {

    const handleDeleteAddress = async () => {
        await deleteCustomerAddress(address.id)
    }

    return (
        <Card key={address.id}>
            <CardHeader className='p-4 pb-0'>
                <CardTitle>{`${address.street}, ${address.number}`}</CardTitle>
            </CardHeader>
            <CardContent className='p-4 pb-0'>
                <p>{`${address.district}, ${address.city} - ${address.state}`}</p>
                <p>{address.zipCode}</p>
            </CardContent>
            <CardFooter className='flex gap-2 p-4'>
                <AddressFormDialog address={address} buttonText={'Editar'} title={'Atualizar endereço'}>Editar</AddressFormDialog>
                <Dialog>
                    <DialogTrigger>
                        <Button variant='outline'>Excluir</Button>
                    </DialogTrigger>
                    <DialogContent className='sm:max-w-[425px]'>
                        <DialogTitle>Confirmação de exclusão</DialogTitle>
                        <DialogDescription>
                            <p>Tem certeza de que quer excluir o registro?</p>
                        </DialogDescription>
                        <DialogFooter>
                            <DialogClose>
                                <Button variant='outline'>Cancelar</Button>
                            </DialogClose>
                            <Button onClick={handleDeleteAddress}>Excluir</Button>
                        </DialogFooter>
                    </DialogContent>
                </Dialog>
            </CardFooter>
        </Card>
    )
}