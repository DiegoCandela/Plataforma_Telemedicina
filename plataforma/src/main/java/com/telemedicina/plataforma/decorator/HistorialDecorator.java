package com.telemedicina.plataforma.decorator;

public class HistorialDecorator extends ConsultaDecorator {

    public HistorialDecorator(ConsultaComponent componente) {
        super(componente);
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
        System.out.println("Guardando en historial clínico");
    }
}