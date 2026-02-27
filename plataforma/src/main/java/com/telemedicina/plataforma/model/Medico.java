package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "medicos")
public class Medico extends Usuario {

    private String especialidad;
}