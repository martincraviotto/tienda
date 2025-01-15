package edu.escuelait.tienda.domain;

import com.fasterxml.jackson.annotation.JsonIgnore;
import com.fasterxml.jackson.annotation.JsonProperty;
import com.fasterxml.jackson.annotation.JsonPropertyOrder;
import edu.escuelait.tienda.validators.Cuit;
import edu.escuelait.tienda.validators.groups.OnCreate;
import edu.escuelait.tienda.validators.groups.OnUpdate;
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
@JsonPropertyOrder({"nombre", "edad", "id", "domicilio", "cuit"})
public class Persona {

    @NonNull
    @Schema(description = "Identificador único de persona", example = "1")
    private Long id;

    @NonNull//Lombok y es para hacer el atributo mandartorio en el constructor
    @JsonProperty("nombre")
    private String name;

    //@NotNull // es de JavaValidation  --> VA sola
    @NotNull(groups = OnCreate.class) //solo la aplica para el grupo onCreated
    @JsonIgnore
    private String lastName;

    //@NotBlank // es de javaValidation es más fuerte que notNull
    @NotBlank(groups = OnUpdate.class)
    @Size(min = 3, max = 7)
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
