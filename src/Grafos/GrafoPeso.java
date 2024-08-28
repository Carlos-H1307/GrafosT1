package Grafos;

import Grafos.Representacao.RepresentacaoGrafo;
import Grafos.Representacao.RepresentacaoPeso;

public class GrafoPeso extends Grafo{
   RepresentacaoPeso representacaoPeso;

    public GrafoPeso(RepresentacaoGrafo representacaoGrafo, RepresentacaoPeso representacaoPeso){
        super(representacaoGrafo);
        this.representacaoPeso = representacaoPeso;
    }

    public void printPesos() {
        this.representacaoPeso.printRepresentacao();
    }
}
