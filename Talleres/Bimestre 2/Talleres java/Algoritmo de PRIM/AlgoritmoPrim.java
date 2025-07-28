package Analisis;

import java.util.*;

// Clase que representa una arista entre dos nodos con peso
class Arista implements Comparable<Arista> {
    int origen, destino, peso;

    public Arista(int origen, int destino, int peso) {
        this.origen = origen;
        this.destino = destino;
        this.peso = peso;
    }

    // Orden por peso ascendente (para la cola de prioridad)
    @Override
    public int compareTo(Arista otra) {
        return Integer.compare(this.peso, otra.peso);
    }

    // Representación legible de la arista
    @Override
    public String toString() {
        return "{" + (origen + 1) + "," + (destino + 1) + "}";
    }
}

public class AlgoritmoPrim {

    // Algoritmo de Prim con trazabilidad
    static List<Arista> prim(int n, List<List<Arista>> grafo) {
        boolean[] visitado = new boolean[n];               // Nodos visitados
        PriorityQueue<Arista> cola = new PriorityQueue<>(); // Aristas ordenadas por peso
        List<Arista> mst = new ArrayList<>();               // Árbol resultante
        Set<Integer> B = new HashSet<>();                   // Conjunto de visitados

        visitado[0] = true;
        B.add(0);
        cola.addAll(grafo.get(0));

        // Cabecera para la prueba de escritorio
        System.out.printf("%-25s %-20s %-20s %-10s %-5s\n",
                " (T)", " (B)", "(N/B)", "Arista", "Peso");
        System.out.println("----------------------------------------------------------------------");

        while (mst.size() < n - 1 && !cola.isEmpty()) {
            Arista actual = cola.poll();

            if (visitado[actual.destino]) continue;

            visitado[actual.destino] = true;
            mst.add(actual);
            B.add(actual.destino);
            cola.addAll(grafo.get(actual.destino));

            Set<Integer> noVisitados = new HashSet<>();
            for (int i = 0; i < n; i++) {
                if (!visitado[i]) noVisitados.add(i);
            }

            // Mostrar paso actual
            System.out.printf("%-25s %-20s %-20s %-10s %-5d\n",
                    mst.toString(),
                    mostrar(B),
                    mostrar(noVisitados),
                    actual.toString(),
                    actual.peso
            );
        }

        return mst;
    }

    // Convierte el conjunto de nodos a una lista legible del 1 al n
    static String mostrar(Set<Integer> conjunto) {
        List<Integer> lista = new ArrayList<>();
        for (int x : conjunto) {
            lista.add(x + 1);
        }
        return lista.toString();
    }

    public static void main(String[] args) {
        int n = 7; // Número de nodos
        List<List<Arista>> grafo = new ArrayList<>();

        // Inicializar lista de adyacencia
        for (int i = 0; i < n; i++) grafo.add(new ArrayList<>());

        // Inserciones actualizadas basadas en la nueva imagen
        agregarBidireccional(grafo, 0, 1, 1);  // Nodo 1 - Nodo 2
        agregarBidireccional(grafo, 0, 3, 4);  // Nodo 1 - Nodo 4
        agregarBidireccional(grafo, 1, 2, 2);  // Nodo 2 - Nodo 3
        agregarBidireccional(grafo, 1, 3, 6);  // Nodo 2 - Nodo 4
        agregarBidireccional(grafo, 1, 4, 4);  // Nodo 2 - Nodo 5
        agregarBidireccional(grafo, 2, 5, 6);  // Nodo 3 - Nodo 6
        agregarBidireccional(grafo, 3, 4, 3);  // Nodo 4 - Nodo 5
        agregarBidireccional(grafo, 3, 6, 4);  // Nodo 4 - Nodo 7
        agregarBidireccional(grafo, 4, 5, 8);  // Nodo 5 - Nodo 6
        agregarBidireccional(grafo, 4, 6, 7);  // Nodo 5 - Nodo 7
        agregarBidireccional(grafo, 5, 6, 3);  // Nodo 6 - Nodo 7

        // Ejecutar algoritmo de Prim
        List<Arista> mst = prim(n, grafo);

        // Mostrar resultado final
        System.out.println("\nÁrbol de Expansión Mínima Final:");
        for (Arista a : mst) {
            System.out.printf("• %d - %d (peso: %d)\n", a.origen + 1, a.destino + 1, a.peso);
        }
    }

    // Método auxiliar para agregar aristas en ambas direcciones
    static void agregarBidireccional(List<List<Arista>> grafo, int u, int v, int peso) {
        grafo.get(u).add(new Arista(u, v, peso));
        grafo.get(v).add(new Arista(v, u, peso));
    }
}