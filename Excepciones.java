import java.io.IOException;

// Definición de la clase ExcepcionA, que extiende Exception
/**
 * Clase personalizada ExcepcionA que hereda de la clase Exception.
 * Representa un tipo de excepción específico y personalizado.
 * 
 * @author Niurka Vanesa Yupanqui
 * @version 1.0
 * @date 11/11/2024
 *       Progra II
 */

class ExcepcionA extends Exception {
    /**
     * Constructor de ExcepcionA que toma un mensaje de error y lo pasa a la
     * superclase Exception.
     * 
     * @param message El mensaje de error de la excepción.
     */
    public ExcepcionA(String message) {
        super(message);
    }
}

// Definición de la clase ExcepcionB, que extiende ExcepcionA
/**
 * Clase personalizada ExcepcionB que hereda de ExcepcionA.
 * Representa una excepción más específica que ExcepcionA.
 */
class ExcepcionB extends ExcepcionA {
    /**
     * Constructor de ExcepcionB que toma un mensaje de error y lo pasa a la
     * superclase ExcepcionA.
     * 
     * @param message El mensaje de error de la excepción.
     */
    public ExcepcionB(String message) {
        super(message);
    }
}

// Clase principal que contiene el método main
public class Excepciones {
    public static void main(String[] args) {
        // Creación de un arreglo de excepciones de diferentes tipos
        Exception[] excepciones = {
                new ExcepcionA("Excepción de tipo A lanzada"),
                new ExcepcionB("Excepción de tipo B lanzada"),
                new NullPointerException("Excepción de tipo NullPointerException lanzada"),
                new IOException("Excepción de tipo IOException lanzada")
        };

        // Iteración a través del arreglo de excepciones
        for (Exception excepcion : excepciones) {
            try {
                // Lanza cada excepción en el arreglo
                throw excepcion;
            } catch (Exception e) {
                // Captura la excepción y muestra el mensaje de error correspondiente
                System.out.println("Excepción atrapada: " + e.getMessage());
            }
        }
    }
}
