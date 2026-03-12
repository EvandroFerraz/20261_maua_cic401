public class InsertionSort {

    // Implementação Insertion Sort
    public static void insertionSort(int[] A) {
        int n = A.length;
        for (int j = 1; j < n; j++) {
            int chave = A[j];
            int i = j - 1;
            while (i >= 0 && A[i] > chave) {
                A[i + 1] = A[i];
                i = i - 1;
            }
            A[i + 1] = chave;
        }
    }

    public static void main(String[] args) {
        int[] A = { 2, 5, 6, 4 };
        System.out.println("Antes: " + java.util.Arrays.toString(A));
        insertionSort(A);
        System.out.println("Depois: " + java.util.Arrays.toString(A));
    }
}
