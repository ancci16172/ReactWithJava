
import React, { createContext, ReactNode, useState } from 'react';
import { ApiAuthRepository } from '../repository/ApiAuthRepository';
import { loginService } from '../../application/login/login';

interface AuthContextData {
  user: string;
  isAuthenticated: boolean;
  setUser: (newUser: string) => void;
  login: (username: string, password: string) => Promise<void>;
}

interface AuthProviderProps {
  children: ReactNode;
}

export const AuthContext = createContext({} as AuthContextData);

export function AuthContextProvider({ children }: AuthProviderProps) {
    const authRepository = new ApiAuthRepository();
    const [user, setUser] = useState('');
    const [isAuthenticated, setIsAuthenticated] = useState(false);


    const login = async (username: string, password: string) => {
      try {
        
        const AuthToken = await loginService(authRepository)(username, password);
        console.log(AuthToken);
      } catch (error) {
        console.log(error);
      }      

    }


    return (
        <AuthContext.Provider value={{ user, setUser,isAuthenticated ,login}}>
        {children}
        </AuthContext.Provider>
    );
}

export const useAuthContext = () => React.useContext(AuthContext);