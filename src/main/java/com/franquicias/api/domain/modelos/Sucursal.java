package com.franquicias.api.domain.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Sucursal {
    private String nombre;
    private String codigoFranquicia;
    private List<Producto> productos;
}
