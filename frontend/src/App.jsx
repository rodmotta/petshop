import { BrowserRouter, Routes, Route } from "react-router-dom";
import Login from './pages/Login'
import CreateUser from './pages/CreateUser'
import NotFound from "./pages/NotFound";

function App() {
  return (
    <BrowserRouter>
      <Routes>
        <Route path="signin" element={<Login />} />
        <Route path="signup" element={<CreateUser />} />
        <Route path="*" element={<NotFound />} />
      </Routes>
    </BrowserRouter>
  )
}

export default App