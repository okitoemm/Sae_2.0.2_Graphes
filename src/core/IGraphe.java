package core;

public interface IGraphe extends IGrapheConst  {
	
	
	void ajouterSommet(String noeud);
	void ajouterArc(String source, String destination, Integer valeur);
	void oterSommet(String noeud);
	void oterArc(String source, String destination);
	
	// construit un graphe vide a partir d'une chaine
	// au format "A-B(5), A-C(10), B-C(3), C-D(8), E:";
	default void peupler(String str) {
	    assert this.getSommets().isEmpty();
	    String[] arcs = str.split(",\\s*");
	    for (String arc : arcs) {
	        String[] elements = arc.trim().split("-");
	        // extrait le noeud source et ote ":" si nécessaire dans le nom
	        String src = elements[0].replaceAll(":", "");
	        ajouterSommet(src);
	        if (elements.length == 1)
	        	continue; // pas de destination
	        String target = elements[1];
	        if (!target.isEmpty()) {
	             String dest = target.substring(0, target.indexOf('('));
	             int val = Integer.parseInt(target
	                	.substring(target.indexOf('(') + 1,
	                				   target.indexOf(')')));
	             ajouterSommet(dest);
	             ajouterArc(src, dest, val);
	        }
	    }
	}

}
