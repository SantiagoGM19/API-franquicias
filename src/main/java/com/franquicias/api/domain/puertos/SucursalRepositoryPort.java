package com.franquicias.api.domain.puertos;

import com.franquicias.api.domain.modelos.Sucursal;
import reactor.core.publisher.Mono;

public interface SucursalRepositoryPort {

    Mono<Sucursal> agregarSucursal(Sucursal sucursal);
}
