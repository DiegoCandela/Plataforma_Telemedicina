package com.telemedicina.plataforma.decorator;

import com.telemedicina.plataforma.model.Consulta;

public class ConsultaBase implements ConsultaComponent {

    private final Consulta consulta;

    public ConsultaBase(Consulta consulta) {
        this.consulta = consulta;
    }

    @Override
    public void ejecutar() {
        System.out.println("Ejecutando consulta base");
    }
}