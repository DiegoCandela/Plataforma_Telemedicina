package com.telemedicina.plataforma.dto;

import lombok.Data;
import java.time.LocalDateTime;

@Data
public class ConsultaRequest {

    private LocalDateTime fecha;
    private Long pacienteId;
    private Long medicoId;
}