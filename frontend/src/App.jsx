import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './pages/Login'
import CreateUser from './pages/CreateUser'
import NotFound from "./pages/NotFound";
import Products from "./pages/Products";
import Index from "./pages/Index";
import Main from "./pages/Main";
import UserSettings from "./pages/UserSettings";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="user-settings" element={<UserSettings />} />
        <Route path="index" element={<Index />} />
        <Route path="products" element={<Products />} />
        <Route path="signin" element={<Login />} />
        <Route path="signup" element={<CreateUser />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App