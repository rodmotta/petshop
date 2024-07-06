import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger, DialogFooter } from "@/components/ui/dialog"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Navbar } from "../components/Navbar"

export function Settings() {

    const adresses = [
        {
            id: "2a4cfdf2-6334-4689-becb-40f5f1c4ff0d",
            zipCode: "79082020",
            street: "Rua Betim",
            number: 123,
            district: "Guanandi II",
            city: "Campo Grande",
            state: "MS"
        },
        {
            id: "d96a5310-17db-4a84-9b20-3d3c1a54fe2a",
            zipCode: "84060647",
            street: "Rua Praia de Ipanema",
            number: 123,
            district: "Contorno",
            city: "Ponta Grossa",
            state: "PR"
        },
        {
            id: "f39ab22c-c1c9-435b-8792-6753621e3bbf",
            zipCode: "69907840",
            street: "Rua das Flores",
            number: 123,
            district: "Belo Jardim I",
            city: "Rio Branco",
            state: "AC"
        }
    ]

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
                            <Dialog>
                                <DialogTrigger>
                                    <Button>Adicionar endereço</Button>
                                </DialogTrigger>
                                <DialogContent className='sm:max-w-[425px]'>
                                    <DialogHeader>
                                        <DialogTitle>Novo endereço</DialogTitle>
                                        <DialogDescription>
                                            <div className="my-4">
                                                <Label htmlFor="">CEP</Label>
                                                <Input />
                                            </div>
                                            <div className="mb-4">
                                                <Label htmlFor="">Endereço</Label>
                                                <Input />
                                            </div>
                                            <div className="flex gap-4">
                                                <div className="mb-4">
                                                    <Label htmlFor="">Número</Label>
                                                    <Input />
                                                </div>
                                                <div className="mb-4">
                                                    <Label htmlFor="">Bairro</Label>
                                                    <Input />
                                                </div>
                                            </div>
                                            <div className="mb-4">
                                                <Label htmlFor="">Complemento</Label>
                                                <Input />
                                            </div>
                                            <div className="flex gap-4">
                                                <div>
                                                    <Label htmlFor="">Cidade</Label>
                                                    <Input />
                                                </div>
                                                <div>
                                                    <Label htmlFor="">Estado</Label>
                                                    <Input />
                                                </div>
                                            </div>
                                        </DialogDescription>
                                    </DialogHeader>
                                    <DialogFooter>
                                        <Button type="" variant='outline'>Cancelar</Button>
                                        <Button type="submit">Adicionar</Button>
                                    </DialogFooter>
                                </DialogContent>
                            </Dialog>
                        </div>

                        {adresses.map(address => (
                            <Card>
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
