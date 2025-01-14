package edu.escuelait.tienda.services;

import edu.escuelait.tienda.domain.Persona;
import edu.escuelait.tienda.helpers.ReportPDFImpl;
import lombok.extern.slf4j.Slf4j;
import org.springframework.beans.factory.annotation.Autowired;
import org.springframework.boot.autoconfigure.condition.ConditionalOnProperty;
import org.springframework.context.annotation.Lazy;
import org.springframework.context.annotation.Primary;
import org.springframework.stereotype.Service;

import java.util.ArrayList;
import java.util.List;


//@Primary --> es usa esta opción, o bien se utilizan los Qualifier como quedó implementado en definitiva
@Slf4j  //sirver para poner un logger (log)
@Lazy
@Service("jugadores")
@ConditionalOnProperty(prefix="implementacion" , value="personas", havingValue = "jugadores")
public class PersonasServiceJugadoresImpl implements  PersonasService{
    // @Autowired
    private ReportPDFImpl reportPDF;

    //Almancen para tener un lote de datos de prueba
    ArrayList<Persona> jugadores = new ArrayList<>(
//            List.of(new Persona(1L, "Diego", "Maradona"),
//                    new Persona(2L, "Alejandro", "Sabella"),
//                    new Persona(3L, "Benjamin", "Rollehiser"),
//                    new Persona(4L, "Diego1", "Maradona1"),
//                    new Persona(5L, "Alejandro1", "Sabella1"),
//                    new Persona(6L, "Benjamin1", "Rollehiser1"),
//                    new Persona(7L, "Diego2", "Maradona2"),
//                    new Persona(8L, "Alejandro2", "Sabella2"),
//                    new Persona(9L, "Benjamin2", "Rollehiser2"),
//                    new Persona(10L, "Diego3", "Maradona3"),
//                    new Persona(11L, "Diego1111", "Mansilla"),
//                    new Persona(12L, "Alejandro3", "Sabella3"),
//                    new Persona(13L, "Benjamin3", "Rollehiser3"),
//                    new Persona(14L, "Diego4", "Maradona4"),
//                    new Persona(15L, "Alejandro4", "Sabella4"),
//                    new Persona(16L, "Benjamin4", "Rollehiser4"),
//                    new Persona(17L, "Diego5", "Maradona5"),
//                    new Persona(18L, "Alejandro5", "Sabella5"),
//                    new Persona(19L, "Benjamin5", "Rollehiser5"),
//                    new Persona(20L, "Diego6", "Maradona6"),
//                    new Persona(21L, "Alejandro6", "Sabella6"),
//                    new Persona(22L, "Benjamin6", "Rollehiser6"),
//                    new Persona(23L, "Diego7", "Maradona7"),
//                    new Persona(24L, "Alejandro7", "Sabella7"),
//                    new Persona(25L, "Benjamin7", "Rollehiser7"),
//                    new Persona(26L, "Diego8", "Maradona8"),
//                    new Persona(27L, "Alejandro8", "Sabella8"),
//                    new Persona(28L, "Benjamin8", "Rollehiser8")
            List.of(new Persona(1L, "Diego"),
                    new Persona(2L, "Alejandro"),
                    new Persona(3L, "Benjamin"),
                    new Persona(4L, "Diego1"),
                    new Persona(5L, "Alejandro1"),
                    new Persona(6L, "Benjamin1"),
                    new Persona(26L, "Diego8"),
                    new Persona(27L, "Alejandro8"),
                    new Persona(28L, "Benjamin8")
                    )
    );


    public PersonasServiceJugadoresImpl( ReportPDFImpl reportPDF){
        this.reportPDF=reportPDF;
        log.info("Ejecutando constructor PersonasServiceJugadoresImpl");
    }

    public List<Persona> listAllPersonas(){
        this.reportPDF.generatePdfReport(this.jugadores);
        return this.jugadores;
    }

}
