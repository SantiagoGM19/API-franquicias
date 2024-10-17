package com.franquicias.api.infrastructure.persistencia.franquicia;

import com.franquicias.api.domain.modelos.Franquicia;
import com.franquicias.api.domain.puertos.FranquiciaRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranquiciaRepositoryAdapter implements FranquiciaRepositoryPort {

    private final FranquiciaRepository franquiciaRepository;

    @Override
    public Mono<Franquicia> agregarFranquicia(Franquicia franquicia) {
        return franquiciaRepository.save(FranquiciaMapper.fromDomain(franquicia))
                .map(FranquiciaMapper::fromEntity);
    }
}
