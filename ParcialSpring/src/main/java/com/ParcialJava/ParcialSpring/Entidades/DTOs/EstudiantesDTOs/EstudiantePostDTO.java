package com.ParcialJava.ParcialSpring.Entidades.DTOs.EstudiantesDTOs;

import jakarta.validation.constraints.NotBlank;

public record EstudiantePostDTO(
        @NotBlank(message = "El nombre no puede estar vacío")
        String nombre,

        @NotBlank(message = "La matrícula no puede estar vacía")
        String matricula
) {}
