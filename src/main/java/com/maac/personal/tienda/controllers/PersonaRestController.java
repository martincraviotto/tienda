package com.maac.personal.tienda.controllers;

import com.maac.personal.tienda.domain.Persona;
import org.springframework.web.bind.annotation.*;

import java.util.ArrayList;
import java.util.List;

@RestController
public class PersonaRestController {


    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Juan"),
                    new Persona(2L,"Martin"),
                    new Persona(3L,"Ricardo")
                   )
    );


    @GetMapping("/personas/{id}")
    public Persona getPersonaById(@PathVariable Long id){
        /*return (Persona) personas
                .stream()
                .filter( persona -> persona.getId().equals(id));*/
        for (Persona persona : personas){
            if (persona.getId().equals(id))
                return persona;
        }
        return null;
    }


    @GetMapping("/personas")
    public List<Persona> listPersonas(){
        return personas;
    }

    @PostMapping("/personas")
    public Persona createPersona(@RequestBody Persona persona){
        this.personas.add(persona);
        return persona;
    }

    @PutMapping("/personas")
    public Persona updatePersona(@RequestBody Persona persona){

        for (Persona per : personas){
            if (per.getId().equals(persona.getId())) {
                per.setName(persona.getName());
                per.setLastName(persona.getLastName());
                return per;
            }
        }
        return null;
    }


    @DeleteMapping("/personas/{id}")
    public void deletePersona(@PathVariable Long id ){
        /*
        * for (Persona persona : personas){
            if (persona.getId().equals(id))
                this.personas.remove(persona);
        }
        * */
        personas.removeIf(persona -> persona.getId().equals(id));
    }


}
