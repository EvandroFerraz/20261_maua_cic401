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

    // Teste de Mesa:
    // A = |2|5|6|4|, n = 4

    // 1ª iteração: j = 1
    // chave = A[j] = A[1] = 5
    // i = j - 1 = 0
    // 1ª comparação: while (i >= 0 && A[0] > chave), então while(0 >= 0 && 2 > 5) - false, sem deslocamento
    // A[i + 1] = chave, então A[1] = 5, A = |2|5|6|4|

    // 2ª iteração: j = 2
    // chave = A[j] = A[2] = 6
    // i = j - 1 = 1
    // 1ª comparação: while (i >= 0 && A[1] > chave), então while(1 >= 0 && 5 > 6) - false, sem deslocamento
    // A[i + 1] = chave, então A[2] = 6, |2|5|6|4|

    // 3ª iteração: j = 3
    // chave = A[j] = A[3] = 4
    // i = j - 1 = 2
    // 1ª comparação: while (i >= 0 && A[2] > chave), então while(2 >= 0 && 6 > 4) - verdadeiro, ocorre deslocamento
    // A[i + 1] = A[i], então A[3] = 6, A = |2|5|6|6|
    // i = i - 1, então i = 1
    // 2ª comparação: while (i >= 0 && A[1] > chave), então while(1 >= 0 && 5 > 4) - verdadeiro, ocorre deslocamento
    // A[i + 1] = A[i], então A[2] = 5, A = |2|5|5|6|
    // i = i - 1, então i = 0
    // 3ª comparação: while(0 >= 0 && 2 > 4) - false, sem deslocamento
    // A[i + 1] = chave, então A[1] = 4, A = |2|4|5|6|

    // 4ª iteração: j = n = 4, for se encerra pois j < n é falso
    // Resultado: A = |2|4|5|6|

    public static void main(String[] args) {
        int[] A = { 2, 5, 6, 4 };
        System.out.println("Antes: " + java.util.Arrays.toString(A));
        insertionSort(A);
        System.out.println("Depois: " + java.util.Arrays.toString(A));
    }
}
