package com.maac.personal.tienda.persistence.repositories;


import com.maac.personal.tienda.persistence.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

@Repository
public interface ProductoRepository extends JpaRepository<ProductoEntity,Long>  {


}
