package com.telemedicina.plataforma.controller;

import org.springframework.web.bind.annotation.*;
import lombok.RequiredArgsConstructor;
import java.util.List;

import com.telemedicina.plataforma.model.Paciente;
import com.telemedicina.plataforma.service.PacienteService;

@RestController
@RequestMapping("/pacientes")
@RequiredArgsConstructor
public class PacienteController {

    private final PacienteService pacienteService;

    @PostMapping
    public Paciente crear(@RequestBody Paciente paciente) {
        return pacienteService.guardar(paciente);
    }

    @GetMapping
    public List<Paciente> listar() {
        return pacienteService.listar();
    }
}