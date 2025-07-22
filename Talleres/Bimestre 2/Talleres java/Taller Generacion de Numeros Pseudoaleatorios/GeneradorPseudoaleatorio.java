package Analisis;

/**
 *
 * @author Nicolay
 */
public class GeneradorPseudoaleatorio {
    public static void main(String[] args) {
        int cantidad = 10;
        long semilla = 24685;

        double[] numeros = generarPseudoaleatorios(semilla, cantidad);

        System.out.println("Números pseudoaleatorios generados:");
        for (double num : numeros) {
            System.out.println(num);
        }
    }

    public static double[] generarPseudoaleatorios(long semilla, int cantidad) {
        // Parámetros del generador (Numerical Recipes)
        long a = 1664525;
        long c = 1013904223;
        long m = (long) Math.pow(2, 32);

        double[] resultados = new double[cantidad];
        long x = semilla;

        for (int i = 0; i < cantidad; i++) {
            x = (a * x + c) % m;
            resultados[i] = (double) x / m; // Normalización a [0, 1]
        }

        return resultados;
    }
}