package com.maac.personal.tienda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import com.maac.personal.tienda.validators.Cuit;
import com.maac.personal.tienda.validators.grupos.OnCreate;
import com.maac.personal.tienda.validators.grupos.OnUpdate;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.*;

import java.time.LocalDate;

@Schema(description = "Este es el esquema de una Persona") //swagger
@Data
@JsonPropertyOrder({"edad","id","nombre","lastName","domicilio","casado","email","puntuacion","ranking", "fechaNacimiento", "cuit","registro"})
public class Persona {

    @Schema(description = "Identificador de la Persona", example = "1")//swagger
    @NonNull
    private Long id;

    @JsonProperty("nombre")
    @NonNull //loombok
    private String name;

    @JsonIgnore
    @NotNull(groups = OnCreate.class) //javavalidation
    private String lastName;

    @NotBlank(groups = {OnUpdate.class, OnCreate.class}) //javavalidation
    @Size(min = 3, max = 6)
    private String domicilio;

    @Min(18)
    @Max(80)
    private int edad;

    @AssertFalse // solo deben ser solteros
    //@AssertTrue
    private boolean casado;

    //@Email
    private String email;

    //@Positive
    //@PositiveOrZero
    private int puntuacion;


    //@Negative
    //@NegativeOrZero
    private int ranking;


    //@Past
    //@PastOrPresent
    private LocalDate fechaNacimiento;

    //@Future
    //@FutureOrPresent
    private LocalDate registro;

    @Cuit  //Validacion personalizada - Clase 4 minuto: 8
    private String cuit;

}
