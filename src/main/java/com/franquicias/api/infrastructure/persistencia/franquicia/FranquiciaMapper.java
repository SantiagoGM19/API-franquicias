package com.franquicias.api.infrastructure.persistencia.franquicia;

import com.franquicias.api.domain.modelos.Franquicia;
import com.franquicias.api.infrastructure.persistencia.sucursal.SucursalMapper;

public class FranquiciaMapper {

    public static FranquiciaEntity fromDomain(Franquicia franquicia){
        FranquiciaEntity franquiciaEntity =  new FranquiciaEntity();
        franquiciaEntity.setNombre(franquicia.getNombre());
        franquiciaEntity.setCodigo(franquicia.getCodigo());
        franquiciaEntity.setSucursales(franquicia.getSucursales().stream()
                .map(SucursalMapper::fromDomain).toList());
        return franquiciaEntity;
    }

    public static Franquicia fromEntity(FranquiciaEntity franquiciaEntity){
        Franquicia franquicia = new Franquicia();
        franquicia.setCodigo(franquiciaEntity.getCodigo());
        franquicia.setNombre(franquiciaEntity.getNombre());
        franquicia.setSucursales(franquiciaEntity.getSucursales().stream()
                .map(SucursalMapper::fromEntity).toList());
        return franquicia;
    }
}
