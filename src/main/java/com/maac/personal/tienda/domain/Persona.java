package com.maac.personal.tienda.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import lombok.*;

@Schema(description = "Este es el esquema de una Persona") //swagger
@Data
public class Persona {

    @Schema(description = "Identificador de la Persona", example = "1")//swagger
    @NonNull
    private Long id;

    @NonNull
    private String name;

    private String lastName;
}
