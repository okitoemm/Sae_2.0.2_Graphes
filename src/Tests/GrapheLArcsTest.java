package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Implemente.GrapheLArcs;

class GrapheLArcsTest {


    @Test
    public void testAjouterSommet() {
        GrapheLArcs graphe = new GrapheLArcs();
        graphe.ajouterSommet("A");
        assertTrue(graphe.contientSommet("A"));
    }

    @Test
    public void testAjouterArc() {
        GrapheLArcs graphe = new GrapheLArcs();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertTrue(graphe.contientArc("A", "B"));
        assertEquals(10, graphe.getValuation("A", "B"));
    }

    @Test
    public void testGetSucc() {
        GrapheLArcs graphe = new GrapheLArcs();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertEquals(List.of("B"), graphe.getSucc("A"));
    }
}
