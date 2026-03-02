package com.telemedicina.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telemedicina.plataforma.model.Consulta;

public interface ConsultaRepository extends JpaRepository<Consulta, Long> {
}