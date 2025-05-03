package com.maac.personal.tienda.services;

import com.maac.personal.tienda.domain.Persona;
import com.maac.personal.tienda.helpers.ReportePDFImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;

//@Primary
@Slf4j
@Lazy
@Service("jugadores")
@ConditionalOnProperty(prefix = "implementacion", value = "personas", havingValue = "jugadores")
public class PersonasServiceJugadoresImpl implements PersonasService {

    ReportePDFImpl reportePDF;

    ArrayList<Persona> juradores = new ArrayList<>(
            List.of(new Persona(1L,"Maradona"),
                    new Persona(2L,"Messi"),
                    new Persona(3L,"Andujar")
            )
    );

    public PersonasServiceJugadoresImpl(ReportePDFImpl reportePDF) {
        this.reportePDF=reportePDF;
        //System.out.println("Ejecutando constructor PersonasServiceJugadoresImpl");
        log.info("Ejecutando constructor PersonasServiceJugadoresImpl");
    }

    public List<Persona> listAllPersonas(){
        this.reportePDF.generatePdfReport(this.juradores);
        return this.juradores;
    }

}
