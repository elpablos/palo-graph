/**
 * 
 */
package sp.node;

/**
 * Implementace objektu nesouci informace o grafove hrane.
 * @author Pavel Lorenz
 */
public class EdgeImpl implements Edge {

	/**
	 * Reference na pocacni uzel.
	 */
	private Node startNode;
	
	/**
	 * Reference na konecny uzel.
	 */
	private Node endNode;
	
	/**
	 * Barva hrany.
	 */
	private Color color;
	
	/**
	 * @param startNode
	 * @param endNode
	 */
	public EdgeImpl(Node startNode, Node endNode) {
		this.startNode = startNode;
		this.endNode = endNode;
		this.color = Color.White;
	}


	/* (non-Javadoc)
	 * @see sp.node.Edge#setColor(sp.node.Color)
	 */
	public void setColor(Color color) {
		this.color = color;
	}


	/* (non-Javadoc)
	 * @see sp.node.Edge#getColor()
	 */
	public Color getColor() {
		return color;
	}
	
	/* (non-Javadoc)
	 * @see sp.node.Edge#getStartNode()
	 */
	public Node getStartNode() {
		return startNode;
	}

	/* (non-Javadoc)
	 * @see sp.node.Edge#getEndNode()
	 */
	public Node getEndNode() {
		return endNode;
	}
}
