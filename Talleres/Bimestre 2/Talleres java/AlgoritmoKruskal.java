package Analisis;

/**
 *
 * @author Nicolay
 */
import java.util.*;

public class AlgoritmoKruskal {

    static class Arista implements Comparable<Arista> {

        int u, v, peso;

        Arista(int u, int v, int peso) {
            this.u = u;
            this.v = v;
            this.peso = peso;
        }

        public int compareTo(Arista otra) {
            return Integer.compare(this.peso, otra.peso);
        }
    }

    static int buscar(int[] conjunto, int x) {
        while (conjunto[x] != x) {
            x = conjunto[x];
        }
        return x;
    }

    static void fusionar(int[] conjunto, int x, int y) {
        conjunto[y] = x;
    }

    public static List<Arista> kruskal(int n, List<Arista> aristas) {
        Collections.sort(aristas);
        int[] conjunto = new int[n];
        for (int i = 0; i < n; i++) {
            conjunto[i] = i;
        }

        List<Arista> mst = new ArrayList<>();
        for (Arista a : aristas) {
            int compU = buscar(conjunto, a.u);
            int compV = buscar(conjunto, a.v);
            if (compU != compV) {
                mst.add(a);
                fusionar(conjunto, compU, compV);
            }
        }
        return mst;
    }

    public static void main(String[] args) {
        List<Arista> aristas = Arrays.asList(
                new Arista(0, 1, 1), // 1 ↔ 2
                new Arista(1, 2, 2), // 2 ↔ 3
                new Arista(0, 3, 4), // 1 ↔ 4
                new Arista(1, 3, 6), // 2 ↔ 4
                new Arista(1, 4, 4), // 2 ↔ 5
                new Arista(2, 4, 5), // 3 ↔ 5
                new Arista(2, 5, 6), // 3 ↔ 6
                new Arista(3, 4, 3), // 4 ↔ 5
                new Arista(3, 6, 4), // 4 ↔ 7
                new Arista(4, 5, 8), // 5 ↔ 6
                new Arista(4, 6, 7), // 5 ↔ 7
                new Arista(5, 6, 3) // 6 ↔ 7
        );

        int n = 7;
        List<Arista> mst = kruskal(n, aristas);

        System.out.println("Árbol de expansión mínima:");
        for (Arista a : mst) {
            System.out.println("Nodo " + (a.u + 1) + " ↔ Nodo " + (a.v + 1) + " con peso " + a.peso);
        }
    }
}
