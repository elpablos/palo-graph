/**
 * 
 */
package sp.node;

/**
 * Rozhrani pro implementaci uzlu.
 * @author Pavel Lorenz
 */
public interface Node {
	
	/**
	 * Setter nastavujici barvu uzlu.
	 * @param color barva
	 */
	void setColor(Color color);
	
	
	/**
	 * Getter vracejici barvu uzlu.
	 * @return barva
	 */
	Color getColor();
	
	/**
	 * Getter vracejici jmeno uzlu.
	 * @return
	 */
	String getName();
}
