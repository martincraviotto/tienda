package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Producto;
import com.maac.personal.tienda.mappers.ProductosMapper;
import com.maac.personal.tienda.persistence.entities.ProductoEntity;
import com.maac.personal.tienda.persistence.repositories.ProductoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImpl implements ProductosService {

    ProductoRepository productoRepository;

    ProductosMapper productosMapper;

    public ProductosServiceImpl(ProductoRepository productoRepository, ProductosMapper productosMapper) {
        this.productoRepository = productoRepository;
        this.productosMapper = productosMapper;
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
          return this.productoRepository.findById(id)
                 .map(productoEntity -> {
                     Producto producto =this.productosMapper.mapProducto(productoEntity);
                     return  producto;
                 });
    }

    @Override
    public List<Producto> AllProductos(Pageable pageable) {
        return this.productoRepository.findAll(pageable)
                .stream()
                .map(productoEntity -> {
                    return this.productosMapper.mapProducto(productoEntity);
                }).collect(Collectors.toList());
    }

    @Override

    public List<Producto> AllProductosByIdLessThan(Long id) {
        return this.productoRepository.findByIdLessThan(id)
                .stream()
                .map(productoEntity ->  productosMapper.mapProducto(productoEntity))
                .collect(Collectors.toList());
    }


}
