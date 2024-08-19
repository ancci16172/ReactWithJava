import { Service } from "./Service";

export interface ServiceRepository{

    getAllServices() : Promise<Service[]>;

}

