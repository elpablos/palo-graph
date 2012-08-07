/**
 * 
 */
package sp.graph;

import java.util.*;

import sp.node.*;

/**
 * Implementace reprezentace grafu pomoci matice sousednosti.
 * @author Pavel Lorenz
 */
public class MatrixGraphImpl implements Graph {
	
	/**
	 * Maximalni velikost matice.
	 */
	private static final int MAX_LENGTH = 50;
	
	/**
	 * Seznam vsech uzlu.
	 */
	private List<Node> list = new ArrayList<Node>();

	/**
	 * Matice sousednosti.
	 */
	private boolean[][] matrix = new boolean[MAX_LENGTH][MAX_LENGTH]; 
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#getChildren(sp.node.Node)
	 */
	@Override
	public Collection<Node> getNeighbors(Node node) {
		// inicializujeme kolekci
		Collection<Node> ret = new HashSet<Node>();
		
		// ziskame pozici uzlu
		int pos = list.indexOf(node);
		
		// pokud uzel neexistuje, tak konec
		if (pos == -1) return ret;
		
		// projedeme vsechny sousedy uzlu
		for (int i = 0; i < matrix[pos].length; i++) {
			// pokud je soused
			if (matrix[pos][i])
			{
				// tak ho pridame do kolekce
				ret.add(list.get(i));
			}
		}
		// vratime kolekci
		return ret;
	}

	/* (non-Javadoc)
	 * @see sp.graph.Graph#setEdge(sp.node.Node, sp.node.Node)
	 */
	@Override
	public void setEdge(Node sourceNode, Node destinationNode) {
		// zjistime pozice uzlu
		int sourcePos = getNodeNumber(sourceNode);
		int destPos = getNodeNumber(destinationNode);
		
		// nastavime spoj na true
		matrix[sourcePos][destPos] = true;
	}
	
	/*
	 * (non-Javadoc)
	 * 
	 * @see sp.graph.Graph#getEdges(sp.node.Node)
	 */
	@Override
	public Collection<Edge> getEdges(Node node) {
		// inicializujeme kolekci
		Collection<Edge> ret = new HashSet<Edge>();

		// ziskame pozici uzlu
		int pos = list.indexOf(node);

		// pokud uzel neexistuje, tak konec
		if (pos == -1)
			return ret;

		// projedeme vsechny sousedy uzlu
		for (int i = 0; i < matrix[pos].length; i++) {
			// pokud je soused
			if (matrix[pos][i]) {
				// tak ho pridame do kolekce
				ret.add(new EdgeImpl(node, list.get(i)));
			}
		}
		// vratime kolekci
		return ret;
	}

	/* (non-Javadoc)
	 * @see sp.graph.Graph#remodeEdge(sp.node.Edge)
	 */
	@Override
	public void remodeEdge(Edge edge) {
		matrix[getNodeNumber(edge.getStartNode())][getNodeNumber(edge.getEndNode())] = false;
	}
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#isEdgeExist()
	 */
	@Override
	public boolean isEdgeExist() {
		for (int i = 0; i < matrix.length; i++) {
			for (int j = 0; j < matrix[i].length; j++) {
				if (matrix[i][j]) return true;
			}
		}
		return false;
	}
	
	/**
	 * Vraci pozici uzlu v listu
	 * @param node uzel
	 * @return pozice
	 */
	private int getNodeNumber(Node node) {
		// pokud uzel neexistuje, tak ho zalozime
		if (!list.contains(node)) {
			// pokud ne, tak jej pridame
			list.add(node);
		}
		// vratime jeho index v listu
		return list.indexOf(node);
	}
}
