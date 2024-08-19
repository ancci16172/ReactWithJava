import { axios } from "../../../shared/infraestructure/axiosInstance";
import { AuthRepository } from "../../domain/AuthRepository";
import { AuthResponse } from "../../domain/AuthToken";
import { PrimitiveUser, User } from "../../domain/User";

export class ApiAuthRepository implements AuthRepository {

    async login(username: string, password: string): Promise<AuthResponse> {
        try {
                
            const response = await axios.post("/auth/login", { username, password });
            console.log("response on axios");
            console.log(response);
            console.log(response.data);
        return {
            token: response.data.token
        }
        } catch (error) {
            console.log("error")
            console.log("error",error)                
        }
        return {
            token: "response.data.token"
        }
    }

    async checkAuthenticated(): Promise<User> {
        const response = await axios.get("/auth/verify");
        const primitveUser : PrimitiveUser = response.data;
        
        const user : User = User.fromPrimitives(primitveUser);

        return user;
    }

}



