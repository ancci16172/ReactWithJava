import { AuthContext, AuthContextProvider } from "./auth/infraestructure/context/AuthContext"
import { MainLogin } from "./auth/infraestructure/react/MainLogin"

function App() {
  
  
  return (
    <AuthContextProvider>

      <MainLogin></MainLogin>
    </AuthContextProvider>
  )
}

export default App
