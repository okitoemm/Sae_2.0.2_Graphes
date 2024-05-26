package Tests;

import static org.junit.jupiter.api.Assertions.*;

import java.util.List;

import org.junit.jupiter.api.Test;

import Implemente.GrapheHHAdj;

import static org.junit.jupiter.api.Assertions.*;


public class GrapheHHAdjTest {

    @Test
    public void testAjouterSommet() {
        GrapheHHAdj graphe = new GrapheHHAdj();
        graphe.ajouterSommet("A");
        assertTrue(graphe.contientSommet("A"));
    }

    @Test
    public void testAjouterArc() {
        GrapheHHAdj graphe = new GrapheHHAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertTrue(graphe.contientArc("A", "B"));
        assertEquals(10, graphe.getValuation("A", "B"));
    }

    @Test
    public void testGetSucc() {
        GrapheHHAdj graphe = new GrapheHHAdj();
        graphe.ajouterSommet("A");
        graphe.ajouterSommet("B");
        graphe.ajouterArc("A", "B", 10);
        assertEquals(List.of("B"), graphe.getSucc("A"));
    }
}
