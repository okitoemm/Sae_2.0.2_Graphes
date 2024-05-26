package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Implemente.GrapheLAdj;


public class GrapheLAdjTest {

    @Test
    public void testAjouterSommet() {
        GrapheLAdj graphe = new GrapheLAdj();
        graphe.ajouterSommet("A");
        assertTrue(graphe.contientSommet("A"));
    }

    @Test
    public void testAjouterArc() {
        GrapheLAdj graphe = new GrapheLAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertTrue(graphe.contientArc("A", "B"));
        assertEquals(10, graphe.getValuation("A", "B"));
    }

    @Test
    public void testGetSucc() {
        GrapheLAdj graphe = new GrapheLAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertEquals(List.of("B"), graphe.getSucc("A"));
    }
}
