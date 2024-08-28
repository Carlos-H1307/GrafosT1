package Grafos;
import java.io.BufferedReader;
import java.io.FileReader;
import java.io.IOException;

import Grafos.Representacao.*;

/**
 * Esta classe é destinada exclusivamente para realizar leituras
 * e escritas de grafos com ou sem pesos.
 * A numeração dos vértices no arquivo precisa ser > 0.
 */
public class IOGrafo {

    /**
     * Grafo Simples
     * @param nomeArquivo
     * @return GrafoSimples | null
     */
    public static GrafoSimples lerGrafoSimples( String nomeArquivo, enumVertice tipo ){

        RepresentacaoGrafo repGrafo = null;

        try{

            BufferedReader reader = new BufferedReader( new FileReader(nomeArquivo) );

            //Pega numero de vértices
            int numVertices = Integer.parseInt( reader.readLine().trim() );

            if(tipo == enumVertice.LISTA){
                repGrafo = new ListaAdjacencia(numVertices);
            }else{
                repGrafo = new MatrizAdjacencia(numVertices);
            }
            

            //Inicializa as matrizes
            // for (int i = 0; i < numVertices; i++) {
            //     for (int j = 0; j < numVertices; j++) {
            //         matVertices[i][j] = false;
            //     }
            // }

            String linha;
            while( (linha = reader.readLine()) != null ){
                String[] colunas = linha.trim().split("\\s+");

                int origem = Integer.parseInt(colunas[0]) - 1;//indice baseado em 0
                int destino = Integer.parseInt(colunas[1]) - 1;//indice baseado em 0

                //Arestas
                repGrafo.adicionarAresta(origem, destino);
            }
            
            reader.close();
        } catch (Exception e) {
            System.out.println(e);
        }

        if(repGrafo == null) return null;

        return new GrafoSimples(repGrafo);
    }


    /**
     * GrafoPeso
     * @param nomeArquivo
     * @return GrafoPeso | null
     */
    public static GrafoPeso lerGrafoPeso( String nomeArquivo, enumVertice tipo ){
        
        RepresentacaoGrafo repGrafo = null;
        RepresentacaoPeso repPeso = null;

        try{

            BufferedReader reader = new BufferedReader( new FileReader(nomeArquivo) );

            //Pega numero de vértices
            int numVertices = Integer.parseInt( reader.readLine().trim() );

            if(tipo == enumVertice.LISTA){
                repGrafo = new ListaAdjacencia(numVertices);
                repPeso = new ListaPeso(numVertices);
            }else{
                repGrafo = new MatrizAdjacencia(numVertices);
                repPeso = new MatrizPeso(numVertices);
            }

            //Inicializa as matrizes
            // for (int i = 0; i < numVertices; i++) {
            //     for (int j = 0; j < numVertices; j++) {
            //         matVertices[i][j] = false;
            //         matPesos[i][j] = Double.NaN;
            //     }
            // }

            String linha;
            while( (linha = reader.readLine()) != null ){
                String[] colunas = linha.trim().split("\\s+");

                int origem = Integer.parseInt(colunas[0]) - 1;//indice baseado em 0
                int destino = Integer.parseInt(colunas[1]) - 1;//indice baseado em 0

                //Arestas
                repGrafo.adicionarAresta(origem, destino);

                //Pesos
                double peso = Double.parseDouble(colunas[2]);
                repPeso.adicionarPeso(origem, destino, peso);
            }

            reader.close();

        }catch(Exception e){
            System.out.println(e);
        }

        if(repGrafo == null) return null;

        return new GrafoPeso(repGrafo, repPeso);        
    }


    //debug
    public static void printMatriz(boolean[][] matriz) {
        for (boolean[] linha : matriz) {
            for (boolean val : linha) {
                System.out.print((val ? 1 : 0) + " ");
            }
            System.out.println();
        }
    }
}
