package com.franquicias.api.infrastructure.persistencia.sucursal;

import org.springframework.data.mongodb.repository.ReactiveMongoRepository;

public interface SucursalRepository extends ReactiveMongoRepository<SucursalEntity, String> {
}
