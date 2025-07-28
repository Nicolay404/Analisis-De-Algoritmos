package Analisis;

/**
 *
 * @author Nicolay
 */
import java.util.*;
import java.util.ArrayList;
import java.util.List;

public class Cambio {

    public static List<Integer> devolverCambio(int n) {
        int[] C = {100, 25, 10, 5, 1}; // monedas disponibles
        List<Integer> S = new ArrayList<>(); // conjunto solución
        int s = 0; // suma acumulada

        while (s != n) {
            int x = -1;
            for (int coin : C) {
                if (s + coin <= n) {
                    x = coin;
                    break; // encuentra la moneda más grande posible
                }
            }

            if (x == -1) {
                System.out.println("No encuentro la solución");
                return S;
            }

            S.add(x);
            s += x;
        }

        return S;
    }

    public static void main(String[] args) {
        int n = 55;
        List<Integer> resultado = devolverCambio(n);
        System.out.println("Cambio para " + n + ": " + resultado);
    }
}