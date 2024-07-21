import { Input } from "@/components/ui/input"
import { Button } from "@/components/ui/button"
import { Sheet, SheetClose, SheetContent, SheetDescription, SheetFooter, SheetHeader, SheetTitle, SheetTrigger, } from "@/components/ui/sheet"
import { Card, CardContent, CardFooter, CardHeader, CardTitle, } from "@/components/ui/card"
import { ShoppingCart, Trash2, Minus, Plus } from "lucide-react"

export function CartDrawer() {
    
    return (
        <Sheet>
            <SheetTrigger asChild>
                <Button className='px-2 bg-black hover:bg-zinc-700'>
                    <ShoppingCart className="text-white" size={28} />
                </Button>
            </SheetTrigger>
            <SheetContent>
                <SheetHeader>
                    <SheetTitle>Carrinho de compras</SheetTitle>
                    <SheetDescription className="flex justify-between">
                        <h2>Produtos</h2>
                        <span>Limpar carrinho</span>
                    </SheetDescription>
                </SheetHeader>
                <Card className='my-4'>
                    <div className="grid grid-cols-3 p-4">
                        <img className="col-span-1" src="https://cobasi.vteximg.com.br/arquivos/ids/1045285-1000-1000/Racao-Premier-Formula-Caes-Adultos-Racas-Medias-Sabor-Frango-15kg-lateral.png?v=638169874375570000" alt="" />
                        <div className="col-span-2 pl-4">
                            <CardHeader className='p-0 pb-2'>
                                <CardTitle>Ração Premier Formula Cães Adultos Raças Médias Frango 15 kg</CardTitle>
                            </CardHeader>
                            <CardContent className='p-0 pb-2'>
                                <p>R$ 255,90</p>
                            </CardContent>
                            <CardFooter className='flex justify-end gap-4 p-0'>
                                <div className="flex">
                                    <Button className="px-2 bg-black hover:bg-zinc-700 rounded-r-none" type=""><Minus /></Button>
                                    <Input className="rounded-none" value="1" />
                                    <Button className="px-2 bg-black hover:bg-zinc-700 rounded-l-none" type=""><Plus /></Button>
                                </div>
                                <Button className="px-2 bg-black hover:bg-zinc-700" type=""><Trash2 /></Button>
                            </CardFooter>
                        </div>
                    </div>
                </Card>
                <SheetFooter>
                    <SheetClose asChild>
                        <Button type="submit">Checkout</Button>
                    </SheetClose>
                </SheetFooter>
            </SheetContent>
        </Sheet>
    )
}