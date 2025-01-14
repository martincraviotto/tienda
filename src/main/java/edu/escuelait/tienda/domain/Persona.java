package edu.escuelait.tienda.domain;

import edu.escuelait.tienda.validators.Cuit;
import io.swagger.v3.oas.annotations.media.Schema;
import jakarta.validation.constraints.*;
import lombok.AllArgsConstructor;
import lombok.Data;
import lombok.NonNull;
import lombok.RequiredArgsConstructor;

import java.time.LocalDate;


@Schema(description = "Esta es una persona ......")
@Data
//@AllArgsConstructor
//@NoArgsConstructor
//@RequiredArgsConstructor
public class Persona {

    @NonNull
    @Schema(description = "Identificador único de persona", example = "1")
    private Long id;
    @NonNull//Lombok y es para hacer el atributo mandartorio en el constructor
    private String name;

    @NotNull // es de JavaValidation
    private String lastName;

    @NotBlank // es de javaValidation es más fuerte que notNull
    @Size(min=3, max=7)
    private String domicilio;

    @Max(80) // es de javaValidation
    @Min(18) // es de javaValidation
    private int edad;
/*
    @AssertFalse // es de javaValidation
    //@AssertTrue
    private boolean casado;

    @Email // es de javaValidation
    private String mail;

    @Positive// es de javaValidation
    //@PositiveOrZero// es de javaValidation
    private int puntuacion;

    @Negative // es de javaValidation
    //@NegativeOrZero // es de javaValidation
    private int ranking;

    @Past // es de javaValidation
    //@PastOrPresent //// es de javaValidation
    private LocalDate fechaNacimiento;

    //@Future // es de javaValidation
    @FutureOrPresent // es de javaValidation
    private LocalDate registro;
*/
    //España NIF
    //Argentina CUIT
    @Cuit //Validación creada
    private String cuit;


}
