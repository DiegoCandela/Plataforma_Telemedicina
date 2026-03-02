package com.telemedicina.plataforma.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import java.time.LocalDateTime;

import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.model.Paciente;
import com.telemedicina.plataforma.model.Medico;

import com.telemedicina.plataforma.repository.ConsultaRepository;
import com.telemedicina.plataforma.repository.PacienteRepository;
import com.telemedicina.plataforma.repository.MedicoRepository;

@Service
@RequiredArgsConstructor
public class ConsultaService {

    private final ConsultaRepository consultaRepository;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Consulta crearConsulta(LocalDateTime fecha, long pacienteId, long medicoId) {

        if (fecha == null) {
            throw new IllegalArgumentException("La fecha no puede ser null");
        }

        Paciente paciente = pacienteRepository.findById(pacienteId)
                .orElseThrow(() -> new RuntimeException("Paciente no encontrado con id: " + pacienteId));

        Medico medico = medicoRepository.findById(medicoId)
                .orElseThrow(() -> new RuntimeException("Medico no encontrado con id: " + medicoId));

        Consulta consulta = new Consulta();
        consulta.setFecha(fecha);
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);

        return consultaRepository.save(consulta);
    }
}