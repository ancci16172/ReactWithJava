import { axios } from "../../../shared/infraestructure/axiosInstance";
import { Venta } from "../../domain/Venta";
import { VentasRepository } from "../../domain/VentasRepository";


export class ApiVentasRepository implements VentasRepository {

    async submit(venta: Venta): Promise<void> {
        const response = await axios.post("/api/ventas", venta);
        console.log(response);
    }

}
