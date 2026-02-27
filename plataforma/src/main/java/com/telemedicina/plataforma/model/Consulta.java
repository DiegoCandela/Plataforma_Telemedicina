package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;

@Data
@Entity
@Table(name = "consultas")
public class Consulta {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;

    private String estado; // ACTIVA, FINALIZADA

    @ManyToOne
    private Paciente paciente;

    @ManyToOne
    private Medico medico;
}