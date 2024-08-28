import Grafos.GrafoPeso;
import Grafos.GrafoSimples;
import Grafos.IOGrafo;
import Grafos.enumVertice;
import Grafos.Representacao.ListaAdjacencia;

public class Main {
    public static void main(String[] args) {
        GrafoSimples gSimples = IOGrafo.lerGrafoSimples("entrada_com_peso.txt", enumVertice.MATRIZ);
        GrafoPeso gPeso = IOGrafo.lerGrafoPeso("entrada_com_peso.txt", enumVertice.MATRIZ);
        System.err.println("\nGSimples");
        gSimples.printArestas();
        gSimples.printArestas();
        System.err.println("\nGPeso");
        gPeso.printArestas();
        gPeso.printPesos();
    }
}
