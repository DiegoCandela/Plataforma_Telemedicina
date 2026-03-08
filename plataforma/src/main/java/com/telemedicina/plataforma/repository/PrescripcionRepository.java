package com.telemedicina.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telemedicina.plataforma.model.Prescripcion;

public interface PrescripcionRepository extends JpaRepository<Prescripcion, Long> {
}