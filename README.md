# Sae_2.0.2_Graphes
____________________________________________________________________________________________________________________________________________________________________________________________
# Groupe 105 : OKITO Emmanuel -- FAIZA -- MAHERITIANA -- ALINE
____________________________________________________________________________________________________________________________________________________________________________________________
# Projet Graphes et Algorithme de Dijkstra
____________________________________________________________________________________________________________________________________________________________________________________________
Ce projet implémente différentes représentations de graphes orientés valués et l'algorithme de Dijkstra pour calculer le plus court chemin dans un graphe. Les représentations de graphes implémentées sont : liste d'arcs, matrice d'adjacence, liste d'adjacence et table de hachage. L'implémentation respecte l'interface IGraphe pour les graphes modifiables et IGrapheConst pour les graphes non modifiables utilisés par l'algorithme de Dijkstra.
____________________________________________________________________________________________________________________________________________________________________________________________
# Partie I : Représentation des graphes orientés valués

Les différentes représentations de graphes sont implémentées dans des classes dédiées qui respectent l'interface IGraphe. Les nœuds sont identifiés par une chaîne de caractères et un graphe ne contient pas de valuation négative. Toutes les classes de graphes ont un constructeur avec une chaîne de la forme "A-B(5), A-C(10), B-C(3), C-D(8), E:" qui décrit un graphe avec les sommets A,B,C,D,E et les arcs A vers B de valuation 5, A vers C de valuation 10 etc. Notez que E n’a pas d’arcs sortants.

____________________________________________________________________________________________________________________________________________________________________________________________
Les différentes classes de graphes implémentées sont :

GrapheLArcs : représente un graphe à l'aide d'une liste d'arcs.
GrapheMAdj : représente un graphe à l'aide d'une matrice d'adjacence.
GrapheLAdj : représente un graphe par des listes d'adjacence.
GrapheHHAdj : représente un graphe par des tables de hachage imbriquées.
