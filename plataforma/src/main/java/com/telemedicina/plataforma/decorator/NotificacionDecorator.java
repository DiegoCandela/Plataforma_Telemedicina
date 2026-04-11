package com.telemedicina.plataforma.decorator;

public class NotificacionDecorator extends ConsultaDecorator {

    public NotificacionDecorator(ConsultaComponent componente) {
        super(componente);
    }

    @Override
    public void ejecutar() {
        super.ejecutar();
        System.out.println("Enviando notificación al paciente");
    }
}