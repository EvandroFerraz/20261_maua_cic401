public class FilaArrayCircular {

    // Array interno que armazena os elementos
    private int[] dados;

    // Índice do primeiro elemento (frente da fila)
    private int inicio;

    // Índice do último elemento inserido
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
        dados[fim] = valor;
        tamanho++;
    }

    // Θ(1) — lê o valor da frente, avança inicio circularmente e diminui tamanho
    public int dequeue() {
        if (tamanho == 0)
            throw new RuntimeException("Fila vazia");
        int valor = dados[inicio];
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
}