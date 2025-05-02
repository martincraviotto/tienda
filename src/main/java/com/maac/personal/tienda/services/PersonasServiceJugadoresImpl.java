package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Persona;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Service("jugadores")
public class PersonasServiceJugadoresImpl implements PersonasService {


    ArrayList<Persona> personas = new ArrayList<>(
            List.of(new Persona(1L,"Maradona"),
                    new Persona(2L,"Messi"),
                    new Persona(3L,"Andujar")
            )
    );

    public List<Persona> listAllPersonas(){
        return this.personas;
    }

}
