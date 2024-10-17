package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.Franquicia;
import com.franquicias.api.domain.puertos.FranquiciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class AgregarFranquiciaUseCase {

    private final FranquiciaRepositoryPort franquiciaRepository;

    public Mono<Franquicia> agregarNuevaFranquicia(Franquicia franquicia){
        return franquiciaRepository.agregarFranquicia(franquicia);
    }

}
