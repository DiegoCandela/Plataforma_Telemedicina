import { Componente } from "./Componente.js";

export class Compuesto extends Componente {

    constructor(nombre) {
        super();
        this.nombre = nombre;
        this.hijos = [];
    }

    agregar(hijo) {
        this.hijos.push(hijo);
    }

    mostrar() {
        let html = `<li>${this.nombre}<ul>`;

        this.hijos.forEach(h => {
            html += h.mostrar();
        });

        html += "</ul></li>";

        return html;
    }
}