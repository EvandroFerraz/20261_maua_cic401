import java.util.Arrays;
import java.util.Random;
import java.util.Scanner;

public class InsertionSortContador {

    static int comparacoes = 0;
    static int deslocamentos = 0;

    public static void insertionSort(int[] A) {
        int n = A.length;
        comparacoes = 0;
        deslocamentos = 0;

        for (int j = 1; j < n; j++) {
            int chave = A[j];
            int i = j - 1;

            while (i >= 0) {
                comparacoes++;
                if (A[i] > chave) {
                    deslocamentos++;
                    A[i + 1] = A[i];
                    i = i - 1;
                } else {
                    break;
                }
            }
            A[i + 1] = chave;
        }
    }

    public static void main(String[] args) {

        // Scanner sc = new Scanner(System.in);
        // System.out.print("Digite n: ");
        // int n = sc.nextInt();

        // int[] A = new int[n];

        // Random rand = new Random();
        
        // for(int i = 0; i < n; i++){
        //     A[i] = rand.nextInt(1000) + 1;
        // }

        //int[] A = {2, 6, 5, 10, 7, 4};
        //int[] A = {100, 90, 80, 70, 60, 50, 40, 30, 20, 10}; // total de 90 operacoes = Theta(n^2)
        int[] A = {10, 20, 30, 40, 50, 60, 70, 80, 90, 100}; // total de 9 operacoes, (n-1) = Theta(n)
        
        System.out.println("Antes: " + Arrays.toString(A));
        insertionSort(A);
        System.out.println("Depois: " + Arrays.toString(A));
        System.out.println("Comparacoes: " + comparacoes);
        System.out.println("Deslocamentos: " + deslocamentos);
    }
}
