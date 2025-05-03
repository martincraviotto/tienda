package com.maac.personal.tienda.configurations;

import lombok.Data;
import org.springframework.boot.context.properties.ConfigurationProperties;
import org.springframework.context.annotation.Configuration;
import org.springframework.context.annotation.PropertySource;

@Data
@Configuration
@ConfigurationProperties(prefix = "tienda")
@PropertySource(value = "classpath:parametros.properties")
public class TiendaParametrosConfig {

    //Se debe respetar el mismo nombre de los parametros que figuran en el application.properties
    private String moneda;
    private String region;
}
