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
  // Como a classe mantém uma referência direta para o nó 'ultimo', a inserção no
  // final
  // também é imediata. Apenas ajustamos os ponteiros locais sem precisar
  // percorrer a lista.
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

  /**
   * Complexidade: Theta(1)
   * Independente do tamanho da lista (n), o método apenas manipula
   * referências diretas (ponteiros) do primeiro e do segundo elemento.
   */
  public int removerInicio() {
    if (primeiro == null) {
      throw new RuntimeException("Lista vazia");
    }

    int valor = primeiro.valor;

    // O novo "primeiro" será o sucessor do atual
    primeiro = primeiro.proximo;

    if (primeiro == null) {
      // Se a lista ficou vazia, o último também deve ser null
      ultimo = null;
    } else {
      // Removemos o vínculo com o nó antigo (ajuda o Garbage Collector)
      primeiro.anterior = null;
    }

    quantidade--;
    return valor;
  }

  /**
   * Complexidade: Theta(1)
   * Diferente da lista simples, aqui o nó 'ultimo' possui a referência
   * para o 'anterior'. Isso permite atualizar o ponteiro final instantaneamente,
   * sem precisar percorrer a lista com um laço (while).
   */
  public int removerFinal() {
    if (ultimo == null) {
      throw new RuntimeException("Lista vazia");
    }

    int valor = ultimo.valor;

    // O novo "ultimo" será o antecessor do atual
    ultimo = ultimo.anterior;

    if (ultimo == null) {
      // Se a lista possuía apenas um elemento, o primeiro agora é null
      primeiro = null;
    } else {
      // O novo último não pode ter um próximo
      ultimo.proximo = null;
    }

    quantidade--;
    return valor;
  }

  /**
   * Exercicio 9 - Implemente em Java um método imprimirReverso() na classe
   * ListaDuplamenteLigada
   * que imprime os elementos da lista do último para o primeiro, separados por "
   * <-> ",
   * terminando com "null".
   */
  public void imprimirReverso() {
    No atual = ultimo;

    while (atual != null) {
      System.out.print(atual.valor + " <-> ");
      atual = atual.anterior;
    }
    System.out.print("null");
  }

  public static void main(String[] args) {
    ListaDuplamenteLigada lista = new ListaDuplamenteLigada(); // lista vazia

    for (int v : new int[] { 10, 20, 30, 40 })
      lista.inserirNoFinal(v); // 10 - 20 - 30 - 40

    lista.imprimirReverso(); // Saida: 40 <-> 30 <-> 20 <-> 10 <-> null
  }
}