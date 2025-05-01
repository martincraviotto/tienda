package com.maac.personal.tienda.controllers;

import com.maac.personal.tienda.domain.Persona;
import org.springframework.web.bind.annotation.DeleteMapping;
import org.springframework.web.bind.annotation.GetMapping;
import org.springframework.web.bind.annotation.PathVariable;
import org.springframework.web.bind.annotation.RestController;

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

    public Persona createPersona(Persona persona){
        return null;
    }

    public Persona updatePersona(Persona persona){
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
