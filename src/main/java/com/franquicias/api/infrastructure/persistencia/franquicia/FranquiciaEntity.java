package com.franquicias.api.infrastructure.persistencia.franquicia;

import com.franquicias.api.infrastructure.persistencia.sucursal.SucursalEntity;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;

@Data
@Document("franquicias")
public class FranquiciaEntity {
    @Id
    private String _id;
    private Integer codigo;
    private String nombre;
    private List<SucursalEntity> sucursales;
}
