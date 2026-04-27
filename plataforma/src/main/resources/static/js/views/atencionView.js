import { atencionFacade } from "../services/atencionFacade.js";

export function renderAtencionView(container) {

    container.innerHTML = `
        <h2>Atención Médica Completa</h2>

        <input type="number" id="pacienteId" placeholder="ID Paciente" /><br><br>
        <input type="number" id="medicoId" placeholder="ID Médico" /><br><br>

        <input type="datetime-local" id="fecha" /><br><br>

        <select id="tipoConsulta">
            <option value="VIRTUAL">Virtual</option>
            <option value="PRESENCIAL">Presencial</option>
        </select><br><br>

        <input type="text" id="medicamento" placeholder="Medicamento" /><br><br>
        <input type="text" id="indicaciones" placeholder="Indicaciones" /><br><br>

        <input type="text" id="tipoOrden" placeholder="Tipo Orden" /><br><br>
        <input type="text" id="estadoOrden" placeholder="Estado Orden" /><br><br>

        <button id="crear">Procesar Atención</button>
    `;

    document.getElementById("crear").onclick = async () => {

        try {

            let fecha = document.getElementById("fecha").value;

            if (fecha && fecha.length === 16) {
                fecha = fecha + ":00";
            }

            const data = {
                pacienteId: Number(document.getElementById("pacienteId").value),
                medicoId: Number(document.getElementById("medicoId").value),
                fecha: fecha,
                tipoConsulta: document.getElementById("tipoConsulta").value,
                medicamento: document.getElementById("medicamento").value,
                indicaciones: document.getElementById("indicaciones").value,
                tipoOrden: document.getElementById("tipoOrden").value,
                estadoOrden: document.getElementById("estadoOrden").value
            };

            console.log("Datos enviados:", data);

            const res = await atencionFacade.procesarAtencionCompleta(data);

            alert("Atención completa realizada con éxito");
            console.log(res);

        } catch (error) {
            alert(error.message);
            console.error(error);
        }
    };
}