package com.maac.personal.tienda.helpers;


import com.maac.personal.tienda.domain.Persona;
import com.maac.personal.tienda.stereotype.Report;
import lombok.extern.slf4j.Slf4j;
import org.springframework.stereotype.Component;

import java.util.List;

@Slf4j
@Report
public class ReportePDFImpl {

    public void generatePdfReport(List<Persona> personas){
        log.info("Generate pdf Report {}",personas);
    }
}
