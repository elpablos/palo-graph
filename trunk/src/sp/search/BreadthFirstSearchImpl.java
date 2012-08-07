/**
 * 
 */
package sp.search;

import java.util.*;

import sp.graph.*;
import sp.node.*;

/**
 * Implementace algoritmu prohledavani do sirky.
 * @author Pavel Lorenz
 */
public class BreadthFirstSearchImpl implements Search {

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
		// vytvorime vystupni frontu (cerne uzly)
		result = new LinkedList<Node>();
		// vytvorime frontu
		Queue<Node> queue = new LinkedList<Node>();
		// obarvime uzel sede
		startNode.setColor(Color.Gray);
		// naplnime ji startovnim uzlem
		queue.add(startNode);
		// dokud neni fronta prazdna, tak opakujeme cyklus
		while (!queue.isEmpty()) {
			// vytazeni uzlu ke zpracovani
			Node node = queue.poll();
			// zkontrolujeme vsechny potomky
			for (Node child : graph.getNeighbors(node)) {
				// pokud je uzel bily, tak jej obarvime sede a vlozime do fronty
				if (Color.White.equals(child.getColor()))
				{
					// obarveni sedou
					child.setColor(Color.Gray);
					// pridani do fronty
					queue.add(child);
				}
			}
			// uzel obarvime cerne a pridame ho do vystupni fronty
			node.setColor(Color.Black);
			result.add(node);
		}
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
		
		sb.append("BFS(").append(startNode.getName()).append("): ");
		for (int i = 0; i < result.size(); i++) {
			sb.append(result.get(i).getName());
			if (result.size() > 0 && i != result.size()-1) {
				sb.append(", ");
			}
		}
		return sb.toString();
	}
}
