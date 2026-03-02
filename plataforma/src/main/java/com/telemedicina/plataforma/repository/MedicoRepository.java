package com.telemedicina.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telemedicina.plataforma.model.Medico;

public interface MedicoRepository extends JpaRepository<Medico, Long> {
}