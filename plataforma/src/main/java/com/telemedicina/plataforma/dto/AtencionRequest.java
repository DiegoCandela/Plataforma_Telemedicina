package com.telemedicina.plataforma.dto;

import java.time.LocalDateTime;
import lombok.Data;

@Data
public class AtencionRequest {

    private LocalDateTime fecha;
    private Long pacienteId;
    private Long medicoId;
    private String tipoConsulta;

    private String medicamento;
    private String indicaciones;

    private String tipoOrden;
    private String estadoOrden;
}