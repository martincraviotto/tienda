package com.maac.personal.tienda.controllers;

import com.maac.personal.tienda.configurations.AppConfig;
import com.maac.personal.tienda.configurations.TiendaParametrosConfig;
import com.maac.personal.tienda.domain.Persona;
import com.maac.personal.tienda.services.PersonasService;
import com.maac.personal.tienda.services.PersonasServiceImpl;
import io.swagger.v3.oas.annotations.Operation;
import io.swagger.v3.oas.annotations.Parameter;
import io.swagger.v3.oas.annotations.responses.ApiResponse;
import io.swagger.v3.oas.annotations.tags.Tag;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.beans.factory.annotation.Qualifier;
import org.springframework.context.annotation.Lazy;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@Slf4j
@RestController
@RequestMapping("/personas")
@Tag(name = "API Personas", description = "CRUD de Personas de Tienda") //swagger
public class PersonaRestController {

    //@Autowired
    PersonasService personasService;

    AppConfig appConfig;

    TiendaParametrosConfig tiendaParametrosConfig;

    // Se recomienda esta forma para realizar la inyecciòn
    public PersonaRestController( @Lazy  PersonasService personasService
                ,AppConfig appConfig
                ,TiendaParametrosConfig tiendaParametrosConfig) {
        this.personasService = personasService;
        this.appConfig=appConfig;
        this.tiendaParametrosConfig=tiendaParametrosConfig;
        log.info("Estos son los parametros configurados : {}", this.appConfig);
        log.info("Parametros de la Tienda {}", tiendaParametrosConfig);
    }

    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Juan"),
                    new Persona(2L,"Martin"),
                    new Persona(3L,"Ricardo"),
                    new Persona(4L,"Juan1"),
                    new Persona(5L,"Martin1"),
                    new Persona(6L,"Ricardo1"),
                    new Persona(7L,"Juan2"),
                    new Persona(8L,"Martin2"),
                    new Persona(9L,"Ricardo2"),
                    new Persona(10L,"Juan3"),
                    new Persona(11L,"Martin3"),
                    new Persona(12L,"Ricardo3"),
                    new Persona(12L,"Juan4"),
                    new Persona(14L,"Martin4"),
                    new Persona(15L,"Ricardo4"),
                    new Persona(16L,"Juan5"),
                    new Persona(17L,"Martin5"),
                    new Persona(18L,"Ricardo5")
                   )
    );


    @ApiResponse(responseCode = "200", description = "Operación exitosa")//swagger
    @ApiResponse(responseCode = "400", description = "Error de petición")//swagger
    @ApiResponse(responseCode = "404", description = "Recurso no encontrado")//swagger
    @Operation(summary = "Recupera una persona por Id", description = "Recupera una persona, dado un id tipo numerico") //swagger
    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(
            @Parameter(description = "Identificacion de la persona. Valor entero",required = true, example = "1")
            @PathVariable Long id){
        if(id < 0)
            return ResponseEntity.badRequest().build();

        /*
           return (Persona) personas
                .stream()
                .filter( persona -> persona.getId().equals(id));
        */

        for (Persona persona : personas){
            if (persona.getId().equals(id))
                return ResponseEntity.ok(persona);
        }
        return ResponseEntity.notFound().build();
    }


    @GetMapping
    public ResponseEntity<List<Persona>> listPersonas(){
        List<Persona> personas = personasService.listAllPersonas();
        return ResponseEntity.ok(personas);
    }

    @PostMapping
    public ResponseEntity<Persona> createPersona(@RequestBody Persona persona){
        this.personas.add(persona);
        URI location = ServletUriComponentsBuilder
                        .fromCurrentRequest()
                        .path("/íd}")
                        .buildAndExpand(persona.getId())
                        .toUri();
        return ResponseEntity.created(location).build();
    }

    @PutMapping
    public ResponseEntity<Persona> updatePersona(@RequestBody Persona persona){

        for (Persona per : personas){
            if (per.getId().equals(persona.getId())) {
                per.setName(persona.getName());
                per.setLastName(persona.getLastName());
                return ResponseEntity.ok(per);
            }
        }
        return ResponseEntity.notFound().build();
    }


    @DeleteMapping("/{id}")
    public ResponseEntity deletePersona(@PathVariable Long id ){

        if(id < 0)
            return ResponseEntity.badRequest().build();


        for (Persona persona : personas){
            if (persona.getId().equals(id)) {
                this.personas.remove(persona);
                return ResponseEntity.noContent().build();
            }
         }
        return ResponseEntity.notFound().build();

    }

    @PatchMapping("/{id}")
    public ResponseEntity<?> updateAttribute (@PathVariable Long id, String attributeName, String newValue){

        for (Persona persona : personas){
            if (persona.getId().equals(id)) {
                if(attributeName.equals("name")){
                    persona.setName(newValue);
                } else if (attributeName.equals("lastName")) {
                    persona.setLastName(newValue);
                }
                return ResponseEntity.ok(persona);
            }
        }

        return ResponseEntity.notFound().build();
    }


}
