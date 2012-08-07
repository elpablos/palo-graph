/**
 * 
 */
package sp.search;

import java.util.*;

import sp.graph.*;
import sp.node.*;

/**
 * Implementace algoritmu prohledavani do hloubky.
 * @author Pavel Lorenz
 */
public class DepthFirstSearchImpl implements Search {

	/**
	 * Reference na vystupni seznam uzlu.
	 */
	private List<Node> result = null;
	
	/**
	 * Pocatecni uzel.
	 */
	private Node startNode = null;
	
	/* (non-Javadoc)
	 * @see sp.search.Search#search(sp.graph.Graph, sp.node.Node)
	 */
	@Override
	public void search(Graph graph, Node startNode) {
		// reference na pocatecni uzel
		this.startNode = startNode;
		// vytvorime vystupni seznam (cerne uzly)
		result = new ArrayList<Node>();

		// obarvime uzel sede
		startNode.setColor(Color.Gray);
		// zkontrolujeme vsechny potomky
		for (Node child : graph.getNeighbors(startNode)) {
			// pokud je uzel bily, tak jej obarvime sede
			if (Color.White.equals(child.getColor()))
			{
				// obarveni sedou
				child.setColor(Color.Gray);
				// projdeme uzel
				dfsSearch(graph, child);
			}
		}
		// obarvime uzel cerne
		startNode.setColor(Color.Black);
		// pridame uzel do vystupni kolekce
		result.add(0,startNode);
	}
	
	/**
	 * Pomocna rekurzivni metoda pro prochazeni grafu.
	 * @param graph graf
	 * @param node uzel
	 */
	private void dfsSearch(Graph graph,Node node) {
		// obarvime uzel sede
		node.setColor(Color.Gray);
		for (Node child : graph.getNeighbors(node)) {
			// pokud je uzel bily, tak jej obarvime sede
			if (Color.White.equals(child.getColor()))
			{
				// projdeme uzel
				dfsSearch(graph, child);
			}
		}
		// obarvime uzel cerne
		node.setColor(Color.Black);
		// pridame uzel do vystupni kolekce
		result.add(0,node);
	}
	
	/* (non-Javadoc)
	 * @see sp.search.Search#getResult()
	 */
	public Collection<Node> getResult() {
		return result;
	}

	/* (non-Javadoc)
	 * @see sp.search.Search#getStartNode()
	 */
	public Node getStartNode() {
		return startNode;
	}

	/* (non-Javadoc)
	 * @see java.lang.Object#toString()
	 */
	@Override
	public String toString() {
		StringBuilder sb = new StringBuilder();
		
		sb.append("DFS(").append(startNode.getName()).append("): ");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i).getName());
			if (result.size() > 0 && i != result.size()-1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
