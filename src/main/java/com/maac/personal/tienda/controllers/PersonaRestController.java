package com.maac.personal.tienda.controllers;

import com.maac.personal.tienda.domain.Persona;
import org.springframework.http.ResponseEntity;
import org.springframework.web.bind.annotation.*;
import org.springframework.web.servlet.support.ServletUriComponentsBuilder;

import java.net.URI;
import java.util.ArrayList;
import java.util.List;

@RestController
@RequestMapping("/personas")
public class PersonaRestController {


    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Juan"),
                    new Persona(2L,"Martin"),
                    new Persona(3L,"Ricardo")
                   )
    );


    @GetMapping("/{id}")
    public ResponseEntity<?> getPersonaById(@PathVariable Long id){
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


}
