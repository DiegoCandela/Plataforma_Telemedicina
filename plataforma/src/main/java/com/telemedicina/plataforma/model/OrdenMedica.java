package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "ordenes_medicas")
public class OrdenMedica {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String tipoOrden; // LABORATORIO o FARMACIA
    private String estado;
}