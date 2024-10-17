package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.Franquicia;
import com.franquicias.api.domain.puertos.FranquiciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerTodasLasFranquiciasUseCase {

    private final FranquiciaRepositoryPort franquiciaRepositoryPort;

    public Mono<List<Franquicia>> obtenerTodasLasFranquicias(){
        return franquiciaRepositoryPort.obtenerTodasLasFranquicias()
                .collectList();
    }
}
