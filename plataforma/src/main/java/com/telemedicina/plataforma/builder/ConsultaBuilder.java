package com.telemedicina.plataforma.builder;

import java.time.LocalDateTime;

import com.telemedicina.plataforma.model.Consulta;
import com.telemedicina.plataforma.model.Medico;
import com.telemedicina.plataforma.model.Paciente;

public class ConsultaBuilder {

    private Paciente paciente;
    private Medico medico;
    private String estado;
    private LocalDateTime fecha;

    public static ConsultaBuilder builder() {
        return new ConsultaBuilder();
    }

    public ConsultaBuilder paciente(Paciente paciente) {
        this.paciente = paciente;
        return this;
    }

    public ConsultaBuilder medico(Medico medico) {
        this.medico = medico;
        return this;
    }

    public ConsultaBuilder estado(String estado) {
        this.estado = estado;
        return this;
    }

    public ConsultaBuilder fecha(LocalDateTime fecha) {
        this.fecha = fecha;
        return this;
    }

    public Consulta build() {

        Consulta consulta = new Consulta();

        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setEstado(estado);
        consulta.setFecha(fecha);

        return consulta;
    }
}
