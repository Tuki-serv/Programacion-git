package com.ParcialJava.ParcialSpring.Entidades.DTOs.ProfesorDTOs;

import jakarta.validation.constraints.Email;

public record ProfesorUpdateDTO(
        String nombre,

        @Email(message = "El email debe tener un formato válido")
        String email
) {}
