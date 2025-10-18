package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Usuario u1 = Usuario.builder()
                .id("1")
                .nombre("pedro")
                .email("pedro@email.com")
                .build();

        Usuario u2 = Usuario.builder()
                .id("2")
                .nombre("lucía")
                .email("lucia@email.com")
                .build();

        // Imprimir los datos por consola
        System.out.println("Usuario 1: " + u1);
        System.out.println("Usuario 2: " + u2);

    }
}