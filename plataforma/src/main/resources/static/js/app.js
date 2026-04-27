import { renderConsultaView } from "./views/consultaView.js";
import { renderAtencionView } from "./views/atencionView.js";

const app = document.getElementById("app");

// Función global para que HTML la pueda usar
window.cargarVista = function(vista) {

    const app = document.getElementById("app");
    app.innerHTML = "";

    if (vista === "consulta") {
        renderConsultaView(app);
    }

    if (vista === "atencion") {
        renderAtencionView(app);
    }
};