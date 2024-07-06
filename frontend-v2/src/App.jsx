import { BrowserRouter, Routes, Route } from "react-router-dom";
import { Settings } from "./screens/Settings";
import { Main } from "./screens/Main";

export function App() {

  return (
    <BrowserRouter>
      <Routes>
        <Route path="/" element={<Main />} />
        <Route path="settings" element={<Settings />} />
      </Routes>
    </BrowserRouter>
  )
}
