import { UserId } from "./value-objects/UserId";
import { Username } from "./value-objects/Username";

export type PrimitiveUser = {
    username : string,
    userId : number
}

export class User{
    private username : Username;
    private userId : UserId;
    constructor(username : Username,userId : UserId){
        this.username  = username;
        this.userId = userId;
    }

    static fromPrimitives(primitvesValues : PrimitiveUser) : User {
        
        const username = new Username(primitvesValues.username);
        const userId = new UserId(primitvesValues.userId);
        return new User(username,userId);

    }
    toPrimitives() : PrimitiveUser {
        return {
            username : this.username.value(),
            userId : this.userId.value()
        }
    }

}
