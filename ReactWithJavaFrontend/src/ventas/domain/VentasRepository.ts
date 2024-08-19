import { Venta } from "./Venta";


export interface VentasRepository{


    submit(venta: Venta): Promise<void>



}
