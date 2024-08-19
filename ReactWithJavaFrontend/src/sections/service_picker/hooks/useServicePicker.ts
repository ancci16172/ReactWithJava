import { useEffect, useState } from "react";
import { GetAllServicesService } from "../../../service_picker/application/get/GetAllServicesService";
import { ServiceRepository } from "../../../service_picker/domain/ServiceRepository";
import { Service } from "../../../service_picker/domain/Service";
import { useRepositoryContext } from "../../shared/context/RepositoryContainerContext";

export function useServicePicker() {
    const {serviceRepository} = useRepositoryContext();
    const [services,setServices] = useState([] as Service[]);

    async function getAllServices(){
        const serviceGetter = new GetAllServicesService(serviceRepository);
        const allServices = await serviceGetter.run();
        setServices(allServices);  
    }

    useEffect(() => {
        getAllServices();
    },[]);
    return {services};
}

