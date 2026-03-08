package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.model.*;

import java.time.LocalDateTime;

public class PacienteMedicalFactory implements AbstractMedicalFactory {

    @Override
    public Consulta crearConsulta(Paciente paciente, Medico medico) {

        Consulta consulta = new Consulta();
        consulta.setPaciente(paciente);
        consulta.setMedico(medico);
        consulta.setEstado("ACTIVA");
        consulta.setFecha(LocalDateTime.now());

        return consulta;
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