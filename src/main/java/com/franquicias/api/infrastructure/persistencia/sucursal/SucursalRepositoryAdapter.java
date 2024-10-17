package com.franquicias.api.infrastructure.persistencia.sucursal;

import com.franquicias.api.domain.modelos.Sucursal;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import com.franquicias.api.infrastructure.persistencia.franquicia.FranquiciaEntity;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class SucursalRepositoryAdapter implements SucursalRepositoryPort {

    private final SucursalRepository sucursalRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Sucursal> agregarSucursal(Sucursal sucursal) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(sucursal.getCodigoFranquicia()));
        return reactiveMongoTemplate.findAndModify(query,
                new Update().push("codigosSucursales", sucursal.getCodigo()),
                FranquiciaEntity.class)
                .flatMap(result -> sucursalRepository.save(SucursalMapper.fromDomain(sucursal))
                        .map(SucursalMapper::fromEntity));
    }
}
