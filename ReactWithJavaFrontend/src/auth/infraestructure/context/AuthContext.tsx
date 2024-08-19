
import React, { createContext, ReactNode, useState } from 'react';
import { ApiAuthRepository } from '../repository/ApiAuthRepository';
import { loginService } from '../../application/login/login';
import { useAuthentication } from '../hook/useAuthentication';
import { User } from '../../domain/User';

interface AuthContextData {
  user: User | null;
  isAuthenticated: boolean;
  login: (username: string, password: string) => Promise<void>;
  isLoading: boolean;
}

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthContext = createContext({} as AuthContextData);

export function AuthContextProvider({ children }: AuthProviderProps) {
    const authRepository = new ApiAuthRepository();

    const {isAuthenticated, user,isLoading,checkAuthentication} = useAuthentication(authRepository);


    

    const login = async (username: string, password: string) => {
      try {
        
        const AuthToken = await loginService(authRepository)(username, password);
        console.log(AuthToken);
        await checkAuthentication()
      } catch (error) {
        console.log(error);
      }      

    }


    return (
        <AuthContext.Provider value={{ isAuthenticated ,login, user,isLoading}}>
        {children}
        </AuthContext.Provider>
    );
}

export const useAuthContext = () => React.useContext(AuthContext);