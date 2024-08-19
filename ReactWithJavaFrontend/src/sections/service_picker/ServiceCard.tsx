import { Link } from "react-router-dom";
import {Service} from "../../service_picker/domain/Service";

export function ServiceCard({service} : {service : Service}) {

    

    return <div>

        <h3>{service.nombre}</h3>
        <Link to={service.url} className="hover:underline hover:text-gray-600">
            Ir al servicio.
        </Link>

    </div>

}

