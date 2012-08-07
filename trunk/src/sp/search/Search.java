/**
 * 
 */
package sp.search;

import java.util.*;

import sp.graph.Graph;
import sp.node.Node;

/**
 * Rozhrani pro vyhledavani algoritmy.
 * @author Pavel Lorenz
 */
public interface Search {
	
	/**
	 * Kolekce nalezenych uzlu.
	 * @return nalezene uzly
	 */
	Collection<Node> getResult();

	/**
	 * Pocatecni uzel.
 	 * @return uzel
	 */
	Node getStartNode();
	
	/**
	 * Prohledavani v grafu.
	 * @param graph graf
	 * @param startNode pocatecni uzel
	 */
	void search(Graph graph, Node startNode);
}
