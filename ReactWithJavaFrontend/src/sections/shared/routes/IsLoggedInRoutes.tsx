import { Navigate, Outlet } from "react-router-dom";
import { useAuthContext } from "../../../auth/infraestructure/context/AuthContext";

export function IsLoggedInRoutes() {
    const {isAuthenticated,isLoading} = useAuthContext();

    if(isLoading)
        return <div>Cargando...</div>
    if(isAuthenticated)
        return <Outlet/>
    
    return <Navigate to="/"/>
}

