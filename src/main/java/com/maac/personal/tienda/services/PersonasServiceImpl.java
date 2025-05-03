package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Persona;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("astronautas")
@ConditionalOnProperty(prefix = "implementacion", value = "personas", havingValue = "astronautas")
public class PersonasServiceImpl implements PersonasService {


    ArrayList<Persona> astronautas = new ArrayList<>(
            List.of(new Persona(1L,"Amstrong"),
                    new Persona(2L,"Aldrin"),
                    new Persona(3L,"Collins")
            )
    );

    public List<Persona> listAllPersonas(){
        return this.astronautas;
    }

}
