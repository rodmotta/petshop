import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"

import { AddressFormDialog } from "./AddressFormDialog"
import { AddressDeleteDialog } from "./AddressDeleteDialog"

export function AddressCard({ address, whenWrite }) {

    return (
        <Card>
            <CardHeader className='p-4 pb-0'>
                <CardTitle>{`${address.street}, ${address.number}`}</CardTitle>
            </CardHeader>
            <CardContent className='p-4 pb-0'>
                <p>{`${address.district}, ${address.city} - ${address.state}`}</p>
                <p>{`CEP: ${address.zipcode}`}</p>
            </CardContent>
            <CardFooter className='flex gap-2 p-4'>
                <AddressFormDialog address={address} buttonText={'Editar'} title={'Atualizar endereço'} whenWrite={whenWrite}>Editar</AddressFormDialog>
                <AddressDeleteDialog addressId={address.id} whenWrite={whenWrite}/>
            </CardFooter>
        </Card>
    )
}