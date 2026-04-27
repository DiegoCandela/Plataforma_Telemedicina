export class HistorialDecorator {

    constructor(component) {
        this.component = component;
    }

    render(mensaje) {
        this.component.render(mensaje);

        const log = document.getElementById("log");

        if (log) {
            const item = document.createElement("p");
            item.textContent = mensaje;
            log.appendChild(item);
        }
    }
}