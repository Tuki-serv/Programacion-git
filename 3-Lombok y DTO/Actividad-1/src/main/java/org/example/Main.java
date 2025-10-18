package org.example;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        Persona p1 = new Persona("Lucas",22);
        System.out.println(p1);

        Persona p2 = new Persona();
        p2.setNombre("Lucia");
        p2.setEdad(25);
        System.out.println(p2);
    }
}