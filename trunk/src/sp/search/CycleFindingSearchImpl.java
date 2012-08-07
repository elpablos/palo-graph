/**
 * 
 */
package sp.search;

import java.util.*;

import sp.graph.*;
import sp.node.*;

/**
 * Algoritmuss slouzici k nalezeni Eulerovskeho tahu z zadanem grafu.
 * @author Pavel Lorenz
 */
public class CycleFindingSearchImpl implements Search {

	/**
	 * Reference na vystupni seznam uzlu.
	 */
	private List<Node> result = null;
	
	/**
	 * Pocatecni uzel.
	 */
	private Node startNode = null;
	
	/**
	 * Flag, zdali je graf eulerovsky.
	 */
	private boolean isEulerian;
	
	/* (non-Javadoc)
	 * @see sp.search.Search#search(sp.graph.Graph, sp.node.Node)
	 */
	@Override
	public void search(Graph graph, Node startNode) {
		// reference na pocatecni uzel
		this.startNode = startNode;
		// vytvorime vystupni frontu
		result = new LinkedList<Node>();
		
		findTour(graph, startNode);
		isEulerian = true;
		// vytvorime frontu
//		Stack<Node> stack = new Stack<Node>();
//		stack.push(startNode);
//
//        isEulerian = true;
//		// find Eulerian tour
//        while (!stack.isEmpty()) {
//            Node node = stack.pop();
//            result.add(node);
//            
//            Node temp = node;
//            
//			for (Edge edg : graph.getEdges(node)) {
//				stack.push(edg.getEndNode());
//				graph.remodeEdge(edg);
//				System.out.println(edg.getStartNode().getName() + "->" + edg.getEndNode().getName());
//			}
//            if (temp != node) isEulerian = false;
//        }
        
        if (graph.isEdgeExist()) {
        	System.out.println("Existuje jeste cesta!");
        	isEulerian = false;
        	result = null;
        }
	}

	/**
	 * Rekurzivni funkce prohledavajici graf a odstranujici hrany.
	 * @param graph graf
	 * @param startNode pocatecni uzel
	 */
	private void findTour(Graph graph, Node startNode) {

		for (Edge edge : graph.getEdges(startNode)) {
			graph.remodeEdge(edge);
			findTour(graph, edge.getEndNode());
		}
		result.add(startNode);
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
		
		sb.append("Eul(").append(startNode.getName()).append("): ");
		if (isEulerian) {
			for (int i = 0; i < result.size(); i++) {
				sb.append(result.get(i).getName());
				if (result.size() > 0 && i != result.size()-1) {
					sb.append(", ");
				}
			}
		} else {
			sb.append("Graph is not eulerian");
		}
		return sb.toString();
	}
}
