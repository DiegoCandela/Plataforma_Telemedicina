package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.model.Paciente;
import com.telemedicina.plataforma.model.Usuario;

public class PacienteFactory extends UsuarioFactory {

    @Override
    public Usuario crearUsuario(String nombre, String correo) {
        Paciente paciente = new Paciente();
        paciente.setNombre(nombre);
        paciente.setCorreo(correo);
        return paciente;
    }
}