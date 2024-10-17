package com.franquicias.api.infrastructure.controladores;

import com.franquicias.api.application.AgregarFranquiciaUseCase;
import com.franquicias.api.domain.modelos.Franquicia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.PostMapping;
import org.springframework.web.bind.annotation.RequestBody;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;
import reactor.core.publisher.Mono;

@RestController
@RequestMapping("/franquicia")
@RequiredArgsConstructor
public class FranquiciaControlador {

    private final AgregarFranquiciaUseCase agregarFranquiciaUseCase;

    @PostMapping
    public Mono<ResponseEntity<Franquicia>> agregarFranquicia(@RequestBody Franquicia request){
        return agregarFranquiciaUseCase.agregarNuevaFranquicia(request)
                .map(result -> new ResponseEntity<>(result, HttpStatus.OK))
                .onErrorResume(error -> Mono.just(ResponseEntity.internalServerError().build()));
    }
}
