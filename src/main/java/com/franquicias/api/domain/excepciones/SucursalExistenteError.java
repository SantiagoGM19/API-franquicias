package com.franquicias.api.domain.excepciones;

public class SucursalExistenteError extends ApplicationException{
    public SucursalExistenteError() {
        super("La sucursal que intenta agregar ya existe en la franquicia");
    }
}
