import { AuthRepository } from "../../domain/AuthRepository";
import { PrimitiveUser, User } from "../../domain/User";

export class CheckIsValidAuthenticationService {
    private authRepository: AuthRepository;
    constructor(authRepository: AuthRepository) {
        this.authRepository = authRepository;
    }

    async run(): Promise<User> {
        const user : User = await this.authRepository.checkAuthenticated();

        return user;
    }

}


