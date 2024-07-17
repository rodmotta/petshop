import { AddressDialog } from "@/components/AddressDialog";
import { Navbar } from "@/components/Navbar";

export function Main() {
    return (
        <>
            <Navbar />
            <AddressDialog
                buttonText='Adicionar endereço'
                title='Novo endereço' />
        </>
    )
}