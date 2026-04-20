package com.telemedicina.plataforma.composite;

import java.util.ArrayList;
import java.util.List;

public class PlanCompuesto implements PlanAtencion {

    private String nombre;
    private List<PlanAtencion> elementos = new ArrayList<>();

    public PlanCompuesto(String nombre) {
        this.nombre = nombre;
    }

    public void agregar(PlanAtencion elemento) {
        elementos.add(elemento);
    }

    @Override
    public void mostrar() {
        System.out.println("Plan: " + nombre);

        for (PlanAtencion elemento : elementos) {
            elemento.mostrar();
        }
    }
}