package Tests;

import java.util.List;

import java.util.Random;

import Implemente.GrapheHHAdj;
import Implemente.GrapheLAdj;
import Implemente.GrapheLArcs;
import Implemente.GrapheMAdj;
import algos.Dijkstra;
import core.Arc;
import core.IGraphe;


public class PerformanceTest {
    public static void main(String[] args) {
        IGraphe grapheMAdj = new GrapheMAdj();
        IGraphe grapheLAdj = new GrapheLAdj();
        IGraphe grapheHHAdj = new GrapheHHAdj();
        IGraphe grapheLarcs = new GrapheLArcs();
        // Générer des graphes aléatoires
        generateRandomGraph(grapheMAdj, 100, 50);
        generateRandomGraph(grapheLAdj, 100, 5);
        generateRandomGraph(grapheHHAdj, 100, 50);
        generateRandomGraph(grapheLarcs, 100, 50);
        // Afficher les graphes générés
        System.out.println("GrapheMAdj:");
        displayGraph(grapheMAdj);
        System.out.println("GrapheLAdj:");
        displayGraph(grapheLAdj);
        System.out.println("GrapheHHAdj:");
        displayGraph(grapheHHAdj);
    }

    private static void generateRandomGraph(IGraphe graphe, int nbSommets, int nbArcs) {
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


    private static void displayGraph(IGraphe graphe) {
        for (String sommet : graphe.getSommets()) {
            System.out.print("Sommet " + sommet + " est connecté à : ");
            List<String> successeurs = graphe.getSucc(sommet);
            if (successeurs.isEmpty()) {
                System.out.print("aucun successeur");
            } else {
                for (String successeur : successeurs) {
                    int valuation = graphe.getValuation(sommet, successeur);
                    System.out.print(successeur + "(" + valuation + ") ");
                }
            }
            System.out.println();
        }
    }
}
