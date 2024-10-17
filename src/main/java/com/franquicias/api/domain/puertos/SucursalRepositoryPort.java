package com.franquicias.api.domain.puertos;

import com.franquicias.api.domain.modelos.EliminacionProductoData;
import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepositoryPort {

    Mono<Sucursal> agregarSucursal(Sucursal sucursal);
    Mono<Long> agregarNuevoProducto(Producto producto, Integer codigoSucursal);
    Mono<Long> eliminarProducto(EliminacionProductoData eliminacionProductoData);
}
