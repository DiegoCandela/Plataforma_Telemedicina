import { Componente } from "./Componente.js";

export class Hoja extends Componente {

    constructor(nombre) {
        super();
        this.nombre = nombre;
    }

    mostrar() {
        return `<li>${this.nombre}</li>`;
    }
}