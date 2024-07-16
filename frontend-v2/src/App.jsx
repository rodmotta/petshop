import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Settings } from "./screens/Settings";
import { Main } from "./screens/Main";
import { Login } from "./screens/Login";

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
