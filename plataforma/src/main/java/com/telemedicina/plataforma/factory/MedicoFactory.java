package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.model.Medico;
import com.telemedicina.plataforma.model.Usuario;

public class MedicoFactory extends UsuarioFactory {

    @Override
    public Usuario crearUsuario(String nombre, String correo) {
        Medico medico = new Medico();
        medico.setNombre(nombre);
        medico.setCorreo(correo);
        medico.setEspecialidad("General");
        return medico;
    }
}