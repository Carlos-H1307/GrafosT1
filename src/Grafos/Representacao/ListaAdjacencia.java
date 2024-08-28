package Grafos.Representacao;

import java.util.ArrayList;
import java.util.List;

public class ListaAdjacencia implements RepresentacaoGrafo {
    private List<List<Integer>> lista;

    public ListaAdjacencia(int numVertices) {
        lista = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            lista.add(new ArrayList<>());
        }
    }

    @Override
    public void adicionarAresta(int origem, int destino) {
        lista.get(origem).add(destino);
        lista.get(destino).add(origem);
    }

    @Override
    public void printRepresentacao() {
        System.out.println("Lista de Adjacência:");
        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + ": ");
            for (int adj : lista.get(i)) {
                System.out.print(adj + " ");
            }
            System.out.println();
        }
    }
}
