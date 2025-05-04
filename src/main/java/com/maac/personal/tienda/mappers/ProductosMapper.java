package com.maac.personal.tienda.mappers;


import com.maac.personal.tienda.domain.Producto;
import com.maac.personal.tienda.persistence.entities.ProductoEntity;
import org.mapstruct.Mapper;

@Mapper(componentModel = "spring")
public interface ProductosMapper {

    public Producto mapProducto(ProductoEntity productoEntity);

    public ProductoEntity mapProductoEntity(Producto producto);

}
