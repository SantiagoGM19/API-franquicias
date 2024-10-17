package com.franquicias.api.infrastructure.controladores;

import com.franquicias.api.application.AgregarProductoUseCase;
import com.franquicias.api.application.AgregarSucursalUseCase;
import com.franquicias.api.application.EliminarProductoUseCase;
import com.franquicias.api.domain.excepciones.ProductoExistenteError;
import com.franquicias.api.domain.excepciones.SucursalExistenteError;
import com.franquicias.api.domain.modelos.EliminacionProductoData;
import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.Sucursal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalControlador {

    private final AgregarSucursalUseCase agregarSucursalUseCase;
    private final AgregarProductoUseCase agregarProductoUseCase;
    private final EliminarProductoUseCase eliminarProductoUseCase;

    @PostMapping
    public Mono<ResponseEntity<Sucursal>> agregarSucursal(@RequestBody Sucursal request){
        return agregarSucursalUseCase.agregarNuevaSucursalAFranquicia(request)
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK))
                .onErrorResume(SucursalExistenteError.class, error ->
                        Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)));
    }

    @PutMapping("/producto/{codigoSucursal}")
    public Mono<ResponseEntity<Long>> agregarProducto(@RequestBody Producto producto, @PathVariable Integer codigoSucursal){
        return agregarProductoUseCase.agregarNuevoProductoASucursal(producto, codigoSucursal)
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK))
                .onErrorResume(ProductoExistenteError.class, error ->
                        Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)));

    }

    @DeleteMapping("/producto")
    public Mono<ResponseEntity<Long>> eliminarProducto(@RequestBody EliminacionProductoData request){
        return eliminarProductoUseCase.eliminarProducto(request)
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK));
    }
}
