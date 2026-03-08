package com.telemedicina.plataforma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.telemedicina.plataforma.dto.ConsultaRequest;
import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;

    @PostMapping
    public Consulta crearConsulta(@RequestBody ConsultaRequest request) {

        return consultaService.crearConsulta(
                request.getFecha(),
                request.getPacienteId(),
                request.getMedicoId());
    }
}