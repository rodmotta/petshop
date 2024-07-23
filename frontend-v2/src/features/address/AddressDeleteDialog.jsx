import { Dialog, DialogTrigger, DialogContent, DialogTitle, DialogDescription, DialogFooter, DialogClose } from "@/components/ui/dialog"
import { Button } from "@/components/ui/button"

import { deleteCustomerAddress } from "../../services/customerService"

export function AddressDeleteDialog({ addressId, whenWrite }) {

    const handleDeleteAddress = async () => {
        await deleteCustomerAddress(addressId)
        whenWrite()
    }

    return (
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
                    <DialogClose>
                        <DialogTrigger asChild>
                            <Button onClick={handleDeleteAddress}>Excluir</Button>
                        </DialogTrigger>
                    </DialogClose>
                </DialogFooter>
            </DialogContent>
        </Dialog>
    )
}