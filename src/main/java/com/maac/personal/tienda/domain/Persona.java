package com.maac.personal.tienda.domain;

import lombok.*;

@Data
public class Persona {

    @NonNull
    private Long id;

    @NonNull
    private String name;

    private String lastName;
}
