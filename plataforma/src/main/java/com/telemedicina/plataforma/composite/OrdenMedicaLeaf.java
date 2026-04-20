package com.telemedicina.plataforma.composite;

import com.telemedicina.plataforma.model.OrdenMedica;

public class OrdenMedicaLeaf implements PlanAtencion {

    private OrdenMedica orden;

    public OrdenMedicaLeaf(OrdenMedica orden) {
        this.orden = orden;
    }

    @Override
    public void mostrar() {
        System.out.println("Orden: " +
                orden.getTipoOrden() + " - " +
                orden.getEstado());
    }
}