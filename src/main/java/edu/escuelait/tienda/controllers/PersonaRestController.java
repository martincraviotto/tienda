package edu.escuelait.tienda.controllers;


import edu.escuelait.tienda.configurations.AppConfig;
import edu.escuelait.tienda.configurations.TiendaParametrosConfig;
import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.services.PersonasService;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;

import lombok.extern.slf4j.Slf4j;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.validation.annotation.Validated;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("personas")
@Tag(name="API personas"
        ,description = "CRUD de personas de tienda"
    )
public class PersonaRestController {

    //@Autowired --> Se puede usar, pero se recomienda usar en el constructor para un mejor TEST
    PersonasService personasService;

    AppConfig appConfig;
    TiendaParametrosConfig tiendaParametrosConfig;

    //Se recomienda esta forma de inyectar el service
    //public PersonaRestController(@Qualifier("jugadores") @Lazy PersonasService personasService){
    public PersonaRestController(@Lazy PersonasService personasService, AppConfig appConfig, TiendaParametrosConfig tiendaParametrosConfig){
        this.appConfig=appConfig;
        this.tiendaParametrosConfig=tiendaParametrosConfig;
        log.info("AppConfig {}", appConfig);
        log.info("ParametrosConfig {}", this.tiendaParametrosConfig);

        //Luego cuando la quiero usar
        String monedaDefault = this.tiendaParametrosConfig.getMoneda();

        this.personasService = personasService;
    }

    //Almancen para tener un lote de datos de prueba
    ArrayList<Persona> personas = new ArrayList<>(
//            List.of(new Persona(1L, "Martin", "Craviotto"),
//                    new Persona(2L, "Agustin", "Craviotto"),
//                    new Persona(3L, "Adrian", "Craviotto"))
            List.of(new Persona(1L, "Martin"),
                    new Persona(2L, "Agustin"),
                    new Persona(3L, "Adrian"))
    );


    @ApiResponse(responseCode = "200", description = "Operación exitosa")
    @ApiResponse(responseCode = "400", description = "Error de petición")
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")
    @Operation(summary = "Recupera una persona por Id", description = "Recuperar una persona dado un id del tipo numérico")
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(
            @Parameter(description = "Id de persona. Valor entero", required = true, example = "1")
            @PathVariable Long id
            ){

        if(id < 0)
            return ResponseEntity.badRequest().build();

        //Recorrer cada persona del array de personas
        for (Persona persona: this.personas) {
            if(persona.getId().equals(id))
                return ResponseEntity.ok(persona);
        }
        return ResponseEntity.notFound().build();
    }

    @GetMapping
    public ResponseEntity<?> listPersonas(){

        return ResponseEntity.ok(personasService.listAllPersonas());
    }

    @PostMapping
    public ResponseEntity<?> createPersona(@RequestBody @Validated Persona persona){
        this.personas.add(persona);

        URI location= ServletUriComponentsBuilder
                .fromCurrentRequest()
                .path("{/id}")
                .buildAndExpand(persona.getId())
                .toUri();

        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<?> updatePesona(@RequestBody Persona persona){
        for (Persona per: this.personas) {
            if(per.getId().equals(persona.getId())) {
                per.setName(persona.getName());
                per.setLastName(persona.getLastName());
                return ResponseEntity.ok(persona);
            }
        }
        return ResponseEntity.notFound().build();
    }

    @DeleteMapping("/{id}")
    public ResponseEntity<?> deletePersona(@PathVariable Long id){
        for (Persona persona: this.personas) {
            if(persona.getId().equals(id)) {
                this.personas.remove(persona);
                return ResponseEntity.noContent().build();
            }
        }
        //expresión Lambda
        //this.personas.removeIf(persona -> persona.id == id);

        return ResponseEntity.notFound().build();

    }

    //Modifica solo una atributo del recurso
    @PatchMapping("/{id}")
//    public ResponseEntity<?> modificarAtributo(@PathVariable Long id, String attributeName, String newValue){
    public ResponseEntity<?> modificarAtributo(@PathVariable Long id, @RequestBody Persona persona){

        for (Persona per: this.personas) {
            if(per.getId().equals(id)) {
                if(persona.getName() != null){
                    per.setName(persona.getName());
                }else if(persona.getLastName() != null){
                    per.setLastName(persona.getLastName());
                }
                return ResponseEntity.ok(per);
            }
        }
        return ResponseEntity.notFound().build();
    }


}
