package com.franquicias.api.infrastructure.persistencia.sucursal;

import com.franquicias.api.domain.modelos.Sucursal;

public class SucursalMapper {

    public static SucursalEntity fromDomain(Sucursal sucursal){
        SucursalEntity sucursalEntity = new SucursalEntity();
        sucursalEntity.setNombre(sucursal.getNombre());
        sucursalEntity.setCodigoFranquicia(sucursal.getCodigoFranquicia());
        sucursalEntity.setProductos(sucursal.getProductos());
        return sucursalEntity;
    }

    public static Sucursal fromEntity(SucursalEntity sucursalEntity){
        Sucursal sucursal = new Sucursal();
        sucursal.setNombre(sucursalEntity.getNombre());
        sucursal.setCodigoFranquicia(sucursalEntity.getCodigoFranquicia());
        sucursal.setProductos(sucursalEntity.getProductos());
        return sucursal;
    }
}
