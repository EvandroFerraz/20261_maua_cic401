public class ArrayDinamico {
    private int[] dados;
    private int quantidade; // numero de posições ocupadas

    // O(1)
    public ArrayDinamico(int capacidade){
        dados = new int[capacidade];
        quantidade = 0;
    }

    // O(1)
    public int acessar(int i){
        if(i < 0 || i >= quantidade) throw new IndexOutOfBoundsException();
        return dados[i];
    }

    // O(n)
    // n = quantidade
    private void redimensionar(int novaCapacidade){
        int[] novo = new int[novaCapacidade];
        for(int i=0; i < quantidade; i++){
            novo[i] = dados[i];
        }
        dados = novo;
    }

    // O(1)
    public int getQuantidade(){
        return quantidade;
    }

    // Omega(1) se possui espaço disponível
    // O(n) se precisar redimensionar
    public void inserirNoFinal(int valor){
        if(quantidade == dados.length) redimensionar(2 * dados.length);
        dados[quantidade] = valor;
        quantidade++;
    }

    // Omega(n)
    // Se redimensionar = 2 * n, ainda O(n)
    public void inserirNoInicio(int valor){
        if(quantidade == dados.length) redimensionar(2 * dados.length);
        for(int i = quantidade; i > 0; i--){
            dados[i] = dados[i-1];
        }
        dados[0] = valor;
        quantidade++;
    }

    // O(n)
    public int buscar(int valor){
        for(int i = 0; i < quantidade; i++){
            if(dados[i] == valor) return i;
        }
        return -1;
    }

    // Sobrescrita da representação textual do objeto
    // O(n)
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

    public void removerNaPosicao(int i){
        // Verifica se o índice é válido
        if(i < 0 || i >= quantidade) throw new IndexOutOfBoundsException("Indice fora dos limites.");

        // Deslocar os elementos para a esquerda a partir do índice removido
        // [3,6,7,_]
        for(int j = i; j < quantidade - 1; j++){
            dados[j] = dados[j+1];
        }
        // Decrementa a quantidade de elementos
        quantidade--;
    }
    // n = quantidade
    // Theta(n)
    public void removerTodos(int v){
        for(int i = 0; i < quantidade; i++){
            if(dados[i] == v){
                removerNaPosicao(i);
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
