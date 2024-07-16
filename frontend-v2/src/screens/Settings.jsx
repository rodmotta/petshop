import { Input } from "@/components/ui/input"
import { Label } from "@/components/ui/label"
import { Dialog, DialogContent, DialogDescription, DialogHeader, DialogTitle, DialogTrigger, DialogFooter } from "@/components/ui/dialog"
import { Button } from "@/components/ui/button"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { Navbar } from "../components/Navbar"

import { getCustomerAddreses } from '../services/customerService'
import { useEffect, useState } from "react"

export function Settings() {
    const [addreses, setAddreses] = useState([])

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
