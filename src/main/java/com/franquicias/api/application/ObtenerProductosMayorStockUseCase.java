package com.franquicias.api.application;

import com.franquicias.api.domain.modelos.Producto;
import com.franquicias.api.domain.modelos.ProductoMayorStock;
import com.franquicias.api.domain.puertos.SucursalRepositoryPort;
import lombok.RequiredArgsConstructor;
import org.springframework.stereotype.Service;
import reactor.core.publisher.Mono;

import java.util.Comparator;
import java.util.List;

@Service
@RequiredArgsConstructor
public class ObtenerProductosMayorStockUseCase {

    private final SucursalRepositoryPort sucursalRepositoryPort;

    public Mono<List<ProductoMayorStock>> obtenerProductosMayorStock(Integer codigoFranquicia){
        return sucursalRepositoryPort.obtenerSucursalesPorCodgioFranquicia(codigoFranquicia)
                .map(sucursal ->
                        sucursal.getProductos().stream()
                            .max(Comparator.comparingInt(Producto::getCantidadStock))
                            .map(productoMayorStock -> {
                                ProductoMayorStock respuestaProducto = new ProductoMayorStock();
                                respuestaProducto.setCodigoSucursal(sucursal.getCodigo());
                                respuestaProducto.setProducto(productoMayorStock);
                                respuestaProducto.setNombreSucursal(sucursal.getNombre());
                                return respuestaProducto;
                            }).orElse(null)
                ).collectList();
    }
}
