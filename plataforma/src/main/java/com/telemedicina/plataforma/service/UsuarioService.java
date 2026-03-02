package com.telemedicina.plataforma.service;

import org.springframework.stereotype.Service;
import lombok.RequiredArgsConstructor;

import com.telemedicina.plataforma.factory.*;
import com.telemedicina.plataforma.model.*;
import com.telemedicina.plataforma.repository.*;

@Service
@RequiredArgsConstructor
public class UsuarioService {

    private final PacienteRepository pacienteRepository;
    private final MedicoRepository medicoRepository;

    public Usuario crearUsuario(String tipo, String nombre, String correo) {

        UsuarioFactory factory;

        if (tipo.equalsIgnoreCase("PACIENTE")) {
            factory = new PacienteFactory();
            Usuario usuario = factory.crearUsuario(nombre, correo);
            Paciente paciente = (Paciente) usuario;

            if (paciente == null) {
                throw new IllegalArgumentException("Paciente no puede ser null");
            }

            return pacienteRepository.save(paciente);
        }

        if (tipo.equalsIgnoreCase("MEDICO")) {
            factory = new MedicoFactory();
            Usuario usuario = factory.crearUsuario(nombre, correo);
            Medico medico = (Medico) usuario;
            if (medico == null) {
                throw new IllegalArgumentException("Medico no puede ser null");
            }
            return medicoRepository.save(medico);
        }

        throw new IllegalArgumentException("Tipo de usuario no válido");
    }
}