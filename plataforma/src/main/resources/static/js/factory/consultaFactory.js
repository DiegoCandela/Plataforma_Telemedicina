import { ConsultaVirtual } from "./consultaVirtual.js";
import { ConsultaPresencial } from "./consultaPresencial.js";

export const consultaFactory = {

    crear(tipo) {

        if (tipo === "VIRTUAL") {
            return new ConsultaVirtual();
        }

        if (tipo === "PRESENCIAL") {
            return new ConsultaPresencial();
        }

        throw new Error("Tipo de consulta no válido");
    }
};