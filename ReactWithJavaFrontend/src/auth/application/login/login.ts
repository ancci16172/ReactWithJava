import { AuthRepository } from "../../domain/AuthRepository";

export const loginService = (authRepository : AuthRepository) => async (username: string, password: string) => {

    return await authRepository.login(username, password);
   
}
