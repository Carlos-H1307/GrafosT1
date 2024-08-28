package Grafos.Representacao;

public class MatrizAdjacencia implements RepresentacaoGrafo {
    private boolean[][] matriz;

    public MatrizAdjacencia(int numVertices) {
        matriz = new boolean[numVertices][numVertices];
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        matriz[origem][destino] = true;
        matriz[destino][origem] = true;
    }

    @Override
    public void printRepresentacao() {
        System.out.println("Matriz de Adjacência:");
        for (boolean[] linha : matriz) {
            for (boolean val : linha) {
                System.out.print((val ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
