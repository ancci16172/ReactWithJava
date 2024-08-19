import { Service } from "../domain/Service";
import { ServiceRepository } from "../domain/ServiceRepository";

export class InMemoryServiceRepository implements ServiceRepository{

    private services : Service[];

    constructor() {

        this.services = [{
            id: 0,
            nombre : "Pedidos",
            url : "/pedidos"
        },{
            id: 1,
            nombre : "Ventas",
            url : "/ventas"
        }] as Service[];
    }


    async getAllServices(): Promise<Service[]> {
        return this.services;
    }


}

