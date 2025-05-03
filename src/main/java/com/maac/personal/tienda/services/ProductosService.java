package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Producto;

import java.util.Optional;

public interface ProductosService {

    public Optional<Producto> getProductoById(Long id);
}
