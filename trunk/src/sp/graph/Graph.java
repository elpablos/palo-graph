/**
 * 
 */
package sp.graph;

import java.util.*;

import sp.node.*;

/**
 * Rozhrani pro reprezentaci grafu.
 * @author Pavel Lorenz
 */
public interface Graph {

	/**
	 * Vrati vsechny sousedy uzlu.
	 * @param node uzel
	 * @return kolekce sousedu
	 */
	Collection<Node> getNeighbors(Node node);

	/**
	 * Zakladani orientovanych hran.
	 * @param sourceNode pocatecni uzel
	 * @param destinationNode cilovy uzel
	 */
	void setEdge(Node sourceNode, Node destinationNode);
	
	/**
	 * Vraci vsechny hrany vedouci z uzlu.
	 * @param node uzel
	 * @return kolekce hran
	 */
	Collection<Edge> getEdges(Node node);
	
	/**
	 * Odstraneni hrany.
	 * @param edge hrana
	 */
	void remodeEdge(Edge edge);
	
	/**
	 * Existuje aspon jedna hrana?
	 * @return true, pokud ano.
	 */
	boolean isEdgeExist();
}
