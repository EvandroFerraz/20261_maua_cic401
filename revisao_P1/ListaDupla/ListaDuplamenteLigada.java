package ListaDupla;

public class ListaDuplamenteLigada {

  private No primeiro, ultimo;
  private int quantidade; // n = quantidade

  // Theta(1)
  public ListaDuplamenteLigada() {
    primeiro = ultimo = null;
    quantidade = 0;
  }

  // Theta(1)
  // A inserção ocorre sempre em tempo constante, pois apenas alocamos um novo nó 
  // e ajustamos os ponteiros diretamente, independente do tamanho da lista.
  public void inserirNoInicio(int valor) {
    var novo = new No(valor);
    novo.proximo = primeiro;
    if (primeiro != null)
      primeiro.anterior = novo;
    else
      ultimo = novo;
    primeiro = novo;
    quantidade = quantidade + 1;
  }

  // Theta(1)
  // Como a classe mantém uma referência direta para o nó 'ultimo', a inserção no final 
  // também é imediata. Apenas ajustamos os ponteiros locais sem precisar percorrer a lista.
  public void inserirNoFinal(int valor) {
    var novo = new No(valor);
    novo.anterior = ultimo;
    if (ultimo != null) {
      ultimo.proximo = novo;
    } else {
      primeiro = novo;
    }
    ultimo = novo;
    quantidade++;
  }
}