import java.util.*;

public class AlcancaveisBFS{
    // Lista de adjacencias: vizinhos[u] = lista de vizinhos de u
    private final List<List<Integer>> vizinhos;
    private final int n;

    public AlcancaveisBFS(int n){
        this.n = n;
        // lista de "fora" = n posicoes, uma para cada vertice
        this.vizinhos = new ArrayList<>(n);
        for(int i = 0; i < n; i++){
            vizinhos.add(new ArrayList<>());
        }
    }

    public void adicionarAresta(int u, int v){
        vizinhos.get(u).add(v);  // v é vizinho de u
        vizinhos.get(v).add(u);  // u é vizinho de v
    }

    // Conta quantos vertices sao alcancaveis a partir da origem (s)
    // 0 = Branco/Não Descorberto, 1 - Cinza/Descoberto, 2 - Preto/Processado
    public int contarAlcancaveis(int s){
        int[] cor = new int[n];
        for(int u = 0; u < n; u++){
            cor[u] = 0;
        }
        cor[s] = 1;

        Queue<Integer> fila = new LinkedList<>();
        fila.add(s);

        int contador = 0; // numero de vertices que podemos visitar a partir da origem

        while(!fila.isEmpty()){
            int u = fila.poll();
            for(int v : vizinhos.get(u)){
                if(cor[v] == 0){ // se vizinho ainda não foi descoberto (cor = branco)
                    cor[v] = 1; // vizinho é descoberto (cor = cinza)
                    fila.add(v);
                }
            }
            cor[u] = 2; // vértice u foi processado (todos os vizinhos foram descobertos, cor = preto)
            contador++; // mais um vértice que podemos visitar a partir da origem s
        }
        return contador;
    }

    public static void main(String[] args){
        // Grafo de exemplo: n = 5, passo 6 pois queremos começar de 1 para ficar igual na apostila
        AlcancaveisBFS g = new AlcancaveisBFS(6);
        g.adicionarAresta(1,2);
        g.adicionarAresta(1,4);
        g.adicionarAresta(2,3);
        g.adicionarAresta(2,5);
        g.adicionarAresta(4,5);

        int s = 1;
        int qtd = g.contarAlcancaveis(s);
        System.out.println("Vertices alcancaveis a partir de " + s + " = " + qtd);
    }
}