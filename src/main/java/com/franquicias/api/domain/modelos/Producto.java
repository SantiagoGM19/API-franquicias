package com.franquicias.api.domain.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Producto {
    private Integer codigo;
    private String nombre;
    private Integer cantidadStock;
}
