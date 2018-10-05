package DS01_02;

public class Graph {
	private int size; // 정점의 개수
	private String[] vertices; // 정점들을 저장할 배열
	private Node[] a; // 각 정점당 하나의 리스트를 가지게 하기 위한 배열
	
	public Graph(String[] args){
		// 생성자
		// 인자로 받은 args 저장
		// 배열 a 초기화
		size = args.length;
		vertices = new String[size];
		a = new Node[size];
		int i;
		for (i=0; i<args.length; i++){
			vertices[i] = args[i];
			a[i] = new Node(i);
		}
	}
	
	public void add(String v, String w){
		// 간선 추가
		// 정점 v의 리스트에 w 추가, 정점 w의 리스트에 v 추가
		a[index(v)].add(index(w));
		a[index(w)].add(index(v));
	}
	
	public String toString(){
		// 그래프 프린트
		Node e;
		if(size == 0) return "{}";	// 사이즈가 0이면 배열에 아무것도 들어가있지 않으므로 {} 만 출력
		StringBuffer buf = new StringBuffer();
		for( int i=0; i<size; i++ ) {
			if( i == 0 ) {	// 인덱스가 0일때
				buf.append("{"+vertices[0]+":");
			}
			else {	// 인덱스가 0이 아닐때
				buf.append(","+vertices[i]+":");
			}
			for( e = a[i].next; e != null; e = e.next ) {	// 인접한 정점 buf에 저장
				buf.append(vertices[e.data]);
			}
		}
		return buf+"}";
		
		
	}
	
	private int index(String v){
		// vertices 배열에서 정점 v의 인덱스 반환
		for(int i = 0; i<size; i++){
			if( vertices[i] == v ){
				return i;
			}
		}
		return 0;
	}
	
	public void calc_degree(){
		Node e;
		System.out.println("정점	인접한 정점 수");
		for(int i = 0; i<size; i++) {
			int edges = 0;	// 초기화
			System.out.print(" " + vertices[i] + "	    ");	// 인덱스를 증가시키며 정점을 출력
			for( e = a[i].next; e != null; e = e.next){	// 간선 수를 통해 인접한 정점의 수를 구함
				++edges;	// 간선 증가
			}
			System.out.println(edges);	// 간선 수 출력
		}
	}
	
	private class Node {	// 노드 클래스
		private int data;
		private Node next;
		
		Node() {	// data와 next 둘다 받지 않는 생성자
			this.data = 0;
			this.next = null;
		}
		
		Node(int data){	// data만 받는 생성자
			this.data = data;
			this.next = null;
		}
		public Node(int data, Node next){	// data와 next 모두 받는 생성자
			this.data = data;
			this.next = next;
		}
		
		public void add(int data) {	// data를 입력받아 리스트에 추가
			this.next = new Node(data, next);
		}
		
	}
}
