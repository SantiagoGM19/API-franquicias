package com.franquicias.api.infrastructure.persistencia.sucursal;

import com.franquicias.api.domain.modelos.Producto;
import lombok.Data;
import org.springframework.data.annotation.Id;
import org.springframework.data.mongodb.core.mapping.Document;

import java.util.List;
import java.util.Objects;

@Data
@Document("sucursales")
public class SucursalEntity {
    @Id
    private String _id;
    private String nombre;
    private Integer codigo;
    private Integer codigoFranquicia;
    private List<Producto> productos;

    public void eliminarProducto(Integer codigo){
       List<Producto> nuevaLista = productos.stream()
               .filter(producto -> !Objects.equals(producto.getCodigo(), codigo))
               .toList();
       setProductos(nuevaLista);
    }

    public void modificarStockProducto(Integer stock, Integer codigo) {
        List<Producto> productoFiltrado = productos.stream()
                .filter(producto -> Objects.equals(producto.getCodigo(), codigo))
                .toList();
        if(!productoFiltrado.isEmpty()){
            Producto productoAModificar = productoFiltrado.get(0);
            productoAModificar.setCantidadStock(stock);
        }
    }
}
