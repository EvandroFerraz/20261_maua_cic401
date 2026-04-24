import java.util.Arrays;

public class PilhaArray {

    // Array interno que armazena os elementos da pilha
    private int[] dados;

    // indice do elemento no topo (-1 significa pilha vazia)
    private int topo;

    // Inicializa o array com tamanho n
    public PilhaArray(int capacidade) {
        dados = new int[capacidade];
        topo = -1;
    }

    // Θ(1) — incrementa topo e insere o valor na próxima posição livre
    public void push(int valor) {
        if (topo == dados.length - 1)
            throw new RuntimeException("Pilha cheia");
        dados[++topo] = valor; // pré-incremento
    }

    // Θ(1) — retorna o valor do topo e decrementa topo
    public int pop() {
        if (topo == -1)
            throw new RuntimeException("Pilha vazia");
        return dados[topo--]; // pós-decremento
    }

    // Θ(1) — retorna o valor do topo sem removê-lo
    public int peek() {
        if (topo == -1)
            throw new RuntimeException("Pilha vazia");
        return dados[topo];
    }

    // Θ(1) — compara topo com -1 para saber se a pilha está vazia
    public boolean estaVazia() {
        return topo == -1;
    }

    // Θ(1) — o tamanho é sempre topo + 1, sem necessidade de percorrer o array
    public int tamanho() {
        return topo + 1;
    }

    // Θ(n) — percorre todos os n elementos do array para montar a string
    @Override
    public String toString() {
        if (topo == -1)
            return "[]";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i <= topo; i++) {
            sb.append(dados[i]);
            if (i < topo)
                sb.append(", ");
        }
        sb.append("] (topo=").append(topo).append(")");
        return sb.toString();
    }

    // Exercicio 2 c), método corrigido
    public static boolean ehPalindromo(String s) {
        PilhaArray pilha = new PilhaArray(s.length());
        for (int i = 0; i < s.length(); i++) {
            pilha.push(s.charAt(i));
        }
        for (int i = 0; i < s.length(); i++) {
            if (s.charAt(i) != pilha.pop() ) {
                return false;
            }
        }
        return true;
    }

    // Exercício 6
    public static void inverter(int[] A){
        PilhaArray pilha = new PilhaArray(A.length);

        // Empilha todos os elementos na ordem na original
        for(int elemento : A)
            pilha.push(elemento);

        // Desempilha de volta no array - o topo sempre guarda o elemento mais recente,
        // então a ordem é naturalmente invertida (LIFO)
        for(int i = 0; i < A.length; i++)
            A[i] = pilha.pop(); // [5,4,3,2,1]
    }

    public static void main(String[] args){
        int[] A = {1,2,3,4,5};

        System.out.println("Antes: " + Arrays.toString(A));
        inverter(A);
        System.out.println("Depois: " + Arrays.toString(A));
        // Esperado: [5, 4, 3, 2, 1]
    }
}

/**
 * Exercicio 1 - Pilha
 * a)
 * Operação | Array (0..5)      | topo
 * push(10) | [10 _ _ _ _ _]    | 0
 * push(20) | [10 20 _ _ _ _]   | 1
 * push(30) | [10 20 30 _ _ _]  | 2
 * pop()    | [10 20 _ _ _ _]   | 1
 * push(40) | [10 20 40 _ _ _]  | 2
 * push(50) | [10 20 40 50 _ _] | 3
 * pop()    | [10 20 40 _ _ _]  | 2
 * pop()    | [10 20 _ _ _ _]   | 1
 * push(60) | [10 20 60 _ _ _]  | 2
 * 
 * b) 1 chamada de pop() remove 30
 *    2 chamada de pop() remove 50
 *    3 chamada de pop() remove 40
 * c) 60 é o topo atual da pilha, então mais uma chamada de pop() retornaria 60
 */

/** Exercício 2
 * a) Pilha após empilhamento dos caracteres de s = [a | b | a], 
 * o retorno seria false porém está errado porque "aba" é um palíndromo.
 * 
 * b) Para a string "abc" retorna true, que também está errado
 * pois "abc" não é um palíndromo
 */