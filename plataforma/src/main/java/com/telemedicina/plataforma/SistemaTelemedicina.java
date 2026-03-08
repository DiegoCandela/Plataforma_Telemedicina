package com.telemedicina.plataforma;

public class SistemaTelemedicina {

    private static SistemaTelemedicina instancia;

    private int consultasActivas;
    private boolean modoEmergencia;
    private int capacidadMaxima;

    private SistemaTelemedicina() {
        this.consultasActivas = 0;
        this.modoEmergencia = false;
        this.capacidadMaxima = 100; // capacidad normal
    }

    public static SistemaTelemedicina getInstancia() {
        if (instancia == null) {
            instancia = new SistemaTelemedicina();
        }
        return instancia;
    }

    public void activarModoEmergencia() {
        modoEmergencia = true;
        capacidadMaxima = 500; // aumenta capacidad
    }

    public void registrarConsulta() {
        if (consultasActivas < capacidadMaxima) {
            consultasActivas++;
        } else {
            System.out.println("Capacidad máxima alcanzada");
        }
    }

    public int getConsultasActivas() {
        return consultasActivas;
    }

    public boolean isModoEmergencia() {
        return modoEmergencia;
    }
}