package Grafos.Representacao;

public class MatrizPeso implements RepresentacaoPeso {
    private double[][] matriz;

    public MatrizPeso(int numVertices) {
        matriz = new double[numVertices][numVertices];
    }

    @Override
    public void adicionarPeso(int origem, int destino, double peso) {
        matriz[origem][destino] = peso;
        matriz[destino][origem] = peso;
    }

    @Override
    public void printRepresentacao() {
        System.out.println("Matriz de Adjacência:");
        for (double[] linha : matriz) {
            for (double val : linha) {
                System.out.print( (Double.isNaN(val) ? "NaN" : val) + " ");
            }
            System.out.println();
        }
    }
}
