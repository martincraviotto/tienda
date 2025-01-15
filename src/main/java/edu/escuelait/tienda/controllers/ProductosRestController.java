package edu.escuelait.tienda.controllers;

import edu.escuelait.tienda.exceptions.ProductoNotFoundException;
import edu.escuelait.tienda.services.ProductosService;
import lombok.extern.slf4j.Slf4j;
import org.springframework.data.domain.Pageable;
import org.springframework.data.domain.Sort;
import org.springframework.data.web.PageableDefault;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RequestMapping;
import org.springframework.web.bind.annotation.RestController;

@RestController
@Slf4j
@RequestMapping("productos")
public class ProductosRestController {


    private ProductosService productosService;

    public ProductosRestController(ProductosService productosService) {
        this.productosService = productosService;
    }

    @GetMapping("/{id}")
    public ResponseEntity<?> getProductoPorId(@PathVariable Long id){

//        Optional<Producto> optionalProducto = this.productosService.getProductoPorId(id);
//
//        if(optionalProducto.isPresent()){
//            Producto producto = optionalProducto.get();
//            return ResponseEntity.ok(producto);
//        }
//
//        throw new ProductoNotFoundException();

        return this.productosService
                .getProductoPorId(id)
                .map(producto -> { return ResponseEntity.ok(producto);})
                .orElseThrow(ProductoNotFoundException::new);
    }

    @GetMapping()
    public ResponseEntity<?> getAllProductos(
            @PageableDefault(size = 2, sort = {"name","id"},direction = Sort.Direction.ASC)
            Pageable pageable){
        return ResponseEntity.ok(this.productosService.getAllProductos(pageable));
    }

}
