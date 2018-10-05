package DS01_03_2;

public class TestGraph {
	public static void main(String[] args) {
		Graph graph = new Graph(new String[]{"A","B","C","D","E","F","G","H"});

		graph.add("A", "B");
		graph.add("A", "E");
		graph.add("B", "C");
		graph.add("B", "F");
		graph.add("C", "D");
		graph.add("C", "H");
		graph.add("D", "H");
		graph.add("E", "F");
		graph.add("F", "G");
		
		System.out.println(graph);	// 그래프 출력
		System.out.print("recu_dfs : ");
		graph.recu_dfs(0);	// recu_dfs 실행결과 출력
		
		System.out.println();
		System.out.print("nonrecu_dfs : ");
		graph.nonrecu_dfs(0);	// nonrecu_dfs 실행결과 출력
	}
}

