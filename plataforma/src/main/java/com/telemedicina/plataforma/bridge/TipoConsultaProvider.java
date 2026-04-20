package com.telemedicina.plataforma.bridge;

import org.springframework.stereotype.Component;

@Component
public class TipoConsultaProvider {

    public TipoConsultaImplementor obtener(String tipo) {

        if (tipo == null) {
            throw new IllegalArgumentException("El tipo de consulta no puede ser null");
        }

        switch (tipo.toUpperCase()) {
            case "VIRTUAL":
                return new ConsultaVirtual();

            case "PRESENCIAL":
                return new ConsultaPresencial();

            default:
                throw new IllegalArgumentException("Tipo de consulta inválido");
        }
    }
}