package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;
import lombok.EqualsAndHashCode;

@Data
@EqualsAndHashCode(callSuper = true)
@Entity
@Table(name = "pacientes")
public class Paciente extends Usuario {

    private String documento;
}