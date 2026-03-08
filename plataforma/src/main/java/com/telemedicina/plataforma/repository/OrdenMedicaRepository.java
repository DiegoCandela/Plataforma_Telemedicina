package com.telemedicina.plataforma.repository;

import org.springframework.data.jpa.repository.JpaRepository;
import com.telemedicina.plataforma.model.OrdenMedica;

public interface OrdenMedicaRepository extends JpaRepository<OrdenMedica, Long> {
}