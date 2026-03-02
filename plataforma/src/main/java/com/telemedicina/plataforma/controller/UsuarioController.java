package com.telemedicina.plataforma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.telemedicina.plataforma.dto.UsuarioRequest;
import com.telemedicina.plataforma.model.Usuario;
import com.telemedicina.plataforma.service.UsuarioService;

@RestController
@RequestMapping("/usuarios")
@RequiredArgsConstructor
public class UsuarioController {

    private final UsuarioService usuarioService;

    @PostMapping
    public Usuario crearUsuario(@RequestBody UsuarioRequest request) {
        return usuarioService.crearUsuario(
                request.getTipo(),
                request.getNombre(),
                request.getCorreo()
        );
    }
}