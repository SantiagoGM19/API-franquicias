package com.franquicias.api.domain.modelos;

import lombok.Data;
import lombok.EqualsAndHashCode;

@EqualsAndHashCode(callSuper = true)
@Data
public class ModificacionStockProductoData extends EliminacionProductoData{
    private Integer stock;
}
