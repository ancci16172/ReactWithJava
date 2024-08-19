import { useEffect, useState } from "react";
import { GetAllServicesService } from "../../service_picker/application/get/GetAllServicesService";
import { Service } from "../../service_picker/domain/Service";
import { InMemoryServiceRepository } from "../../service_picker/infraestructure/InMemoryServiceRepository";
import { useServicePicker } from "./hooks/useServicePicker";
import { ServiceCard } from "./ServiceCard";


export  function MainServicePicker() {
    
    const {services} = useServicePicker();
//    const services = await new GetAllServicesService(serviceRepository).run();

  

    return <div className="p-2">

        <h2 className="mb-4 text-2xl">Servicios disponibles : </h2>


        {services.map(service => <ServiceCard key={service.id} service={service} />)}
    

    </div>

}

