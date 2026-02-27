package com.telemedicina.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telemedicina.plataforma.model.Paciente;

public interface PacienteRepository extends JpaRepository<Paciente, Long> {
}