package Analisis;

/**
 *
 * @author Nicolay
 */
import java.util.ArrayList;
import java.util.List;

public class GeneradorAleatorio {

    // Parámetros del método congruencial lineal
    private static final long A = 1664525;
    private static final long C = 1013904223;
    private static final long M  = (long) Math.pow(2, 32);

    public static List<Double> generarNumeros(long semilla, int cantidad) {
        List<Double> numeros = new ArrayList<>();
        long x = semilla;

        for (int i = 0; i < cantidad; i++) {
            x = (A * x + C) % M;
            double normalizado = (double) x / M;
            numeros.add(normalizado);
        }

        return numeros;
    }

    public static void main(String[] args) {
        long semilla = 123456789; // Puedes cambiarla por cualquier otro valor
        List<Double> secuencia = generarNumeros(semilla, 100);

        System.out.println("🔢 Primeros 10 valores normalizados:");
        for (int i = 0; i < 10; i++) {
            System.out.printf("%.10f%n", secuencia.get(i));
        }
    }
}