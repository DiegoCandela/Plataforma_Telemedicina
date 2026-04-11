package com.telemedicina.plataforma.bridge;

public class ConsultaPresencial implements TipoConsultaImplementor {

    @Override
    public void ejecutarTipoConsulta() {
        System.out.println("Ejecutando consulta presencial");
    }
}   