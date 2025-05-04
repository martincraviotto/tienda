package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Producto;
import org.springframework.data.domain.Pageable;

import java.util.List;
import java.util.Optional;

public interface ProductosService {

    public Optional<Producto> getProductoById(Long id);


    public List<Producto> AllProductos(Pageable pageable);
}
