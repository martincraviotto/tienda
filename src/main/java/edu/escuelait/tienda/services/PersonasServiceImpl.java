package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


@Service("astronautas")
@Slf4j
@ConditionalOnProperty(prefix="implementacion" , value="personas", havingValue = "astronautas")
public class PersonasServiceImpl implements  PersonasService{

    //Almancen para tener un lote de datos de prueba
    ArrayList<Persona> astronautas = new ArrayList<>(
//            List.of(new Persona(1L, "Neil", "Armstrong"),
//                    new Persona(2L, "Edwin", "Aldrin"),
//                    new Persona(3L, "John", "Collins"))
            List.of(new Persona(1L, "Neil"),
                    new Persona(2L, "Edwin"),
                    new Persona(3L, "John"))

    );


    public PersonasServiceImpl(){
        log.info("Iniciando PersonasServiceImpl");
    }

    public List<Persona> listAllPersonas(){
        return this.astronautas;
    }

}
