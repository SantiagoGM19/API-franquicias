package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.Sucursal;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerTodasLasSucursalesUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<List<Sucursal>> obtenerTodasLasSucursales(){
        return sucursalRepositoryPort.obtenerTodasLasSucursales()
                .collectList();
    }
}
