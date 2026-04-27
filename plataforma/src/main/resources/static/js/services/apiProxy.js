const API_URL = "http://localhost:8080/consultas";

export const apiProxy = {

    async crearConsulta(data) {

        if (!data.fecha || !data.pacienteId || !data.medicoId || !data.tipo) {
            throw new Error("Datos incompletos para crear la consulta");
        }

        const response = await fetch(API_URL, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Error al crear la consulta");
        }

        return response.json();
    },

    async crearPrescripcion(data) {

        if (!data.consultaId || !data.medicamento) {
            throw new Error("Datos incompletos para prescripción");
        }

        const response = await fetch(`${API_URL}/prescripcion`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Error al crear prescripción");
        }

        return response.json();
    },

    async crearOrden(data) {

        if (!data.tipoOrden || !data.estado) {
            throw new Error("Datos incompletos para orden médica");
        }

        const response = await fetch(`${API_URL}/orden`, {
            method: "POST",
            headers: {
                "Content-Type": "application/json"
            },
            body: JSON.stringify(data)
        });

        if (!response.ok) {
            throw new Error("Error al crear orden médica");
        }

        return response.json();
    },

    async clonarConsulta(id) {

        if (!id) {
            throw new Error("ID requerido para clonar");
        }

        const response = await fetch(`${API_URL}/clonar/${id}`, {
            method: "POST"
        });

        if (!response.ok) {
            throw new Error("Error al clonar consulta");
        }

        return response.json();
    },

    async obtenerPlan(id) {

        if (!id) {
            throw new Error("ID requerido para obtener plan");
        }

        const response = await fetch(`${API_URL}/${id}/plan`);

        if (!response.ok) {
            throw new Error("Error al obtener plan");
        }

        return response.text();
    }
};