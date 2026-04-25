package com.telemedicina.plataforma.proxy;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;
import java.time.LocalDateTime;
import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.repository.PacienteRepository;
import com.telemedicina.plataforma.repository.MedicoRepository;

@Service
@RequiredArgsConstructor
public class ConsultaServiceProxy implements ConsultaServiceProxyInterface {

    private final ConsultaServiceProxyInterface consultaService;
    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    @Override
    public Consulta crearConsulta(LocalDateTime fecha, Long pacienteId, Long medicoId, String tipo) {

        if (!pacienteRepository.existsById(pacienteId)) {
            throw new RuntimeException("Paciente no autorizado o no existe");
        }

        if (!medicoRepository.existsById(medicoId)) {
            throw new RuntimeException("Médico no autorizado o no existe");
        }

        System.out.println("Acceso validado por Proxy");

        return consultaService.crearConsulta(fecha, pacienteId, medicoId, tipo);
    }
}