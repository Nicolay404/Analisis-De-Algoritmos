package Algoritmos;

import java.util.*;

import java.util.ArrayList;
import java.util.Arrays;
import java.util.HashSet;
import java.util.List;
import java.util.Set;

public class AlgoritmoDijkstra {

    static final int INF = Integer.MAX_VALUE;

    public static void main(String[] args) {

        int[][] L = new int[5][5];
        for (int i = 0; i < 5; i++) {
            Arrays.fill(L[i], INF);
        }

        // Aristas 
        L[0][1] = 10;   // 1 -> 2
        L[0][4] = 100;  // 1 -> 5
        L[0][3] = 30;   // 1 -> 4
        L[1][2] = 50;   // 2 -> 3
        L[3][2] = 20;   // 4 -> 3
        L[3][4] = 60;   // 4 -> 5
        L[2][4] = 10;   // 3 -> 5

        dijkstraConsola(L, 0); // Nodo fuente = 0 (nodo 1)
    }

    static void dijkstraConsola(int[][] L, int fuente) {
        int n = L.length;
        int[] D = new int[n];
        boolean[] visitado = new boolean[n];
        Set<Integer> C = new HashSet<>();
        Set<Integer> S = new HashSet<>();

        Arrays.fill(D, INF);
        D[fuente] = 0;

        // Inicializar C y S
        for (int i = 0; i < n; i++) {
            if (i != fuente) {
                C.add(i);
            }
        }
        S.add(fuente);
        visitado[fuente] = true;

        // Relajar vecinos iniciales
        for (int w = 0; w < n; w++) {
            if (L[fuente][w] != INF) {
                D[w] = L[fuente][w];
            }
        }

        // Cabecera de tabla
        System.out.printf("%-7s %-20s %-20s %-30s\n", "V", "C", "S", "D");
        System.out.println("----------------------------------------------------------------------------");

        // Mostrar primer paso
        mostrarPaso(fuente, C, S, D);

        // Iteraciones restantes
        for (int iter = 0; iter < n - 1; iter++) {
            int v = -1, minDist = INF;

            for (int i = 0; i < n; i++) {
                if (!visitado[i] && D[i] < minDist) {
                    minDist = D[i];
                    v = i;
                }
            }

            if (v == -1) {
                break;
            }

            visitado[v] = true;
            C.remove(v);
            S.add(v);

            // Relajar vecinos
            for (int w = 0; w < n; w++) {
                if (!visitado[w] && L[v][w] != INF) {
                    D[w] = Math.min(D[w], D[v] + L[v][w]);
                }
            }

            mostrarPaso(v, C, S, D);
        }

        // Mostrar resultado final
        System.out.println("\nDistancias mínimas desde el nodo 1:");
        for (int i = 1; i < n; i++) {
            String dist = (D[i] == INF) ? "∞" : String.valueOf(D[i]);
            System.out.printf("• Nodo %d: %s\n", i + 1, dist);
        }
    }

    static void mostrarPaso(int v, Set<Integer> C, Set<Integer> S, int[] D) {
        System.out.printf("%-7s %-20s %-20s %-30s\n",
                (v + 1),
                convertir(C),
                convertir(S),
                mostrarD(D)
        );
    }

    static String convertir(Set<Integer> conjunto) {
        List<Integer> lista = new ArrayList<>();
        for (int x : conjunto) {
            lista.add(x + 1);
        }
        return lista.toString();
    }

    static String mostrarD(int[] D) {
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < D.length; i++) {
            sb.append((D[i] == INF ? "∞" : D[i]));
            if (i < D.length - 1) {
                sb.append(", ");
            }
        }
        return sb.append("]").toString();
    }
}
