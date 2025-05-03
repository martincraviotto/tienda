package com.maac.personal.tienda.domain;

import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

@Schema(description = "Este es el esquema de una Persona") //swagger
@Data
public class Persona {

    @Schema(description = "Identificador de la Persona", example = "1")//swagger
    @NonNull
    private Long id;

    @NonNull //loombok
    private String name;

    @NotNull //javavalidation
    private String lastName;

    @NotBlank
    @Size(min = 3, max = 6)
    private String domicilio;

    @Min(18)
    @Max(80)
    private int edad;

    @AssertFalse // solo deben ser solteros
    //@AssertTrue
    private boolean casado;

}
