package com.telemedicina.plataforma.factory;

import com.telemedicina.plataforma.model.*;

public interface AbstractMedicalFactory {

    Consulta crearConsulta(Paciente paciente, Medico medico);

    Prescripcion crearPrescripcion(Consulta consulta, String medicamento, String indicaciones);

    OrdenMedica crearOrdenMedica(String tipoOrden, String estado);
}