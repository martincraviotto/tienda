package com.maac.personal.tienda.controllers;

import com.maac.personal.tienda.exceptions.ProductoNotFoundException;
import com.maac.personal.tienda.services.ProductosService;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@RequestMapping("/productos")
public class ProductosRestController {

    private ProductosService productosService;

    public ProductosRestController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoById(@PathVariable Long id){

       return this.productosService.getProductoById(id)
               .map(producto -> { return ResponseEntity.ok(producto);})
               .orElseThrow(ProductoNotFoundException::new);


    }

    @GetMapping
    public ResponseEntity<?> getAllProductos(
            @PageableDefault(size = 2,sort={"name","id"}, direction = Sort.Direction.ASC)
            Pageable pageable){
        return ResponseEntity.ok(this.productosService.AllProductos(pageable));
    }


    @GetMapping("/less/{id}")
    public ResponseEntity<?> getAllProductosByIdLessThan(@PathVariable Long id ){
        return ResponseEntity.ok(this.productosService.AllProductosByIdLessThan(id));
    }

}
