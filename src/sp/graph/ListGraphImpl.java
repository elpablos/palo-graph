/**
 * 
 */
package sp.graph;

import java.util.*;

import sp.node.*;

/**
 * Implementace seznamu sousednosti.
 * @author Pavel Lorenz
 */
public class ListGraphImpl implements Graph {

	/**
	 * Seznam sousedu.
	 */
	private List<Neighbor> list = new ArrayList<Neighbor>();
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#getChildren(sp.node.Node)
	 */
	@Override
	public Collection<Node> getNeighbors(Node node) {
		// Kolekce "cernych" uzlu.
		 Collection<Node> ret = new HashSet<Node>();
		
		Neighbor temp = null;
		// projedeme vsechny sousedy
		for (Neighbor item : list) {
			// pokud existuje soused se stejnym uzlem, tak nastavime flag na
			// true
			if (item.getNode().equals(node)) {
				temp = item;
				break;
			}
		}
		if (temp != null) {
			// vratime kolekci vsech sousedu
			while (temp.getNext() != null) {
				temp = temp.getNext();
				ret.add(temp.getNode());
			}
		}
		
		return ret;
	}

	/* (non-Javadoc)
	 * @see sp.graph.Graph#setEdge(sp.node.Node, sp.node.Node)
	 */
	@Override
	public void setEdge(Node sourceNode, Node destinationNode) {
		// vytahneme zdrojoveho souseda
		Neighbor neighbor = getExistOrCreateNeighbor(sourceNode);
		// vytvorime si pomocnou referenci na souseda
		Neighbor temp = neighbor;
		// dokud nenalezneme konec seznamu
		while (temp.getNext() != null) {
			// poukud jiz existuje hrana, tak konec
			if (temp.getNode().equals(destinationNode)) {
				return;
			}
			temp = temp.getNext();
		}
		// na konec seznamu pridame hranu
		temp.setNext(new Neighbor(destinationNode));
	}
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#getEdges(sp.node.Node)
	 */
	@Override
	public Collection<Edge> getEdges(Node node) {
		// Kolekce hran.
		Collection<Edge> ret = new HashSet<Edge>();

		Neighbor temp = null;
		// projedeme vsechny sousedy
		for (Neighbor item : list) {
			// pokud existuje soused se stejnym uzlem, tak nastavime flag na
			// true
			if (item.getNode().equals(node)) {
				temp = item;
				break;
			}
		}
		if (temp != null) {
			// vratime kolekci vsech sousedu
			while (temp.getNext() != null) {
				temp = temp.getNext();
				ret.add(new EdgeImpl(node, temp.getNode()));
			}
		}

		return ret;
	}
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#remodeEdge(sp.node.Edge)
	 */
	@Override
	public void remodeEdge(Edge edge) {
		Neighbor ret = null;
		boolean isExist = false;
		// projedeme vsechny sousedy
		for (Neighbor neighbor : list) {
			// pokud existuje soused se stejnym uzlem, tak nastavime flag na true
			if (neighbor.getNode().equals(edge.getStartNode())) {
				isExist = true;
				ret = neighbor;
				break;
			}
		}

		if (isExist) {
			Neighbor previous;
			while (ret.getNext() != null) {
				previous = ret;
				ret = ret.getNext();
				
				if (ret.getNode().equals(edge.getEndNode())) {
					previous.setNext(ret.getNext());
				}
			}
		}
	}
	
	/* (non-Javadoc)
	 * @see sp.graph.Graph#isEdgeExist()
	 */
	@Override
	public boolean isEdgeExist() {
		for (Neighbor neigh : list) {
			if (neigh.getNext() != null) return true;
		}
		return false;
	}
	
	/**
	 * Pomocna metoda kontrolujici existenci uzlu.
	 * @param node uzel
	 */
	private Neighbor getExistOrCreateNeighbor(Node node) {
		Neighbor ret = null;
		boolean isExist = false;
		// projedeme vsechny sousedy
		for (Neighbor neighbor : list) {
			// pokud existuje soused se stejnym uzlem, tak nastavime flag na true
			if (neighbor.getNode().equals(node)) {
				isExist = true;
				ret = neighbor;
			}
		}
		// pokud soused neexistuje, tak ho vytvorime
		if (!isExist) {
			ret = new Neighbor(node);
			list.add(ret);
		}
		// vratime uzel
		return ret;
	}
	
	/**
	 * Vnitrni pomocna trida pro usnadneni prace se sousedy.
	 * @author Pavel Lorenz
	 */
	public class Neighbor
	{
		/**
		 * Reference na uzel.
		 */
		private Node node;
		
		/**
		 * Nasledujici soused.
		 */
		private Neighbor next;
		
		/**
		 * Injektaz uzlu pomoci konstruktoru.
		 * @param node uzel
		 */
		public Neighbor(Node node) {
			this.node = node;
		}
		
		/**
		 * Getter vracejici uzel.
		 * @return uzel
		 */
		public Node getNode() {
			return this.node;
		}

		/**
		 * Getter vracejici nasledujiciho souseda.
		 * @return soused
		 */
		public Neighbor getNext() {
			return next;
		}

		/**
		 * Setter nastavujici nasledujiciho souseda.
		 * @param next nasledujici soused
		 */
		public void setNext(Neighbor next) {
			this.next = next;
		}
	}
}
