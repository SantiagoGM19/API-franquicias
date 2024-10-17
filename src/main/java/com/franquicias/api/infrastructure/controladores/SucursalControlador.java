package com.franquicias.api.infrastructure.controladores;

import com.franquicias.api.application.AgregarSucursalUseCase;
import com.franquicias.api.domain.modelos.Sucursal;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/sucursal")
@RequiredArgsConstructor
public class SucursalControlador {

    private final AgregarSucursalUseCase agregarSucursalUseCase;

    @PostMapping
    public Mono<ResponseEntity<Sucursal>> agregarSucursal(@RequestBody Sucursal request){
        return agregarSucursalUseCase.agregarNuevaSucursalAFranquicia(request)
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK))
                .onErrorResume(error -> Mono.just(ResponseEntity.internalServerError().build()));
    }
}
