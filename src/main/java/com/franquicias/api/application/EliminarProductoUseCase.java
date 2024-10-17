package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.EliminacionProductoData;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class EliminarProductoUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<Long> eliminarProducto(EliminacionProductoData request){
        return sucursalRepositoryPort.eliminarProducto(request);
    }
}
