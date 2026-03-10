package com.telemedicina.plataforma.dto;

import lombok.Data;

@Data
public class PrescripcionRequest {

    private Long consultaId;
    private String medicamento;
    private String indicaciones;

}