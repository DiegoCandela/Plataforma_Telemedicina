import { FormBuilder } from "../components/formBuilder.js";
import { apiProxy } from "../services/apiProxy.js";
import { BaseComponent } from "../decorators/baseComponent.js";
import { NotificacionDecorator } from "../decorators/notificacionDecorator.js";
import { HistorialDecorator } from "../decorators/historialDecorator.js";
import { Compuesto } from "../composite/Compuesto.js";
import { Hoja } from "../composite/Hoja.js";
import { usuarioAdapter } from "../adapter/usuarioAdapter.js";
import { consultaFactory } from "../factory/consultaFactory.js";

export function renderConsultaView(container) {

    const builder = new FormBuilder(container);

    // 🔹 PASO 1 - Paciente
    builder.agregarPaso((b) => {
        b.container.innerHTML = `
        <div class="card">
            <h2>Paso 1: Paciente</h2>
            <input type="number" id="pacienteId" placeholder="ID Paciente" />
            <button id="next">Siguiente</button>
        </div>
        `;

        document.getElementById("next").onclick = () => {
            const val = document.getElementById("pacienteId").value;
            b.guardarDato("pacienteId", val);
            b.siguiente();
        };
    });

    // 🔹 PASO 2 - Médico
    builder.agregarPaso((b) => {
        b.container.innerHTML = `
        <div class="card">
            <h2>Paso 2: Médico</h2>
            <input type="number" id="medicoId" placeholder="ID Médico" />
            <button id="back">Atrás</button>
            <button id="next">Siguiente</button>
        </div>
        `;

        document.getElementById("back").onclick = () => b.anterior();

        document.getElementById("next").onclick = () => {
            const val = document.getElementById("medicoId").value;
            b.guardarDato("medicoId", val);
            b.siguiente();
        };
    });

    // 🔹 PASO 3 - Tipo + Fecha
    builder.agregarPaso((b) => {
        b.container.innerHTML = `
        <div class="card">
            <h2>Paso 3: Consulta</h2>
            <input type="datetime-local" id="fecha" />
            <select id="tipo">
                <option value="VIRTUAL">Virtual</option>
                <option value="PRESENCIAL">Presencial</option>
            </select>
            <button id="back">Atrás</button>
            <button id="next">Crear</button>
        </div>
        `;

        document.getElementById("back").onclick = () => b.anterior();

        document.getElementById("next").onclick = async () => {
            const fecha = document.getElementById("fecha").value;
            const tipo = document.getElementById("tipo").value;

            b.guardarDato("fecha", fecha);
            b.guardarDato("tipo", tipo);

            try {

                // 🔹 Ajustar fecha (IMPORTANTE)
                let fecha = document.getElementById("fecha").value;

                if (fecha && fecha.length === 16) {
                    fecha = fecha + ":00";
                }

                b.guardarDato("fecha", fecha);

                // 🔹 Convertir IDs a número
                b.guardarDato("pacienteId", Number(b.obtenerDatos().pacienteId));
                b.guardarDato("medicoId", Number(b.obtenerDatos().medicoId));

                const res = await apiProxy.crearConsulta(b.obtenerDatos());

                // 🔹 DECORATOR
                let componente = new BaseComponent();
                componente = new NotificacionDecorator(componente);
                componente = new HistorialDecorator(componente);

                componente.render("Consulta creada correctamente");

                // 🔹 COMPOSITE (VISUAL)
                const plan = new Compuesto("Plan de Atención");

                const prescripciones = new Compuesto("Prescripciones");
                prescripciones.agregar(new Hoja("Paracetamol"));
                prescripciones.agregar(new Hoja("Ibuprofeno"));

                const ordenes = new Compuesto("Órdenes Médicas");
                ordenes.agregar(new Hoja("Examen de sangre"));
                ordenes.agregar(new Hoja("Radiografía"));

                plan.agregar(prescripciones);
                plan.agregar(ordenes);

                // 🔹 Mostrar en pantalla
                const contenedor = document.createElement("div");
                contenedor.innerHTML = `<h3>Plan generado:</h3><ul>${plan.mostrar()}</ul>`;

                container.appendChild(contenedor);

                console.log(res);
                await usuarioAdapter.crearUsuario({
                    nombre: "Paciente Demo",
                    correo: "demo@email.com"
                });

                const tipo = b.obtenerDatos().tipo;

                const consultaObj = consultaFactory.crear(tipo);

                console.log(consultaObj.render());

            } catch (error) {
                alert(error.message);
            }
        };
    });

    builder.iniciar();
}