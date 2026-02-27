package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.model.Usuario;

public abstract class UsuarioFactory {

    public abstract Usuario crearUsuario(String nombre, String correo);
}