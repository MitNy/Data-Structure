package DS01_02;

public class TestGraph {
	public static void main(String args[]) {
		Graph graph = new Graph(new String[]{"A","B","C","D","E","F","G","H"});
	
		graph.add("A","B");
		graph.add("A","E");
		graph.add("B","C");
		graph.add("B","F");
		graph.add("C","D");
		graph.add("C","H");
		graph.add("D","H");
		graph.add("E","F");
		graph.add("F","G");
		
		System.out.println(graph);
		System.out.println();
		graph.calc_degree();
	}
}
