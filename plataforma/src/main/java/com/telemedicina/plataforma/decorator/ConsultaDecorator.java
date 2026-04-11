package com.telemedicina.plataforma.decorator;

public abstract class ConsultaDecorator implements ConsultaComponent {

    protected ConsultaComponent componente;

    public ConsultaDecorator(ConsultaComponent componente) {
        this.componente = componente;
    }

    @Override
    public void ejecutar() {
        componente.ejecutar();
    }
}