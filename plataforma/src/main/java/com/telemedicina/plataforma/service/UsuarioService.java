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
        } 
        else if (tipo.equalsIgnoreCase("MEDICO")) {
            factory = new MedicoFactory();
        } 
        else {
            throw new IllegalArgumentException("Tipo de usuario inválido");
        }

        Usuario usuario = factory.crearUsuario(nombre, correo);

        if (usuario instanceof Paciente) {
            return pacienteRepository.save((Paciente) usuario);
        }

        if (usuario instanceof Medico) {
            return medicoRepository.save((Medico) usuario);
        }

        throw new IllegalArgumentException("Tipo de usuario inválido");
    }
}