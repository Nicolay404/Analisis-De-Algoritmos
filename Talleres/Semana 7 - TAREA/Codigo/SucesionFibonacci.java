package com.mycompany.Presentacion;

/**
 * Clase para calcular la sucesión de Fibonacci de manera recursiva.
 * 
 * @author Nicolay
 */
public class SucesionFibonacci {

    // Método recursivo para calcular el término n de Fibonacci
    public static int calcularFibonacci(int n) {
        if (n <= 0) return 0;
        if (n == 1) return 1;
        return calcularFibonacci(n - 1) + calcularFibonacci(n - 2);
    }

    public static void main(String[] args) {
        int limite = 10;

        System.out.println("\t\tRecursividad en Fibonacci");
        System.out.println("——→ Resultado de los términos desde F(0) hasta F(" + limite + "):");

        for (int i = 0; i <= limite; i++) {
            System.out.printf("F(%d) = %d\n", i, calcularFibonacci(i));
        }
    }
}