package com.ParcialJava.ParcialSpring.Entidades.DTOs.CursoDTOs;

import jakarta.validation.constraints.NotBlank;
import jakarta.validation.constraints.NotNull;

public record CursoPostDTO(
        @NotBlank(message = "El nombre del curso no puede estar vacío")
        String nombre,

        @NotNull(message = "El ID del profesor es obligatorio")
        Long profesorId
) {}