package com.franquicias.api.domain.excepciones;

public class FranquiciaExistenteError extends ApplicationException{
    public FranquiciaExistenteError() {
        super("La franquicia ya existe");
    }
}
