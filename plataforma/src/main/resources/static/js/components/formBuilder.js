export class FormBuilder {

    constructor(container) {
        this.container = container;
        this.pasoActual = 0;
        this.datos = {};
        this.pasos = [];
    }

    agregarPaso(renderPaso) {
        this.pasos.push(renderPaso);
    }

    iniciar() {
        this.render();
    }

    siguiente() {
        this.pasoActual++;
        this.render();
    }

    anterior() {
        this.pasoActual--;
        this.render();
    }

    guardarDato(clave, valor) {
        this.datos[clave] = valor;
    }

    obtenerDatos() {
        return this.datos;
    }

    render() {
        this.container.innerHTML = "";
        this.pasos[this.pasoActual](this);
    }
}