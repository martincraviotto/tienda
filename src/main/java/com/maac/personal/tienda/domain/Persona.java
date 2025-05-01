package com.maac.personal.tienda.domain;

import lombok.*;

@Data
//@AllArgsConstructor
//@NoArgsConstructor
@RequiredArgsConstructor
public class Persona {


    private Long id;
    private String name;
    private String lastName;
}
