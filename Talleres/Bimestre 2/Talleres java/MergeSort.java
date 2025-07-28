package Analisis;

/**
 *
 * @author Nicolay
 */
public class MergeSort {

    public static void mergeSort(int[] A, int p, int r) {
        if (p >= r) {
            return;
        }

        int q = (p + r) / 2;
        mergeSort(A, p, q);
        mergeSort(A, q + 1, r);
        merge(A, p, q, r);
    }

    public static void merge(int[] A, int p, int q, int r) {
        int n_L = q - p + 1;
        int n_R = r - q;

        int[] L = new int[n_L];
        int[] R = new int[n_R];

        for (int i = 0; i < n_L; i++) {
            L[i] = A[p + i];
        }
        for (int j = 0; j < n_R; j++) {
            R[j] = A[q + 1 + j];
        }

        int i = 0, j = 0, k = p;

        while (i < n_L && j < n_R) {
            if (L[i] <= R[j]) {
                A[k] = L[i];
                i++;
            } else {
                A[k] = R[j];
                j++;
            }
            k++;
        }

        while (i < n_L) {
            A[k] = L[i];
            i++;
            k++;
        }

        while (j < n_R) {
            A[k] = R[j];
            j++;
            k++;
        }
    }

    public static void main(String[] args) {
        int[] A = {3, 7, 9, 14, 6, 11, 2};
        mergeSort(A, 0, A.length - 1);

        System.out.print("Arreglo ordenado: ");
        for (int num : A) {
            System.out.print(num + " ");
        }
    }
}