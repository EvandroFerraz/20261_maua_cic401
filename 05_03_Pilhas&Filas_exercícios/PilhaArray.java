import java.util.Arrays;

public class PilhaArray {

    // Array interno que armazena os elementos da pilha
    private int[] dados;

    // Índice do elemento no topo (-1 significa pilha vazia)
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
        return dados[topo--]; // pós-incremento
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
}
