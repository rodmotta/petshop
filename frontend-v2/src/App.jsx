import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Settings } from "./pages/Settings";
import { Main } from "./pages/Main";
import { Login } from "./pages/Login";
import { Shop } from "./pages/Shop";

export function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="settings" element={<Settings />} />
        <Route path="login" element={<Login />} />
        <Route path="shop" element={<Shop />} />
      </Routes>
    </BrowserRouter>
  )
}
