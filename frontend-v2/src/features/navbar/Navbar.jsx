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
        <nav className="flex justify-end bg-black p-3 gap-2">
            <CartDrawer />
            {isValidToken()
                ? <ProfileDropdownMenu />
                : <Button className='px-2 bg-black hover:bg-zinc-700' onClick={() => navigate("/login")}>
                    <LogIn className="text-white" size={28} />
                </Button>}
        </nav>
    )
}