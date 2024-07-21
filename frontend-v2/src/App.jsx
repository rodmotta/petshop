import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Settings } from "./pages/Settings";
import { Main } from "./pages/Main";
import { Login } from "./pages/Login";

export function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="settings" element={<Settings />} />
        <Route path="login" element={<Login />} />
      </Routes>
    </BrowserRouter>
  )
}
