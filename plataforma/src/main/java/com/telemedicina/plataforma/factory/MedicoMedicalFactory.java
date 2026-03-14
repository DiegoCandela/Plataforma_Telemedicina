package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.builder.ConsultaBuilder;
import com.telemedicina.plataforma.model.*;

import java.time.LocalDateTime;

public class MedicoMedicalFactory implements AbstractMedicalFactory {

    @Override
    public Consulta crearConsulta(Paciente paciente, Medico medico) {

        return ConsultaBuilder.builder()
                .paciente(paciente)
                .medico(medico)
                .estado("ACTIVA")
                .fecha(LocalDateTime.now())
                .build();
    }

    @Override
    public Prescripcion crearPrescripcion(Consulta consulta, String medicamento, String indicaciones) {

        Prescripcion prescripcion = new Prescripcion();
        prescripcion.setConsulta(consulta);
        prescripcion.setMedicamento(medicamento);
        prescripcion.setIndicaciones(indicaciones);

        return prescripcion;
    }

    @Override
    public OrdenMedica crearOrdenMedica(String tipoOrden, String estado) {

        OrdenMedica orden = new OrdenMedica();
        orden.setTipoOrden(tipoOrden);
        orden.setEstado(estado);

        return orden;
    }
}