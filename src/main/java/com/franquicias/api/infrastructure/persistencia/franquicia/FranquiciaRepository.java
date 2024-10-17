package com.franquicias.api.infrastructure.persistencia.franquicia;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface FranquiciaRepository extends ReactiveMongoRepository<FranquiciaEntity, String> {
}
