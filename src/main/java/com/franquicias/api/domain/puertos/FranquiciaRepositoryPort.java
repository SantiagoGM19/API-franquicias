package com.franquicias.api.domain.puertos;

import com.franquicias.api.domain.modelos.Franquicia;
import reactor.core.publisher.Mono;

public interface FranquiciaRepositoryPort {

    Mono<Franquicia> agregarFranquicia(Franquicia franquicia);
}
