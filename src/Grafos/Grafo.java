package Grafos;

import java.util.List;
import Grafos.Representacao.RepresentacaoGrafo;

abstract class Grafo {
    protected RepresentacaoGrafo representacao;
    

    public Grafo(RepresentacaoGrafo representacao) {
        this.representacao = representacao;

    }

    public void adicionarAresta(int origem, int destino) {
        representacao.adicionarAresta(origem, destino);
    }

    public void printArestas(){
        representacao.printRepresentacao();
    }
}
