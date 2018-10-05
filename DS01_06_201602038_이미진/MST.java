package DS01_06_201602038;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Edge{
	int v; // start Vertex index
	int w; // end Vertex index
	int weight; // 가중치
	boolean selected; // 간선으로 선택되었는지 여부
	
	Edge(int v, int w, int weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
}

public class MST {
	private int parent[];
	private int size;//정점의 수
	private int minCost = 0;//최소 비용
	int i=0;
	private Edge[] sort_edge;//정렬이 된 선분의 배열
	private	Edge[] input_edge;//입력받은 순서대로의 선분의 배열
	
	
 	public MST(int n) throws IOException{
		this.size = n;
		this.parent = new int[size];
		Arrays.fill(parent, -1);//배열 -1로 초기화 (정점을 독립원소로 만듦)
		int v,w,weight;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("C://input.txt"));
			
			String line = br.readLine();
			String[] split_line = line.split(" ");
			int size = Integer.parseInt(split_line[1]);
			
			input_edge = new Edge[size];	// 입력받은 edge를 저장하기 위한 배열 생성 
			sort_edge = new Edge[size];	// sort 된 edge를 저장하기 위한 배열 생성
			Edge[] edge1 = new Edge[size];	// edge1 객체 생성
			
			while( i < size ) {
				line = br.readLine();
				split_line = line.split(" ");
				
				v = Integer.parseInt(split_line[0]);
				w = Integer.parseInt(split_line[1]);
				weight = Integer.parseInt(split_line[2]);

				Edge edge2 = new Edge(v, w, weight);	// 입력 받은 v,w,weight로 edge2 객체 생성
				input_edge[i] = edge2; edge1[i] = edge2;
				
				Edge edge3 = new Edge(edge1[i].v, edge1[i].w, edge1[i].weight);
				
				// 가중치 오름차순으로 정렬
				int e;
				for( e = i; 0 < e && edge1[i].weight < edge1[e-1].weight; --e ){
					edge1[e] = edge1[e-1];	
				}
				edge1[e] = edge3;
				i++;
			}
			
			for( i = 0; i < size; i++ ) {
				sort_edge[i] = edge1[i];
			}
			
			br.close();
		}
		catch(FileNotFoundException e) {
			e.printStackTrace();
		}
	}
	
	public void weightedUnion(int i, int j){
		// i가 속한 집합과 j가 속한 집합을 합집합으로 만든다
		int i_2 = i;	// 현재 i 를 i_2 변수에 저장
		int j_2 = j;	// 현재 j 를 j_2 변수에 저장
		int parent_i = parent[i];	// parent[i]의 값을 parent_i에 저장
		int parent_j = parent[j];	// parent[j]의 값을 parent_j에 저장
		
		
		for( ; parent[i] >= 0; ) {	// root 노드일 경우까지
			i = parent[i];
		}
		parent_i = i;
		for( ; parent[j] >= 0; ) {	// root 노드일 경우까지
			j = parent[j];
		}
		parent_j = j;
		
		if( parent[parent_i] < parent[parent_j] ) {	// i 집합이 j 집합보다 작을 경우
			parent[parent_i] += parent[parent_j]; // i집합 = i 집합 + j 집합
			parent[parent_j] = parent_i;
			parent_j = parent_i;
			
		}
		else {	// i 집합이 j 집합보다 클 경우
			parent[parent_j] += parent[parent_i]; // j 집합 = j 집합 + i 집합
			parent[parent_i] = parent_j;
			parent_i = parent_j;
		}
		
		while( parent[i_2] > parent_i && parent[j_2] > parent_j ) {	// root 노드일 경우까지
			int tmp;
			if( parent[i_2] == parent_i ) {
				tmp = parent[i_2];
				parent[tmp] = collapsingFind(tmp);	// parent를 tmp로 바꿈
			}
			if( parent[j_2] == parent_j ) {
				tmp = parent[j_2];
				parent[tmp] = collapsingFind(tmp);	// parent를 tmp로 바꿈
			}
		}
	}
	
	public int collapsingFind(int i) {
		// i가 속한 집합의 root를 찾는다.
		for( ; parent[i] > 0 ;) {
			i = parent[i];	// 자식에서 부모로 이동
		}
		return i;	// i = root 노드
	}
	
	public void Kruskal(){	
		int connected_edges = 0;	// 연결된 선분 수
		int check_edges = 0;	// 확인된 edge수
		int root_v = 0;	// v의 root
		int root_w = 0;	// w의 root
		int i = 0, j = 0;
		int length = input_edge.length;

		for( ; connected_edges != size && check_edges < length ; ) {
			root_v = sort_edge[check_edges].v;
			root_w = sort_edge[check_edges].w;

			if( parent[root_v] != 0 ){
				for( ; parent[root_v] >= 0; ) {	// root 노드 탐색
				root_v = parent[root_v];
				}
			}
			if( parent[root_w] != 0 ) {
				for( ; parent[root_w] >= 0 ; ) {	// root 노드 탐색
					root_w = parent[root_w];
				}
			}

			if( root_v != root_w ){	// root가 서로 다르면 weightedUnion 호출
				weightedUnion(sort_edge[check_edges].v, sort_edge[check_edges].w);
				sort_edge[check_edges].selected = true;	// 간선으로 선택되었으므로 true
				connected_edges++;	// 연결 된 선분 수 증가
			}
			check_edges++;	// 다음 edge 탐색
		}
		
		// sort, weightedUnion,collapsingFind 등 연산을 한 결과를 input_edge에 저장
		while( i < length  && j < length ) {
				if( input_edge[i].v == sort_edge[j].v ) {
					if( input_edge[i].w == sort_edge[j].w ) {
						input_edge[i] = sort_edge[j];
						j++;
					}
					i++;
				}
			}
		
		System.out.println("> 최소 신장 트리에 포함된 간선");
		System.out.print(">");
		for( i=0; i < length; i++ ){
			if( input_edge[i].selected == true ){
				System.out.print(" ( "+ input_edge[i].v +" , "+ input_edge[i].w +" ) ");
				minCost += input_edge[i].weight;
			}	// 연결되어 있으면 최소 신장 트리에 포함된 간선을 출력, minCost와 가중치를 더한다.
		}
		System.out.println();
		System.out.println("> Min Cost = "+ minCost);	// minCost 출력
	}
}