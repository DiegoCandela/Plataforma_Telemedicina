package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "prescripciones")
public class Prescripcion {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String medicamento;
    private String indicaciones;

    @ManyToOne
    private Consulta consulta;
}