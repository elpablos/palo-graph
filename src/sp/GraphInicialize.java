package sp;

import java.util.*;

import sp.graph.*;
import sp.node.*;

/**
 * Trida, ktera inicializuje graf dle vstupnich dat.
 * @author Pavel Lorenz
 */
public class GraphInicialize {
	
	/**
	 * Kolekce uzlu.
	 */
	private Collection<Node> nodes = null;
	
	/**
	 * Reference na startovni uzel.
	 */
	private Node startNode = null;
	
	/**
	 * Naplneni grafu dle vstupniho textu.
	 * @param graph graf
	 * @param inputText vstupni text
	 */
	public void inicialize(Graph graph, String inputText) {
		// inicializace uzlu
		nodes = new ArrayList<Node>();
		
		// parsovani textu
		InputStringParser parser = new InputStringParser();
		parser.parse(inputText);
		
		// naplneni daty
		for (String nodeName : parser.getResult()) {
			nodes.add(new NodeImpl(nodeName));
		}
		// vytvorime hrany grafu
		for (NodeRelation relation : parser.getRelation()) {
			graph.setEdge(getNodeByName(relation.getSource()), 
					getNodeByName(relation.getDestionation()));
			
		}
		// ulozime si referenci na pocatecni uzel
		startNode = getNodeByName(parser.getStartNode());
	}
	
	/**
	 * Pomocna metoda, ktera projede kolekci uzlu a vytahne nam 
	 * uzel dle zadaneho jmena.
	 * @param name jmeno uzlu
	 * @return uzel
	 */
	private Node getNodeByName(String name) {
		Node ret = null;
		for (Node node : nodes) {
			if (name.equals(node.getName())) {
				ret = node;
			}
		}
		return ret;
	}

	/**
	 * Getter vracejici startovni uzel.
	 * @return uzel
	 */
	public Node getStartNode() {
		return startNode;
	}
}
