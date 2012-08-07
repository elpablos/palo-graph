package sp.node;

/**
 * Rozhrani objektu reprezentujici hranu.
 * @author Pavel Lorenz
 */
public interface Edge {

	/**
	 * Setter nastavujici barvu hrany.
	 * @param color the color to set
	 */
	public void setColor(Color color);

	/**
	 * Getter vracejici barvu hrany.
	 * @return the color
	 */
	public Color getColor();

	/**
	 * Getter vracejici pocatecni uzel.
	 * @return the startNode
	 */
	public Node getStartNode();

	/**
	 * Getter vracejici konecny uzel.
	 * @return the endNode
	 */
	public Node getEndNode();

}