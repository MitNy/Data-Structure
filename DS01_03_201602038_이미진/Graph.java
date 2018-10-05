package DS01_03_2;

import java.util.Stack;

public class Graph {
	int size;
	String[] vertices;	// 정점
	boolean[][] a;	// 인접한 행렬의 배열
	boolean[] visit;	// 방문했는지 안했는지 체크
	Stack stack = new Stack();	// stack 생성
	
	public Graph(String[] args) {
		this.size = args.length;
		vertices = new String[size];
		System.arraycopy(args, 0, vertices, 0, size);
		a = new boolean[size][size];	// size만큼 인접한 행렬의 배열을 생성
		visit = new boolean[size];	// size만큼 정점 방문을 체크하는 배열을 생성
	}
	
	public void add(String v, String w) {
		int i = index(v);
		int j = index(w);
		a[i][j] = a[j][i] = true;	// a[i][j]가 참이면 정점 j는 인접
	}
	
	public String toString() {	// 그래프 프린트
		if( size == 0 ) return "{}";	// 사이즈가 0이면 {} 만 출력
		StringBuffer buf = new StringBuffer("{"+vertex(0));
		
		for( int i=1; i<size; i++ ) {
			buf.append(","+vertex(i));
		}
		return buf+"}";
	}

	private int index(String v) {
		for( int i=0; i<size; i++ ) {
			if( vertices[i].equals(v) ) return i;
		}
		return a.length;
	}
	
	private String vertex(int i) {
		StringBuffer buf = new StringBuffer(vertices[i]+":");
		for( int j=0; j<size; j++ ) {
			if( a[i][j] ) buf.append(vertices[j]);
		}
		return buf+"";
	}
	
	public void recu_dfs(int v) {
		visit[v] = true;	// 방문했으므로 true
		
		System.out.print(vertices[v]+" ");	// 정점 출력
		for( int i=0; i<size; i++ ) {
			if( a[v][i]  && visit[i] == false) {	// 인접하고 아직 방문되지 않은 정점들이 존재한다면
				recu_dfs(i);	// recu_dfs 메소드를 호출
			}
		}
	}
	
	public void nonrecu_dfs(int v){
		int i;
		int u = 0;	// w에 인접하면서 방문하지 않은 정점 u
		
		for( i=0; i < size; i++) {	// 방문 체크 초기화
			visit[i] = false;
		}
	
		visit[v] = true;	// 방문 체크
		stack.push(v);	// 시작 정점 v를 stack에 삽입

		int w = v;	// w = v
		
		System.out.print(vertices[v]+" ");	// 시작 정점 출력

		for( u = 0; u < size; u++ ){
			if( a[w][u] && visit[u] == false){	// w에 인접하면서 방문되지 않은 u가 있다면
				System.out.print(vertices[u]+" ");	// 인접 정점 출력
				
				visit[u] = true;	// 방문 체크
				stack.push(u);	// stack에 u 삽입
				w = u;
				u = 0;

			}
			else if( u == size-1 && visit[u] == true && stack.empty() == false ){	// w에 인접하면서 방문되지 않은 정점이 없고 스택에 원소가 있다면
					 w = (int)stack.pop(); // 스택에서 원소 삭제
					 u = 0;
					 w = u;
			}
				 
			if( stack.empty()) {	// w에 인접하면서 방문되지 않은 정점이 없고 스택이 비어있다면
				break;	// 종료
			}
		}	
	}
}