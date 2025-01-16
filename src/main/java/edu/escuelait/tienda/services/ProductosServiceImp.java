package edu.escuelait.tienda.services;


import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.mappers.ProductosMapper;
import edu.escuelait.tienda.persistance.repositories.ProductorRepository;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImp implements ProductosService{

    ProductorRepository productorRepository;


    ProductosMapper productosMapper;

    public ProductosServiceImp(ProductorRepository productorRepository, ProductosMapper productosMapper) {
        this.productorRepository = productorRepository;
        this.productosMapper = productosMapper;
    }

    @Override
    public Optional<Producto> getProductoPorId(Long id) {
        return this.productorRepository.findById(id)
                .map(productoEntity -> {
                    Producto producto = this.productosMapper.mapProducto(productoEntity);
                    return producto;
                });

    }

    public List<Producto> getAllProductos(Pageable pageable){
        return this.productorRepository
                    .findAll(pageable)
                    .stream().map(productoEntity -> {
                        return this.productosMapper.mapProducto(productoEntity);
                    }).collect(Collectors.toList());
    }
}
