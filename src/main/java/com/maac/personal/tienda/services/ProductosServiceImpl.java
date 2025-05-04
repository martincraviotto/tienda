package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Producto;
import com.maac.personal.tienda.persistence.repositories.ProductoRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImpl implements ProductosService {

    ProductoRepository productoRepository;

    public ProductosServiceImpl(ProductoRepository productoRepository) {
        this.productoRepository = productoRepository;
    }

    @Override
    public Optional<Producto> getProductoById(Long id) {
          return this.productoRepository.findById(id)
                 .map(productoEntity -> {
                     Producto producto = new Producto(productoEntity.getId(),productoEntity.getName());
                     producto.setDescription(productoEntity.getDescription());
                     return  producto;
                 });
    }

    @Override
    public List<Producto> AllProductos(Pageable pageable) {
        return this.productoRepository.findAll(pageable)
                .stream()
                .map(productoEntity -> {
                    Producto producto = new Producto(productoEntity.getId(),productoEntity.getName());
                    producto.setDescription(productoEntity.getDescription());
                    return  producto;
                }).collect(Collectors.toList());
    }


}
