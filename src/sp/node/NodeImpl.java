/**
 * 
 */
package sp.node;

/**
 * Implementace uzlu.
 * @author Pavel Lorenz
 */
public class NodeImpl implements Node {

	/**
	 * Barva uzlu.
	 */
	private Color color;
	
	/**
	 * Jmeno uzlu.
	 */
	private String name;

	/**
	 * Konstruktor vytvarejici uzly a nastavujici jejich jmeno.
	 * @param name jmeno uzlu
	 */
	public NodeImpl(String name) {
		this.name = name;
		this.color = Color.White;
	}
	
	/* (non-Javadoc)
	 * @see sp.node.Node#setColor(sp.node.NodeColor)
	 */
	@Override
	public void setColor(Color color) {
		this.color = color;
	}

	/* (non-Javadoc)
	 * @see sp.node.Node#getColor()
	 */
	@Override
	public Color getColor() {
		return color;
	}

	/* (non-Javadoc)
	 * @see sp.node.Node#getName()
	 */
	public String getName() {
		return name;
	}
}
