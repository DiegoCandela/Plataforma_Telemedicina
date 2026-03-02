package com.telemedicina.plataforma.dto;

import lombok.Data;

@Data
public class UsuarioRequest {

    private String tipo;
    private String nombre;
    private String correo;
}