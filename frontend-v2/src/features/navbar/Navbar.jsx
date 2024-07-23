import { Button } from "@/components/ui/button"
import { ProfileDropdownMenu } from "./ProfileDropdownMenu"
import { CartDrawer } from "./CartDrawer"
import useAuth from "@/hooks/useAuth"
import { LogIn } from "lucide-react"
import { useNavigate } from "react-router-dom"

export function Navbar() {
    const navigate = useNavigate()

    const { isValidToken } = useAuth();

    return (
        <div className="flex justify-between bg-black">
            <div className="text-white flex items-center gap-2">
                <Button onClick={() => navigate("/")}>Inicio</Button>
                <Button onClick={() => navigate("/shop")}>Comprar</Button>
            </div>
            <div className="flex justify-end p-3 gap-2">
                <CartDrawer />
                {isValidToken()
                    ? <ProfileDropdownMenu />
                    : <Button className='px-2 bg-black hover:bg-zinc-700' onClick={() => navigate("/login")}>
                        <LogIn className="text-white" size={28} />
                    </Button>}
            </div>
        </div>
    )
}