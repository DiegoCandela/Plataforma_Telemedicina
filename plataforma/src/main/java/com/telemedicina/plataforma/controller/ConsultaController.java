package com.telemedicina.plataforma.controller;

import lombok.RequiredArgsConstructor;
import org.springframework.web.bind.annotation.*;

import com.telemedicina.plataforma.dto.*;
import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.model.OrdenMedica;
import com.telemedicina.plataforma.model.Prescripcion;
import com.telemedicina.plataforma.service.AtencionMedicaFacade;
import com.telemedicina.plataforma.service.ConsultaService;

@RestController
@RequestMapping("/consultas")
@RequiredArgsConstructor
public class ConsultaController {

    private final ConsultaService consultaService;
    private final AtencionMedicaFacade atencionMedicaFacade;

    @PostMapping("/atencion-completa")
    public Consulta atencionCompleta(@RequestBody AtencionRequest request) {

        return atencionMedicaFacade.procesarAtencionCompleta(
                request.getFecha(),
                request.getPacienteId(),
                request.getMedicoId(),
                request.getTipoConsulta(),
                request.getMedicamento(),
                request.getIndicaciones(),
                request.getTipoOrden(),
                request.getEstadoOrden());
    }

    @PostMapping
    public Consulta crearConsulta(@RequestBody ConsultaRequest request) {
        return consultaService.crearConsulta(
                request.getFecha(),
                request.getPacienteId(),
                request.getMedicoId(),
                request.getTipo());
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

    @PostMapping("/clonar/{id}")
    public Consulta clonarConsulta(@PathVariable Long id) {
        return consultaService.clonarConsulta(id);
    }

    @GetMapping("/{id}/plan")
    public String mostrarPlan(@PathVariable Long id) {
        consultaService.mostrarPlanAtencion(id);
        return "Plan mostrado en consola";
    }
}