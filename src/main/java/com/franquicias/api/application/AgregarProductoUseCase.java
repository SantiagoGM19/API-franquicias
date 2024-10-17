package com.franquicias.api.application;

import com.franquicias.api.domain.excepciones.ProductoExistenteError;
import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.Sucursal;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgregarProductoUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<Long> agregarNuevoProductoASucursal(Producto producto, Integer codigoSucursal){
        return sucursalRepositoryPort.agregarNuevoProducto(producto, codigoSucursal)
                .switchIfEmpty(Mono.error(new ProductoExistenteError()));
    }
}
