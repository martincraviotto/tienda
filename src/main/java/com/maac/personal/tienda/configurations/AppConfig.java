package com.maac.personal.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;

@Data
@Configuration
@ConfigurationProperties(prefix = "app")
public class AppConfig {

    //Se debe respetar el mismo nombre de los parametros que figuran en el application.properties
    private String nombre;
    private String descripcion;
    private String language;
    private String version;

}
