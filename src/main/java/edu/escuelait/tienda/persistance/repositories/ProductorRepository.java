package edu.escuelait.tienda.persistance.repositories;

import edu.escuelait.tienda.persistance.entities.ProductoEntity;
import org.springframework.data.jpa.repository.JpaRepository;
import org.springframework.stereotype.Repository;

import java.util.List;

@Repository
public interface ProductorRepository extends JpaRepository<ProductoEntity, Long> {

        public List<ProductoEntity> findByIdLessThan(Long id);

}
