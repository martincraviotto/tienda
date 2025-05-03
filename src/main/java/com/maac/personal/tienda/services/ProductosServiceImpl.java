package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Producto;
import org.springframework.stereotype.Service;

import java.util.Optional;

@Service
public class ProductosServiceImpl implements ProductosService {

    @Override
    public Optional<Producto> getProductoById(Long id) {

        if(id > 0){
            Producto ordenador =  new Producto(1L,"Ordenador");
            return  Optional.of(ordenador);
        }

        return Optional.empty();
    }
}
