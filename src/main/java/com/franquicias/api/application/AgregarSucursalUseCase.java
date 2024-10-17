package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.Sucursal;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgregarSucursalUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<Sucursal> agregarNuevaSucursalAFranquicia(Sucursal sucursal){
        return sucursalRepositoryPort.agregarSucursal(sucursal);
    }
}
