package org.example;


import lombok.Builder;
import lombok.Data;
import lombok.ToString;

@Data
@Builder
@ToString
public class Usuario {
    private String id;
    private String nombre;
    private String email;

}
