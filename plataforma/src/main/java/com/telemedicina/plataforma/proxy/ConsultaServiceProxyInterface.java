package com.telemedicina.plataforma.proxy;

import java.time.LocalDateTime;
import com.telemedicina.plataforma.model.Consulta;

public interface ConsultaServiceProxyInterface {

    Consulta crearConsulta(LocalDateTime fecha, Long pacienteId, Long medicoId, String tipo);
}