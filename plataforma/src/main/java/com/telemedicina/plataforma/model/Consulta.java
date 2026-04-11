package com.telemedicina.plataforma.model;

import jakarta.persistence.*;
import lombok.Data;
import java.time.LocalDateTime;

import com.telemedicina.plataforma.bridge.TipoConsultaImplementor;
import com.fasterxml.jackson.annotation.JsonIgnore;

@Data
@Entity
@Table(name = "consultas")
public class Consulta implements Cloneable {

    @Id
    @GeneratedValue(strategy = GenerationType.IDENTITY)
    private Long id;
    private String estado;
    private LocalDateTime fecha;

    @ManyToOne
    @JoinColumn(name = "paciente_id", nullable = false)
    private Paciente paciente;

    @ManyToOne
    @JoinColumn(name = "medico_id", nullable = false)
    private Medico medico;

    // Patron Prototype
    @Override
    public Consulta clone() {
        try {
            Consulta copia = (Consulta) super.clone();
            copia.setId(null);
            return copia;

        } catch (CloneNotSupportedException e) {
            throw new RuntimeException("Error al clonar la consulta");
        }
    }

    // Patron Bridge

    @Transient
    @JsonIgnore
    private TipoConsultaImplementor tipoConsulta;

    public void ejecutarConsulta() {
        if (tipoConsulta != null) {
            tipoConsulta.ejecutarTipoConsulta();
        }
    }
}