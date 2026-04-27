export function crearUsuarioExterno(data) {

    console.log("📡 Enviando a sistema externo:", data);

    return Promise.resolve({
        status: "ok",
        data: data
    });
}