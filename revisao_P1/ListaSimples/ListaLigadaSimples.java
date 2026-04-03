package ListaSimples;

public class ListaLigadaSimples {

  private No primeiro, ultimo;
  private int quantidade; // n = quantidade

  // Theta(1)
  public ListaLigadaSimples(){
    primeiro = null;
    ultimo = null;
    quantidade = 0;
  }

  // Theta(1)
  // Independente do tamanho da lista, apenas alocamos um nó e reatribuímos ponteiros.
  //[1][3][4], insereNoInicio(6)
  public void inserirNoInicio(int valor){
    var novo = new No(valor); // novo.valor = 6, novo.proximo = null
    novo.proximo = primeiro; // lista atualizada: [6][1][3][4]
    primeiro = novo; // primeiro = [6]
    if(ultimo == null) // se o novo nó é o unico da lista
      ultimo = novo;
    quantidade++;
  }

  // Theta(1)
  // Como a classe mantém uma referência direta para o nó 'ultimo', não é necessário percorrer a lista.
  public void inserirNoFinal(int valor){
    var novo = new No(valor);
    if(ultimo == null){
      primeiro = novo;
      ultimo = novo;
    }
    else{
      ultimo.proximo = novo;
      ultimo = novo;
    }
    quantidade++;
  }

  // n = quantidade
  // Omega(1) = caso de menor complexidade (acessar o índice 0)
  // O(n) = caso de maior complexidade (acessar o último índice, n-1, pois precisa percorrer todos os nós anteriores)
  public int acessar(int indice){
    if(indice < 0 || indice >= quantidade)
      throw new ArrayIndexOutOfBoundsException();
    No atual = primeiro;
    for(int i = 0; i < indice; i++)
      atual = atual.proximo;
    return atual.valor;
  }

  // n = quantidade
  // Omega(1) = caso de menor complexidade (o valor buscado logo no primeiro nó)
  // O(n) = caso de maior complexidade (se o valor não existe na lista ou está apenas no último nó, percorremos todas as posições da lista)
  public boolean buscar(int valor){
    No atual = primeiro;
    while (atual != null){
      if(atual.valor == valor) return true;
      atual = atual.proximo;  
    }
    return false;
  }

  // Theta(1)
  // Apenas avança o ponteiro 'primeiro' para o próximo nó e decrementa a quantidade, sem laços de repetição.
  public int removerDoInicio(){
    if(primeiro == null)
      throw new RuntimeException("Lista vazia");
    int valor = primeiro.valor;
    primeiro = primeiro.proximo; // primeiro nó é sobrescrito pelo segundo nó
    if(primeiro == null)
      ultimo = null;
    quantidade--;
    return valor;
  }

  // n = quantidade
  // Omega(1) = caso de menor complexidade (a lista possui apenas 1 elemento, logo primeiro == ultimo e não há laço)
  // O(n) = caso de maior complexidade (a lista tem mais de um elementos e o 'while' precisa percorrer até encontrar o penúltimo nó)
  public int removerDoFinal(){
    if(primeiro == null)
      throw new RuntimeException("Lista vazia");
    int valor;
    if(primeiro == ultimo){
      valor = primeiro.valor;
      primeiro = null;
      ultimo = null;
    }
    else{ // tenho pelo menos dois nós na lista
      No atual = primeiro;
      while(atual.proximo != ultimo){ // complexidade = n
        atual = atual.proximo;
      } // atual = penultimo nó
      valor = ultimo.valor;
      atual.proximo = null; // proximo do penultimo recebe um valor nulo
      ultimo = atual;
    }
    quantidade--;
    return valor;
  }
}