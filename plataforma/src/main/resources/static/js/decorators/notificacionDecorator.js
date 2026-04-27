export class NotificacionDecorator {

    constructor(component) {
        this.component = component;
    }

    render(mensaje) {
        this.component.render(mensaje);
        alert("🔔 " + mensaje);
    }
}