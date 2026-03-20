public class MergeSort{

    /**
     * Procedimento principal: Algorito 3: Merge Sort
     */

    static int comparacoes;

    public static void mergeSort(int A[], int p, int r){
        if(p < r){
            // chamadas recursivas
            int q = (p + r) / 2;
            mergeSort(A, p, q); // metade esquerda
            mergeSort(A, q+1, r); // metade direita
            merge(A, p, q, r); // itercalação
        }// criterio de parada p >= r
    }

    /**
     * Intercalação: Algoritmo 2: Merge
     */
    public static void merge(int[] A, int p, int q, int r){
        int n1 = q - p + 1; // tamanho da metade esquerda
        int n2 = r - q; // tamanho da metade direita

        int[] L = new int[n1+1];
        int[] R = new int[n2+1];

        // Copia a metade esquerda para L
        for(int i = 0; i < n1; i++){
            L[i] = A[p+i];
        }

        // Copia a metade direita para R
        for(int j = 0; j < n2; j++){
            R[j] = A[q+1+j];
        }

        // Sentinelas
        L[n1] = Integer.MAX_VALUE;
        R[n2] = Integer.MAX_VALUE;

        // Intercalação
        int i = 0, j = 0;
        for(int k = p; k <= r; k++){
            comparacoes++;
            if(L[i] <= R[j]){
                A[k] = L[i];
                i++;
            }else{ // L[i] > R[j]
                A[k] = R[j];
                j++;
            }
        }
    }

    public static void imprimirVetor(int[] A){
        System.out.print("[");
        for(int i=0; i < A.length; i++){
            System.out.print(A[i]);
            if(i < A.length-1) System.out.print(", ");
        }
        System.out.print("]");
    }

    // Método main para teste
    public static void main(String[] args){
        int[] A = {38, 27, 43, 3, 9, 82, 10, 5};
        
        // imprimindo antes da ordenação
        System.out.println("Vetor original: ");
        imprimirVetor(A);

        mergeSort(A, 0, A.length-1);

        // imprimindo depois da ordenação
        System.out.println("\nVetor ordenado: ");
        imprimirVetor(A);

        System.out.println("\nComparacoes: " + comparacoes); //Complexidade = n * logn
        // 24 comparacoes = n * logn; n = 8, logn = 3; 2^3 = 8
        // n * logn = 8 * 3 = 24
    }
}