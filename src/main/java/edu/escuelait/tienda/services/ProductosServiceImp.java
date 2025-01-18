package edu.escuelait.tienda.services;


import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.mappers.ProductosMapper;
import edu.escuelait.tienda.persistance.repositories.ProductorRepository;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Slf4j //para log de errores
@Service
public class ProductosServiceImp implements ProductosService{

    ProductorRepository productorRepository;


    ProductosMapper productosMapper;

    public ProductosServiceImp(ProductorRepository productorRepository, ProductosMapper productosMapper) {
        log.info("ejecutando constructor");
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

    @Override
    public List<Producto> getProductoPorIdLess(Long id) {
        return this.productorRepository
                    .findByIdLessThan(id)
                    .stream()
                    .map(productoEntity -> {
                            return this.productosMapper.mapProducto(productoEntity);
                        })
                    .collect(Collectors.toList());
    }
}
