package edu.escuelait.tienda.persistance.entities;

import jakarta.persistence.*;
import lombok.Data;
import lombok.NoArgsConstructor;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

@Entity(name = "producto")
@Data
@NoArgsConstructor
//@RequiredArgsConstructor
public class ProductoEntity {

    @NonNull
    @Id
    @GeneratedValue(strategy = GenerationType.SEQUENCE)
    private Long id;

    @NonNull
    //@Column(name = "nombre")
    private String name;

    private String description;
}
