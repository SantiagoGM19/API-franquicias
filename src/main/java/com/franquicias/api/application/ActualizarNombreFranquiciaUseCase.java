package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.ActualizacionNombreFranquiciaData;
import com.franquicias.api.domain.puertos.FranquiciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

@Service
@RequiredArgsConstructor
public class ActualizarNombreFranquiciaUseCase {

    private final FranquiciaRepositoryPort franquiciaRepositoryPort;

    public Mono<Long> actualizarNombreFranquicia(ActualizacionNombreFranquiciaData request){
        return franquiciaRepositoryPort.actualizarNombre(request);
    }
}
