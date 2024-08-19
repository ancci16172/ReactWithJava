import { AuthContextProvider } from "./auth/infraestructure/context/AuthContext"
import { MainLogin } from "./auth/infraestructure/react/MainLogin"
import { Route, Routes } from "react-router-dom"
import { ReactNode } from "react"
import { MainServicePicker } from "./sections/service_picker/MainServicePicker"
import { RepositoryContextProvider } from "./sections/shared/context/RepositoryContainerContext"
import { MainVentas } from "./sections/ventas/MainVentas"
import { IsLoggedInRoutes } from "./sections/shared/routes/IsLoggedInRoutes"



function App() {
  
  
  return (
    <RepositoryContextProvider>

    <AuthContextProvider>
      <Routes>

        <Route path="/" element={<MainLogin />} />

        <Route element={<IsLoggedInRoutes />}>
          <Route path="/service_picker" element={<MainServicePicker />} />
          <Route path="/ventas" element={<MainVentas />} />
        </Route>

      </Routes>
    </AuthContextProvider>
    </RepositoryContextProvider>

  )
}

export default App
