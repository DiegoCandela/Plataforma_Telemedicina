import { apiProxy } from "./apiProxy.js";

export const atencionFacade = {

    async procesarAtencionCompleta(data) {

        if (
            !data.fecha ||
            !data.pacienteId ||
            !data.medicoId ||
            !data.tipoConsulta ||
            !data.medicamento ||
            !data.tipoOrden
        ) {
            throw new Error("Datos incompletos para la atención completa");
        }

        const response = await fetch("http://localhost:8080/consultas/atencion-completa", {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Error en la atención completa");
        }

        return response.json();
    }

};