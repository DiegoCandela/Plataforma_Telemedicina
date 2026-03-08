package com.telemedicina.plataforma.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;
import java.util.Objects;

import com.telemedicina.plataforma.factory.*;
import com.telemedicina.plataforma.model.*;
import com.telemedicina.plataforma.repository.*;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PrescripcionRepository prescripcionRepository;
    private final OrdenMedicaRepository ordenMedicaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Consulta crearConsulta(LocalDateTime fecha, Long pacienteId, Long medicoId) {

        Objects.requireNonNull(pacienteId, "pacienteId no puede ser null");
        Objects.requireNonNull(medicoId, "medicoId no puede ser null");

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado"));

        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Medico no encontrado"));

        AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");

        Consulta consulta = factory.crearConsulta(paciente, medico);

        consulta.setFecha(fecha);

        return consultaRepository.save(consulta);
    }

    public Prescripcion crearPrescripcion(Long consultaId, String medicamento, String indicaciones) {

        Objects.requireNonNull(consultaId, "consultaId no puede ser null");

        Consulta consulta = consultaRepository.findById(consultaId)
                .orElseThrow(() -> new RuntimeException("Consulta no encontrada"));

        AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");

        Prescripcion prescripcion = factory.crearPrescripcion(
                consulta,
                medicamento,
                indicaciones);

        Objects.requireNonNull(prescripcion, "Error al crear la prescripción");

        return prescripcionRepository.save(prescripcion);
    }

    public OrdenMedica crearOrdenMedica(String tipoOrden, String estado) {

    AbstractMedicalFactory factory = FactoryProvider.getFactory("MEDICO");

    OrdenMedica orden = factory.crearOrdenMedica(tipoOrden, estado);

    Objects.requireNonNull(orden, "Error al crear la orden médica");

    return ordenMedicaRepository.save(orden);
}
}