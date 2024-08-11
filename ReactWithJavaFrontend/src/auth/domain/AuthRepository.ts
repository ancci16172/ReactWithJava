import { AuthResponse } from "./AuthToken";

export interface AuthRepository {

    login(username: string, password: string): Promise<AuthResponse>;

    checkAuthenticated(): Promise<boolean>;

}

