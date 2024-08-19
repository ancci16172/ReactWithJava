
import React, { createContext, ReactNode, useState } from 'react';
import { InMemoryServiceRepository } from '../../../service_picker/infraestructure/InMemoryServiceRepository';
import { ServiceRepository } from '../../../service_picker/domain/ServiceRepository';

interface RepositoryContextData {
  serviceRepository: ServiceRepository
}

interface AuthProviderProps {
  children: ReactNode;
}

export const RepositoryContext = createContext({} as RepositoryContextData);

export function RepositoryContextProvider({children} : AuthProviderProps) {
    const serviceRepository : ServiceRepository = new InMemoryServiceRepository();



  return (
    <RepositoryContext.Provider value={{serviceRepository}}>
      {children}
    </RepositoryContext.Provider>
  )

}

export const useRepositoryContext = () => React.useContext(RepositoryContext);