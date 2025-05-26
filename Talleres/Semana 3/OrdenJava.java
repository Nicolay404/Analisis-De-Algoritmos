/*
 * Click nbfs://nbhost/SystemFileSystem/Templates/Licenses/license-default.txt to change this license
 * Click nbfs://nbhost/SystemFileSystem/Templates/Classes/Class.java to edit this template
 */
package TareaAnalisis;

/**
 *
 * @author Nicolay
 */

public class OrdenJava {

    public static void main(String[] args) {
        int[] array = {4,8,6,2,5,7,1};
        // int[] array = {2,4,8,10,12};
        
        // Ejemplo de uso
        int p = 0;
        int q = (array.length - 1) / 2;
        int r = array.length - 1;

        merge(array, p, q, r);

        // Imprimir el array resultante
        for (int num : array) {
            System.out.print(num + " ");
        }
        
    }
    
    public static void merge(int[] A, int p, int q, int r) {
        int nL = q - p + 1; // Tamaño de L
        int nR = r - q;     // Tamaño de R

        int[] L = new int[nL];
        int[] R = new int[nR];

        // Copiar elementos en L
        for (int i = 0; i < nL; i++) {
            L[i] = A[p + i];
        }

        // Copiar elementos en R
        for (int j = 0; j < nR; j++) {
            R[j] = A[q + 1 + j];
        }

        int i = 0; // índice en L
        int j = 0; // índice en R
        int k = p; // índice en A

        // Combinar los arreglos
        while (i < nL && j < nR) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        // Copiar los elementos restantes de L, si quedan
        while (i < nL) {
            A[k] = L[i];
            i++;
            k++;
        }

        // Copiar los elementos restantes de R, si quedan
        while (j < nR) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    

}
