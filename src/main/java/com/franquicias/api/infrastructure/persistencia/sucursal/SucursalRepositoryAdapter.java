package com.franquicias.api.infrastructure.persistencia.sucursal;

import com.franquicias.api.domain.modelos.EliminacionProductoData;
import com.franquicias.api.domain.modelos.ModificacionStockProductoData;
import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.Sucursal;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import com.franquicias.api.infrastructure.persistencia.franquicia.FranquiciaEntity;
import com.mongodb.client.result.UpdateResult;
import lombok.RequiredArgsConstructor;
import org.springframework.data.mongodb.core.ReactiveMongoTemplate;
import org.springframework.data.mongodb.core.query.Criteria;
import org.springframework.data.mongodb.core.query.Query;
import org.springframework.data.mongodb.core.query.Update;
import org.springframework.stereotype.Repository;
import reactor.core.publisher.Flux;
import reactor.core.publisher.Mono;

import java.util.List;
import java.util.Objects;

@Repository
@RequiredArgsConstructor
public class SucursalRepositoryAdapter implements SucursalRepositoryPort {

    private final SucursalRepository sucursalRepository;
    private final ReactiveMongoTemplate reactiveMongoTemplate;

    @Override
    public Mono<Sucursal> agregarSucursal(Sucursal sucursal) {
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("codigo").is(sucursal.getCodigoFranquicia()));
        update.push("codigosSucursales", sucursal.getCodigo());
        return reactiveMongoTemplate.findOne(query, FranquiciaEntity.class)
                .flatMap(franquiciaEntity -> {
                    if (verificarSucursalNoExiste(franquiciaEntity.getCodigosSucursales(), sucursal)){
                            return reactiveMongoTemplate.updateFirst(query,
                                        update,
                                        FranquiciaEntity.class)
                                .flatMap(result -> sucursalRepository.save(SucursalMapper.fromDomain(sucursal))
                                        .map(SucursalMapper::fromEntity));
                    }
                    return Mono.empty();
                });
    }

    private Boolean verificarSucursalNoExiste(List<Integer> codigosSucursales, Sucursal sucursal){
        return codigosSucursales.stream()
                .filter(sucursalExistente ->
                            Objects.equals(sucursalExistente, sucursal.getCodigo())
                ).toList().isEmpty();
    }

    @Override
    public Mono<Long> agregarNuevoProducto(Producto producto, Integer codigoSucursal) {
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("codigo").is(codigoSucursal));
        update.push("productos", producto);
        return reactiveMongoTemplate.findOne(query, SucursalEntity.class)
                .flatMap(sucursalEntity -> {
                    if(verificarProductoNoExiste(sucursalEntity.getProductos(), producto)){
                        return reactiveMongoTemplate.updateFirst(query, update, SucursalEntity.class)
                                .map(UpdateResult::getModifiedCount);
                    }
                    return Mono.empty();
                });
    }

    private Boolean verificarProductoNoExiste(List<Producto> productosExistentes, Producto nuevoProducto){
        return productosExistentes.stream()
                .filter(productoExistente ->
                        Objects.equals(productoExistente.getCodigo(), nuevoProducto.getCodigo())
                ).toList().isEmpty();
    }

    @Override
    public Mono<Long> eliminarProducto(EliminacionProductoData data) {
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("codigo").is(data.getCodigoSucursal()));
        return reactiveMongoTemplate.findOne(query, SucursalEntity.class)
                .flatMap(resultado -> {
                    resultado.eliminarProducto(data.getCodigoProducto());
                    update.set("productos", resultado.getProductos());
                    return reactiveMongoTemplate.updateFirst(query, update, SucursalEntity.class)
                            .map(UpdateResult::getModifiedCount);
                });
    }

    @Override
    public Mono<Long> modificarStockProducto(ModificacionStockProductoData data){
        Query query = new Query();
        Update update = new Update();
        query.addCriteria(Criteria.where("codigo").is(data.getCodigoSucursal()));
        return reactiveMongoTemplate.findOne(query, SucursalEntity.class)
                .flatMap(resultado -> {
                    resultado.modificarStockProducto(data.getStock(), data.getCodigoProducto());
                    update.set("productos", resultado.getProductos());
                    return reactiveMongoTemplate.updateFirst(query, update, SucursalEntity.class)
                            .map(UpdateResult::getModifiedCount);
                });
    }

    @Override
    public Flux<Sucursal> obtenerSucursalesPorCodgioFranquicia(Integer codigoFranquicia) {
        Query query = new Query();
        query.addCriteria(Criteria.where("codigoFranquicia").is(codigoFranquicia));
        return reactiveMongoTemplate.find(query, SucursalEntity.class)
                .map(SucursalMapper::fromEntity);
    }

    @Override
    public Flux<Sucursal> obtenerTodasLasSucursales() {
        return reactiveMongoTemplate.findAll(SucursalEntity.class)
                .map(SucursalMapper::fromEntity);
    }
}
