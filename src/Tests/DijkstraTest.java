package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.HashMap;
import java.util.List;
import java.util.Map;

import org.junit.jupiter.api.Test;

import Implemente.GrapheLAdj;
import algos.Dijkstra;
import core.IGraphe;
class DijkstraTest {


    @Test
    public void testDijkstra() {
        IGraphe graphe = new GrapheLAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterSommet("C");
        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("B", "C", 2);
        graphe.ajouterArc("A", "C", 4);

        Map<String, Integer> dist = new HashMap<>();
        Map<String, String> prev = new HashMap<>();
        Dijkstra.dijkstra(graphe, "A", dist, prev);

        assertEquals(0, (int) dist.get("A"));
        assertEquals(1, (int) dist.get("B"));
        assertEquals(3, (int) dist.get("C"));
    }

    @Test
    public void testPlusCourtChemin() {
        IGraphe graphe = new GrapheLAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterSommet("C");
        graphe.ajouterArc("A", "B", 1);
        graphe.ajouterArc("B", "C", 2);
        graphe.ajouterArc("A", "C", 4);

        List<String> chemin = Dijkstra.plusCourtChemin(graphe, "A", "C");

        assertEquals(List.of("A", "B", "C"), chemin);
    }
}
