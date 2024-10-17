package com.franquicias.api.infrastructure.persistencia.franquicia;

import com.franquicias.api.domain.modelos.Franquicia;

public class FranquiciaMapper {

    public static FranquiciaEntity fromDomain(Franquicia franquicia){
        FranquiciaEntity franquiciaEntity =  new FranquiciaEntity();
        franquiciaEntity.setNombre(franquicia.getNombre());
        franquiciaEntity.setCodigo(franquicia.getCodigo());
        franquiciaEntity.setCodigosSucursales(franquicia.getCodigosSucursales());
        return franquiciaEntity;
    }

    public static Franquicia fromEntity(FranquiciaEntity franquiciaEntity){
        Franquicia franquicia = new Franquicia();
        franquicia.setCodigo(franquiciaEntity.getCodigo());
        franquicia.setNombre(franquiciaEntity.getNombre());
        franquicia.setCodigosSucursales(franquiciaEntity.getCodigosSucursales());
        return franquicia;
    }
}
