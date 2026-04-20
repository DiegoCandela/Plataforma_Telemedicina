package com.telemedicina.plataforma.composite;

import com.telemedicina.plataforma.model.Prescripcion;

public class PrescripcionLeaf implements PlanAtencion {

    private Prescripcion prescripcion;

    public PrescripcionLeaf(Prescripcion prescripcion) {
        this.prescripcion = prescripcion;
    }

    @Override
    public void mostrar() {
        System.out.println("Prescripción: " +
                prescripcion.getMedicamento() + " - " +
                prescripcion.getIndicaciones());
    }
}