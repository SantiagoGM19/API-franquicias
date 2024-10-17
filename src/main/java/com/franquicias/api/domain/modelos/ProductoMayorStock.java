package com.franquicias.api.domain.modelos;

import com.franquicias.api.domain.modelos.Producto;
import lombok.Data;

@Data
public class ProductoMayorStock {
    private Producto producto;
    private Integer codigoSucursal;
    private String nombreSucursal;
}
