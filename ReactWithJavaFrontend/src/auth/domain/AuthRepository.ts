import { AuthResponse } from "./AuthToken";
import { User } from "./User";

export interface AuthRepository {

    login(username: string, password: string): Promise<AuthResponse>;

    checkAuthenticated(): Promise<User>; //Check authentication by headers

}

