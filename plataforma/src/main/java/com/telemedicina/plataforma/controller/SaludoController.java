package com.telemedicina.plataforma.controller;

import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
public class SaludoController {

    @GetMapping("/")
    public String saludar() {
        return "Plataforma de Telemedicina funcionando correctamente 🚀";
    }
}