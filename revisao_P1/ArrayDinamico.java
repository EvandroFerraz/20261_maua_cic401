public class ArrayDinamico {
    private int[] dados;
    private int quantidade; // numero de posições ocupadas

    // Theta(1)
    public ArrayDinamico(int capacidade){
        dados = new int[capacidade];
        quantidade = 0;
    }

    // Theta(1)
    public int acessar(int i){
        if(i < 0 || i >= quantidade) throw new IndexOutOfBoundsException();
        return dados[i];
    }

    // Theta(n)
    // n = quantidade
    private void redimensionar(int novaCapacidade){
        int[] novo = new int[novaCapacidade];
        for(int i=0; i < quantidade; i++){
            novo[i] = dados[i];
        }
        dados = novo;
    }

    // Theta(1)
    public int getQuantidade(){
        return quantidade;
    }

    // Omega(1) se possui espaço disponível, Omega = caso de menor complexidade
    // O(n) se precisar redimensionar, O = caso de maior complexidade
    public void inserirNoFinal(int valor){
        if(quantidade == dados.length) redimensionar(2 * dados.length);
        dados[quantidade] = valor;
        quantidade++;
    }

    // Omega(n) se não redimensionar (apenas deslocar), Omega = caso de menor complexidade
    // O(2 * n) = O(n) se redimensionar e deslocar, O = caso de maior complexidade
    public void inserirNoInicio(int valor){
        if(quantidade == dados.length) redimensionar(2 * dados.length); // n instruções
        for(int i = quantidade; i > 0; i--){ // + n instruções
            dados[i] = dados[i-1];
        }
        dados[0] = valor;
        quantidade++;
    }

    // Omega(1) = caso de menor complexidade (o valor buscado está na primeira posição)
    // O(n) = caso de maior complexidade (o valor buscado não está no vetor)
    public int buscar(int valor){
        for(int i = 0; i < quantidade; i++){
            if(dados[i] == valor) return i;
        }
        return -1;
    }

    // Sobrescrita da representação textual do objeto
    // Theta(n)
    public String toString() {
        if (quantidade == 0) {
            return "[]";
        }

        String s = "[";
        for (int i = 0; i < quantidade; i++) {
            s += dados[i];
            
            // Adiciona a vírgula e o espaço, exceto para o último elemento
            if (i < quantidade - 1) {
                s += ", ";
            }
        }
        s += "]"; // Fecha os colchetes pra ficar bonito
        
        return s;
    }

    // Exercício 6
    public void removerNaPosicao(int i){
        // Verifica se o índice é válido
        if(i < 0 || i >= quantidade) throw new IndexOutOfBoundsException("Indice fora dos limites.");

        // Deslocar os elementos para a esquerda a partir do índice removido
        for(int j = i; j < quantidade - 1; j++){
            dados[j] = dados[j+1];
        }
        // Decrementa a quantidade de elementos
        quantidade--;
    }
    
    // Exercício 6
    // n = quantidade
    // Omega(n) = caso de menor complexidade, percorre todo o vetor sem remover nenhuma vez
    // O(n^2) = caso de maior complexidade, chama removerNaPosicao(i), que tem complexidade O(n), para todas as n posições.
    public void removerTodos(int v){
        for(int i = 0; i < quantidade; i++){ //n
            if(dados[i] == v){
                removerNaPosicao(i); // n
                i--;
            }
        }
    }

    public static void main(String[] args){
        // cria o objeto do array dinamico
        ArrayDinamico arr = new ArrayDinamico(10);

        // preenche o array
        for(int v : new int[] {3, 7, 3, 3, 5, 3, 8})
            arr.inserirNoFinal(v);

        // testa o método removerTodos()
        System.out.println("Antes: " + arr);
        arr.removerTodos(3);
        System.out.println("Depois: " + arr); // Depois: [7, 5, 8]
    }
}
