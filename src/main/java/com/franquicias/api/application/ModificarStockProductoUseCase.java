package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.ModificacionStockProductoData;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ModificarStockProductoUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<Long> modificarStockProducto(ModificacionStockProductoData request){
        return sucursalRepositoryPort.modificarStockProducto(request);
    }
}
