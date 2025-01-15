package edu.escuelait.tienda.services;


import edu.escuelait.tienda.domain.Producto;
import edu.escuelait.tienda.persistance.repositories.ProductorRepository;
import org.springframework.data.domain.Pageable;
import org.springframework.stereotype.Service;

import java.util.List;
import java.util.Optional;
import java.util.stream.Collectors;

@Service
public class ProductosServiceImp implements ProductosService{

    ProductorRepository productorRepository;

    public ProductosServiceImp(ProductorRepository productorRepository) {
        this.productorRepository = productorRepository;
    }

    @Override
    public Optional<Producto> getProductoPorId(Long id) {

//        if(id > 0 ){
//            Producto ordenador =  new Producto(1L,"Ordenador");
//            return Optional.of(ordenador);
//        }
//        return Optional.empty();

        return this.productorRepository.findById(id)
                .map(productoEntity -> {
                    Producto producto = new Producto(productoEntity.getId(), productoEntity.getName());
                    producto.setDescription(productoEntity.getDescription());
                    return producto;
                });

    }

    public List<Producto> getAllProductos(Pageable pageable){
        return this.productorRepository
                    .findAll(pageable)
                    .stream().map(productoEntity -> {
                        Producto producto = new Producto(productoEntity.getId(), productoEntity.getName());
                        producto.setDescription(productoEntity.getDescription());
                        return producto;
                    }).collect(Collectors.toList());
    }
}
