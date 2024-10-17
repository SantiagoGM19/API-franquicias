package com.franquicias.api.domain.puertos;

import com.franquicias.api.domain.modelos.EliminacionProductoData;
import com.franquicias.api.domain.modelos.ModificacionStockProductoData;
import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.Sucursal;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;

public interface SucursalRepositoryPort {

    Mono<Sucursal> agregarSucursal(Sucursal sucursal);
    Mono<Long> agregarNuevoProducto(Producto producto, Integer codigoSucursal);
    Mono<Long> eliminarProducto(EliminacionProductoData eliminacionProductoData);
    Mono<Long> modificarStockProducto(ModificacionStockProductoData modificacionStockProductoData);
    Flux<Sucursal> obtenerSucursalesPorCodgioFranquicia(Integer codigoFranquicia);
    Flux<Sucursal> obtenerTodasLasSucursales();
}
