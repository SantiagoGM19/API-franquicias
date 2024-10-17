package com.franquicias.api.domain.modelos;

import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NoArgsConstructor;

import java.util.List;

@AllArgsConstructor
@NoArgsConstructor
@Data
public class Franquicia {
    private Integer codigo;
    private String nombre;
    private List<Integer> codigosSucursales;
}
