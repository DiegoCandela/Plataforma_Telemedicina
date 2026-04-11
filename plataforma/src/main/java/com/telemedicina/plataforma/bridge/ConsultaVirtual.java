package com.telemedicina.plataforma.bridge;

public class ConsultaVirtual implements TipoConsultaImplementor {

    @Override
    public void ejecutarTipoConsulta() {
        System.out.println("Ejecutando consulta virtual (videollamada)");
    }
}