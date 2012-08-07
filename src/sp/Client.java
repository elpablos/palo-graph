/**
 * 
 */
package sp;

import java.io.IOException;
import sp.graph.*;
import sp.node.*;
import sp.search.*;

/**
 * Hlavni trida aplikace, vstupni bod.
 * 
 * @author Pavel Lorenz
 */
public class Client {

	/**
	 * Vstupni bod aplikace.
	 * 
	 * @param args
	 */
	public static void main(String[] args) {

		// inicializace
		Node startNode = null;
		Graph graph = new MatrixGraphImpl();
		// Graph graph = new ListGraphImpl();
		// Search search = new DepthFirstSearchImpl();
		// Search search = new BreadthFirstSearchImpl();
		Search search = new CycleFindingSearchImpl();

//		// inicializace uzlu
//		Node first = new NodeImpl("1");
//		Node second = new NodeImpl("2");
//		Node third = new NodeImpl("3");
//		Node fourth = new NodeImpl("4");
//		Node fifth = new NodeImpl("5");
//
//		// naplneni grafu
//		graph.setEdge(first, third); // 1 -> 3
//		graph.setEdge(first, fourth); // 1 -> 4
//		graph.setEdge(fourth, third); // 4 -> 3
//		graph.setEdge(second, third); // 2 -> 3
//		graph.setEdge(third, second); // 3 -> 2
//		graph.setEdge(second, fifth); // 2 -> 5
//		graph.setEdge(third, fifth); // 3 -> 5
//		graph.setEdge(second, first); // 2 -> 1
//
//		// startovaci uzel
//		startNode = fourth;
		
		String path = "C:\\Users\\Pavel Lorenz\\Desktop\\School\\ppa2\\Validace\\domecek.txt";
		String inputText = null;
		try {
			inputText = TextFileHelper.readString(path);
		} catch (IOException e) {
			// vypiseme vyjimku a konec
			e.printStackTrace();
			return;
		}
		// inicializace dat grafu
		GraphInicialize init= new GraphInicialize();
		init.inicialize(graph, inputText);
		startNode = init.getStartNode();
		
		// prohled
		search.search(graph, startNode);
		
		// vypis vysledku
		System.out.println(search.toString());
	}

}
