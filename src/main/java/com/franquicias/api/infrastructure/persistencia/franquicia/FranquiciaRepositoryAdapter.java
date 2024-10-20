package com.franquicias.api.infrastructure.persistencia.franquicia;

import com.franquicias.api.domain.modelos.ActualizacionNombreFranquiciaData;
import com.franquicias.api.domain.modelos.Franquicia;
import com.franquicias.api.domain.puertos.FranquiciaRepositoryPort;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

@Repository
@RequiredArgsConstructor
public class FranquiciaRepositoryAdapter implements FranquiciaRepositoryPort {

    private final FranquiciaRepository franquiciaRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Franquicia> agregarFranquicia(Franquicia franquicia) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(franquicia.getCodigo()));
        return reactiveMongoTemplate.findOne(query, FranquiciaEntity.class)
                .map(resultado -> new Franquicia())
                .switchIfEmpty(franquiciaRepository.save(FranquiciaMapper.fromDomain(franquicia))
                        .map(FranquiciaMapper::fromEntity));
    }

    @Override
    public Flux<Franquicia> obtenerTodasLasFranquicias() {
        return reactiveMongoTemplate.findAll(FranquiciaEntity.class)
                .map(FranquiciaMapper::fromEntity);
    }

    @Override
    public Mono<Long> actualizarNombre(ActualizacionNombreFranquiciaData data) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigo").is(data.getCodigoFranquicia()));
        Update update = new Update();
        update.set("nombre", data.getNuevoNombre());
        return reactiveMongoTemplate.updateFirst(query, update, FranquiciaEntity.class)
                .map(UpdateResult::getModifiedCount);
    }
}
