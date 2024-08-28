package Grafos.Representacao;

import java.util.ArrayList;
import java.util.HashMap;
import java.util.List;
import java.util.Map;

public class ListaPeso implements RepresentacaoPeso {
    private List<Map<Integer, Double>> lista;

    public ListaPeso(int numVertices) {
        lista = new ArrayList<>(numVertices);
        for (int i = 0; i < numVertices; i++) {
            lista.add(new HashMap<>());
        }
    }

    @Override
    public void adicionarPeso(int origem, int destino, double peso) {
        
        lista.get(origem).put(destino, peso);
        lista.get(destino).put(origem, peso);
    }

    @Override
    public void printRepresentacao() {

        System.out.println("Lista de Pesos:");

        for (int i = 0; i < lista.size(); i++) {
            System.out.print(i + ": ");

            Map<Integer, Double> mp = lista.get(i);

            for ( Map.Entry<Integer, Double> entry : mp.entrySet() ) {
                int key = entry.getKey();
                Double peso = entry.getValue(); //Não precisa converter pra double porque é só pra printar

                System.out.print("{" + key + ": " + peso + "}" + " ");
            }
            System.out.println();
        }
    }
}
