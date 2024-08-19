import { Service } from "../../domain/Service";
import { ServiceRepository } from "../../domain/ServiceRepository";

export class GetAllServicesService{

    constructor(private ServiceRepository : ServiceRepository){

    }

    async run() : Promise<Service[]> {

        return await this.ServiceRepository.getAllServices();
    }

}

