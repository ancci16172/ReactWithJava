import { useEffect, useState } from "react";
import { useCookies } from "../../../shared/infraestructure/hooks/useCookies";
import { AuthRepository } from "../../domain/AuthRepository";
import { CheckIsValidAuthenticationService } from "../../application/authentication/CheckIsValidAuthenticationService";
import {  User } from "../../domain/User";


export function useAuthentication(authRepository : AuthRepository) {
    const COOKIE_FOR_AUTH = "auth_token";
    const {getCookie,deleteCookie} = useCookies();
    const authToken = getCookie(COOKIE_FOR_AUTH);
    const [isAuthenticated, setIsAuthenticated] = useState(false);
    const [isLoading, setIsLoading] = useState(true);
    const [user,setUser] = useState(null as User | null);

    async function checkAuthentication(){
        try {

            if(!authToken){
                console.log("No token, not authenticated");
                return setIsAuthenticated(false);
            }

            console.log("Has token, verifying...")

  
            const user  = await new CheckIsValidAuthenticationService(authRepository).run();
            console.log("Found user",user);
            
            setUser(user);
            setIsAuthenticated(true);
        } catch (error) {
            console.log("nO SE PUDO autenticar el token, token eliminado");
            setIsAuthenticated(false);
            deleteCookie(COOKIE_FOR_AUTH);
            console.log(error);
        }finally{
            setIsLoading(false);
        }

    }

    
    useEffect(() => {
        checkAuthentication()
    },[]);

    return {isAuthenticated,user,isLoading,checkAuthentication}
}

