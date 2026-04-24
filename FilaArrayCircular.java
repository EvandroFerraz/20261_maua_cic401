public class FilaArrayCircular {

    // Array interno que armazena os elementos
    private int[] dados;

    // indice do primeiro elemento (frente da fila)
    private int inicio;

    // indice do último elemento inserido
    private int fim;

    // Quantidade atual de elementos na fila
    private int tamanho;

    // Aloca o array de tamanho n e inicializa os atributos
    public FilaArrayCircular(int capacidade) {
        dados = new int[capacidade];
        inicio = 0;
        fim = -1;
        tamanho = 0;
    }

    // Θ(1) — avança fim circularmente e insere o valor
    public void enqueue(int valor) {
        if (tamanho == dados.length)
            throw new RuntimeException("Fila cheia");
        fim = (fim + 1) % dados.length; // wrap-around: volta ao índice 0 quando chega no fim
        // [3 4 5 _]
        // dequeue(); [_ 4 5 _], inicio = 1
        // enqueue(7); [_ 4 5 7], fim = 3
        // equeue(2); fim = (fim + 1) % 4 = 4 % 4 = 0; [2 4 5 7], fim = 0, inicio = 1
        dados[fim] = valor;
        tamanho++;
    }

    // Θ(1) — lê o valor da frente, avança inicio circularmente e diminui tamanho
    public int dequeue() {
        if (tamanho == 0)
            throw new RuntimeException("Fila vazia");
        int valor = dados[inicio];
        // sobrescrevo o primeira posicao da fila pela segunda
        // a segunda posicao se torna o novo inicio
        inicio = (inicio + 1) % dados.length; // wrap-around
        tamanho--;
        return valor;
    }

    // Θ(1) — retorna o elemento da frente sem removê-lo
    public int peek() {
        if (tamanho == 0)
            throw new RuntimeException("Fila vazia");
        return dados[inicio];
    }

    // Θ(1) — compara tamanho com zero
    public boolean estaVazia() {
        return tamanho == 0;
    }

    // Θ(1) — retorna o campo tamanho diretamente
    public int tamanho() {
        return tamanho;
    }

    // Θ(n) — percorre todos os n elementos na ordem lógica da fila para montar a
    // string
    @Override
    public String toString() {
        if (tamanho == 0)
            return "[] (inicio=" + inicio + ", fim=" + fim + ", tamanho=0)";
        StringBuilder sb = new StringBuilder("[");
        for (int i = 0; i < tamanho; i++) {
            sb.append(dados[(inicio + i) % dados.length]);
            if (i < tamanho - 1)
                sb.append(", ");
        }
        sb.append("] (inicio=").append(inicio)
                .append(", fim=").append(fim)
                .append(", tamanho=").append(tamanho).append(")");
        return sb.toString();
    }

    // Θ(n) — exibe o array interno bruto (útil para depurar o wrap-around)
    public String arrayInterno() {
        StringBuilder sb = new StringBuilder("array bruto: [");
        for (int i = 0; i < dados.length; i++) {
            sb.append(dados[i]);
            if (i < dados.length - 1)
                sb.append(", ");
        }
        sb.append("]");
        return sb.toString();
    }

    // Exercício 13 
    
}

/** Exercicio 9
 * a)
 * Operação | Array (0..4)       | inicio | fim | tamanho
 * enqueue(10) | [10 _ _ _ _]    | 0      | 0   | 1
 * enqueue(20) | [10 20 _ _ _]   | 0      | 1   | 2
 * enqueue(30) | [10 20 30 _ _]  | 0      | 2   | 3
 * dequeue()   | [_ 20 30 _ _]   | 1      | 2   | 2
 * dequeue()   | [_ _ 30 _ _]    | 2      | 2   | 1 
 * enqueue(40) | [_ _ 30 40 _]   | 2      | 3   | 2
 * enqueue(50) | [_ _ 30 40 50]  | 2      | 4   | 3
 * enqueue(60) | [60 _ 30 40 50] | 2      | 0   | 4
 * (fim + 1) % array.length = (4 + 1) % 5 = 5 % 5 = 0
 * 
 * b) No enqueue(60)
 * c) [60 _ 30 40 50], todas as posições menos o índice estão ocupadas
 */
