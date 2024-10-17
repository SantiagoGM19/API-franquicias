package com.franquicias.api.domain.excepciones;

public class ProductoExistenteError extends ApplicationException{
    public ProductoExistenteError() {
        super("El producto ya existe en la sucursal");
    }
}
