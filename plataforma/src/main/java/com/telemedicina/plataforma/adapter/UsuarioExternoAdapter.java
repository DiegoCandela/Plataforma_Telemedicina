package com.telemedicina.plataforma.adapter;

import com.telemedicina.plataforma.model.*;

public class UsuarioExternoAdapter implements UsuarioAdapter {

    private final UsuarioExterno usuarioExterno;

    public UsuarioExternoAdapter(UsuarioExterno usuarioExterno) {
        this.usuarioExterno = usuarioExterno;
    }

    @Override
    public Usuario adaptar() {

        Paciente paciente = new Paciente();
        paciente.setNombre(usuarioExterno.getNombreCompleto());
        paciente.setCorreo(usuarioExterno.getEmail());

        return paciente;
    }
}