package com.maac.personal.tienda.domain;


import lombok.Data;
import lombok.NonNull;

@Data
public class Producto {

    @NonNull
    private Long id;

    @NonNull
    private String name;
    private String description;


}
