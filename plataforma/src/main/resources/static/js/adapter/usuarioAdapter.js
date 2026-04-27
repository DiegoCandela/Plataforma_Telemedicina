import { crearUsuarioExterno } from "./externalService.js";

export const usuarioAdapter = {

    async crearUsuario(usuario) {

        // 🔹 Adaptación de formato
        const externo = {
            full_name: usuario.nombre,
            email_address: usuario.correo
        };

        return await crearUsuarioExterno(externo);
    }
};