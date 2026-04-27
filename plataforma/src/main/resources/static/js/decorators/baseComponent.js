import { UIComponent } from "./uiComponent.js";

export class BaseComponent extends UIComponent {

    render(mensaje) {
        console.log("Mensaje:", mensaje);
    }
}