package com.telemedicina.plataforma.flyweight;

import java.util.HashMap;
import java.util.Map;

public class TipoConsultaFactory {

    private static final Map<String, TipoConsultaFlyweight> tipos = new HashMap<>();

    public static TipoConsultaFlyweight getTipo(String tipo) {

        TipoConsultaFlyweight flyweight = tipos.get(tipo);

        if (flyweight == null) {
            flyweight = new TipoConsultaFlyweight(tipo);
            tipos.put(tipo, flyweight);
            System.out.println("Creando nuevo tipo: " + tipo);
        } else {
            System.out.println("Reutilizando tipo existente: " + tipo);
        }

        return flyweight;
    }
}