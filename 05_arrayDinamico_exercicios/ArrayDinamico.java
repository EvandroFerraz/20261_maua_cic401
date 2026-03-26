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

    // O(1) se possui espaço disponível
    // O(n) se precisar redimensionar
    public void inserirNoFinal(int valor){
        if(quantidade == dados.length) redimensionar(2 * dados.length);
        dados[quantidade] = valor;
        quantidade++;
    }

    // O(n)
    // Se redimensionar = 2 * n, ainda Theta(n)
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
}
