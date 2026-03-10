package com.telemedicina.plataforma.dto;

import lombok.Data;

@Data
public class OrdenMedicaRequest {

    private String tipoOrden;
    private String estado;

}