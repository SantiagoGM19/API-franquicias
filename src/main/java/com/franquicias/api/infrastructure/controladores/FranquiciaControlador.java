package com.franquicias.api.infrastructure.controladores;

import com.franquicias.api.application.AgregarFranquiciaUseCase;
import com.franquicias.api.application.ObtenerTodasLasFranquiciasUseCase;
import com.franquicias.api.domain.excepciones.FranquiciaExistenteError;
import com.franquicias.api.domain.modelos.Franquicia;
import lombok.RequiredArgsConstructor;
import org.springframework.http.HttpStatus;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import reactor.core.publisher.Mono;

import java.util.List;

@RestController
@RequestMapping("/franquicia")
@RequiredArgsConstructor
public class FranquiciaControlador {

    private final AgregarFranquiciaUseCase agregarFranquiciaUseCase;
    private final ObtenerTodasLasFranquiciasUseCase obtenerTodasLasFranquiciasUseCase;

    @PostMapping
    public Mono<ResponseEntity<Franquicia>> agregarFranquicia(@RequestBody Franquicia request){
        return agregarFranquiciaUseCase.agregarNuevaFranquicia(request)
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK))
                .onErrorResume(FranquiciaExistenteError.class, error ->
                        Mono.just(ResponseEntity.status(HttpStatus.BAD_REQUEST).body(null)));
    }

    @GetMapping
    public Mono<ResponseEntity<List<Franquicia>>> obtenerTodasLasFranquicias(){
        return obtenerTodasLasFranquiciasUseCase.obtenerTodasLasFranquicias()
                .map(resultado -> new ResponseEntity<>(resultado, HttpStatus.OK));
    }
}
