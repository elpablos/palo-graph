package sp;

import java.util.*;

/**
 * Trida starajici se o parsovani vstupu.
 * @author Pavel Lorenz
 */
public class InputStringParser {

	/**
	 * Uzel, ze ktereho zacne vyhledavani.
	 */
	private String startNode = null;
	
	/**
	 * Kolekce vsech uzlu.
	 */
	private Collection<String> result = null;
	
	/**
	 * k vazeb.
	 */
	private Collection<NodeRelation> relation = null;
	
	/**
	 * Parsovani nacteneho retezce na uzle.
	 * @param inputString vstupni retezec
	 */
	public void parse(String inputString) {
		// inicializujeme kolekci
		result = new HashSet<String>();
		// inicializace kolekce
		relation = new HashSet<NodeRelation>();
		
		// vazby
		String rel = inputString.substring(inputString.indexOf("[rel]") + 5,
				inputString.indexOf("[/rel]"));
		
		// pocatecni uzel
		startNode = inputString.substring(inputString.indexOf("[startnode]") + 11,
				inputString.indexOf("[/startnode]"));
		
		// parsovani vazeb 
		String[] rels = rel.trim().split(",");
		for (String str : rels) {
			String[] nodes = str.trim().split( "->");
			for (String node : nodes) {
				result.add(node);
			}
			// vazba mezi uzly
			relation.add(new NodeRelation(nodes[0], nodes[1]));
			// System.out.println("Create rel:[" + nodes[0]  +","+ nodes[1]+"]");
		}
	}

	/**
	 * Getter vracejici hodnotu pocatecniho uzlu.
	 * @return pocatecni uzel
	 */
	public String getStartNode() {
		return startNode;
	}

	/**
	 * Getter vracejici kolekci vsech uzlu.
	 * @return kolekce vsech uzlu
	 */
	public Collection<String> getResult() {
		return result;
	}

	/**
	 * Getter vracejici kolekci vztahu mezi uzly.
	 * @return kolekci vztahu
	 */
	public Collection<NodeRelation> getRelation() {
		return relation;
	}
}
