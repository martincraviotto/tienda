package com.maac.personal.tienda.configurations;

import io.swagger.v3.oas.annotations.OpenAPIDefinition;
import io.swagger.v3.oas.annotations.info.Contact;
import io.swagger.v3.oas.annotations.info.Info;
import io.swagger.v3.oas.annotations.info.License;
import io.swagger.v3.oas.annotations.servers.Server;

@OpenAPIDefinition(
        info = @Info(
                title = "Tienda Escuela IT Api",
                description = "Tienda Escuela IT Microservice",
                contact = @Contact(
                        name = "Martin Craviotto",
                        url = "http:\\google.com",
                        email = "martincraviotto@gmail.com"
                ),
                license = @License(
                        name = "MIT License",
                        url = "http://github.com/thombergs/code-examples/blob/master/LICENSE"
                )
        ),
        servers = @Server(
                url = "http://localhost:8080"
        )
)

public class SwaggerConfiguration {
}
