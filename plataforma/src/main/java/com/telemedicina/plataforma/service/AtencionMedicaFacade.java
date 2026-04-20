package com.telemedicina.plataforma.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import com.telemedicina.plataforma.model.*;

@Service
@RequiredArgsConstructor
public class AtencionMedicaFacade {

    private final ConsultaService consultaService;

    public Consulta procesarAtencionCompleta(
            LocalDateTime fecha,
            Long pacienteId,
            Long medicoId,
            String tipoConsulta,
            String medicamento,
            String indicaciones,
            String tipoOrden,
            String estadoOrden) {

        Consulta consulta = consultaService.crearConsulta(
                fecha, pacienteId, medicoId, tipoConsulta);

        Prescripcion prescripcion = consultaService.crearPrescripcion(
                consulta.getId(),
                medicamento,
                indicaciones);

        OrdenMedica orden = consultaService.crearOrdenMedica(
                tipoOrden,
                estadoOrden);

        consultaService.mostrarPlanAtencion(consulta.getId());

        return consulta;
    }
}