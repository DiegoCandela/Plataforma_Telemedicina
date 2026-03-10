package com.telemedicina.plataforma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.telemedicina.plataforma.dto.*;
import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.model.OrdenMedica;
import com.telemedicina.plataforma.model.Prescripcion;
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

    @PostMapping("/prescripcion")
    public Prescripcion crearPrescripcion(@RequestBody PrescripcionRequest request) {

        return consultaService.crearPrescripcion(
                request.getConsultaId(),
                request.getMedicamento(),
                request.getIndicaciones());
    }

    @PostMapping("/orden")
    public OrdenMedica crearOrden(@RequestBody OrdenMedicaRequest request) {

        return consultaService.crearOrdenMedica(
                request.getTipoOrden(),
                request.getEstado());
    }
}