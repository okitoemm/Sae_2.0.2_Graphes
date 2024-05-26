package Tests;

import org.junit.jupiter.api.Test;

import Implemente.GrapheHHAdj;
import Implemente.GrapheLAdj;
import Implemente.GrapheLArcs;
import Implemente.GrapheMAdj;
import algos.Dijkstra;
import core.IGraphe;

import java.util.HashMap;
import java.util.Map;
import java.util.Random;

public class PerformanceTest2 {

    @Test
    public void testPerformance() {
        IGraphe grapheMAdj = new GrapheMAdj();
        IGraphe grapheLAdj = new GrapheLAdj();
        IGraphe grapheHHAdj = new GrapheHHAdj();
        IGraphe grapheLarcs = new GrapheLArcs();

        generateRandomGraph(grapheMAdj, 1000, 5000);
        generateRandomGraph(grapheLAdj, 1000, 5000);
        generateRandomGraph(grapheHHAdj,1000, 5000);
        generateRandomGraph(grapheLarcs,1000, 5000);

        measurePerformance(grapheMAdj, "GrapheMAdj");
        measurePerformance(grapheLAdj, "GrapheLAdj");
        measurePerformance(grapheHHAdj, "GrapheHHAdj");
        measurePerformance(grapheLarcs, "GrapheLArcs");
    }

    private void generateRandomGraph(IGraphe graphe, int nbSommets, int nbArcs) {
        Random random = new Random();
        for (int i = 0; i < nbSommets; i++) {
            graphe.ajouterSommet("S" + i);
        }
        for (int i = 0; i < nbArcs; i++) {
            String src = "S" + random.nextInt(nbSommets);
            String dest = "S" + random.nextInt(nbSommets);
            int valeur = random.nextInt(100) + 1;
            try {
                graphe.ajouterArc(src, dest, valeur);
            } catch (IllegalArgumentException e) {
                // Ignore duplicate arcs
            }
        }
    }

    private void measurePerformance(IGraphe graphe, String typeGraphe) {
        long startTime = System.currentTimeMillis();
        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Dijkstra.dijkstra(graphe, "S0", dist, prev);
        long endTime = System.currentTimeMillis();

        System.out.println(typeGraphe + " - Temps d'exécution: " + (endTime - startTime) + " ms");
    }
}
