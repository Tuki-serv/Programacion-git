package org.example;

import Reflections.Persona;

import java.lang.reflect.Constructor;
import java.lang.reflect.Field;
import java.lang.reflect.Method;

//TIP To <b>Run</b> code, press <shortcut actionId="Run"/> or
// click the <icon src="AllIcons.Actions.Execute"/> icon in the gutter.
public class Main {
    public static void main(String[] args) {
        try {
            Class<?> clase = Class.forName("Reflections.Persona");
            System.out.println(clase);

            Object persona = clase.getDeclaredConstructor().newInstance();

            Constructor<?>[] constructores = clase.getConstructors();
            System.out.println("Constructores");
            for (Constructor<?> constructor : constructores){
                System.out.println(" "+ constructor.getName()+": ");
                Class<?>[] parametros = constructor.getParameterTypes();
                for (Class<?> p : parametros){
                    System.out.print(p.getSimpleName());
                    System.out.println("");
                }
            }

            Field nombreField = clase.getDeclaredField("nombre");
            nombreField.setAccessible(true);
            nombreField.set(persona, "Lucas");

            Field edadField = clase.getDeclaredField("edad");
            edadField.setAccessible(true);
            edadField.set(persona, 22);

            Method mostrar = clase.getMethod("toString");
            Object resultado = mostrar.invoke(persona);
            System.out.println(resultado);

            Method saludar = clase.getMethod("saludar");
            saludar.setAccessible(false);


        }catch (Exception e){
            e.printStackTrace();
        }
    }
}