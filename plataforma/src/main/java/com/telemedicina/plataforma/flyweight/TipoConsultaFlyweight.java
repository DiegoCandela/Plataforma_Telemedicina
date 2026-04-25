package com.telemedicina.plataforma.flyweight;

public class TipoConsultaFlyweight {

    private final String tipo;

    public TipoConsultaFlyweight(String tipo) {
        this.tipo = tipo;
    }

    public String getTipo() {
        return tipo;
    }

    public void mostrar() {
        System.out.println("Tipo de consulta: " + tipo);
    }
}