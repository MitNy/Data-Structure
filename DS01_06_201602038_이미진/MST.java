package DS01_06_201602038;

import java.io.BufferedReader;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;
import java.util.Arrays;

class Edge{
	int v; // start Vertex index
	int w; // end Vertex index
	int weight; // ����ġ
	boolean selected; // �������� ���õǾ����� ����
	
	Edge(int v, int w, int weight){
		this.v = v;
		this.w = w;
		this.weight = weight;
	}
}

public class MST {
	private int parent[];
	private int size;//������ ��
	private int minCost = 0;//�ּ� ���
	int i=0;
	private Edge[] sort_edge;//������ �� ������ �迭
	private	Edge[] input_edge;//�Է¹��� ��������� ������ �迭
	
	
 	public MST(int n) throws IOException{
		this.size = n;
		this.parent = new int[size];
		Arrays.fill(parent, -1);//�迭 -1�� �ʱ�ȭ (������ �������ҷ� ����)
		int v,w,weight;
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("C://input.txt"));
			
			String line = br.readLine();
			String[] split_line = line.split(" ");
			int size = Integer.parseInt(split_line[1]);
			
			input_edge = new Edge[size];	// �Է¹��� edge�� �����ϱ� ���� �迭 ���� 
			sort_edge = new Edge[size];	// sort �� edge�� �����ϱ� ���� �迭 ����
			Edge[] edge1 = new Edge[size];	// edge1 ��ü ����
			
			while( i < size ) {
				line = br.readLine();
				split_line = line.split(" ");
				
				v = Integer.parseInt(split_line[0]);
				w = Integer.parseInt(split_line[1]);
				weight = Integer.parseInt(split_line[2]);

				Edge edge2 = new Edge(v, w, weight);	// �Է� ���� v,w,weight�� edge2 ��ü ����
				input_edge[i] = edge2; edge1[i] = edge2;
				
				Edge edge3 = new Edge(edge1[i].v, edge1[i].w, edge1[i].weight);
				
				// ����ġ ������������ ����
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
		// i�� ���� ���հ� j�� ���� ������ ���������� �����
		int i_2 = i;	// ���� i �� i_2 ������ ����
		int j_2 = j;	// ���� j �� j_2 ������ ����
		int parent_i = parent[i];	// parent[i]�� ���� parent_i�� ����
		int parent_j = parent[j];	// parent[j]�� ���� parent_j�� ����
		
		
		for( ; parent[i] >= 0; ) {	// root ����� ������
			i = parent[i];
		}
		parent_i = i;
		for( ; parent[j] >= 0; ) {	// root ����� ������
			j = parent[j];
		}
		parent_j = j;
		
		if( parent[parent_i] < parent[parent_j] ) {	// i ������ j ���պ��� ���� ���
			parent[parent_i] += parent[parent_j]; // i���� = i ���� + j ����
			parent[parent_j] = parent_i;
			parent_j = parent_i;
			
		}
		else {	// i ������ j ���պ��� Ŭ ���
			parent[parent_j] += parent[parent_i]; // j ���� = j ���� + i ����
			parent[parent_i] = parent_j;
			parent_i = parent_j;
		}
		
		while( parent[i_2] > parent_i && parent[j_2] > parent_j ) {	// root ����� ������
			int tmp;
			if( parent[i_2] == parent_i ) {
				tmp = parent[i_2];
				parent[tmp] = collapsingFind(tmp);	// parent�� tmp�� �ٲ�
			}
			if( parent[j_2] == parent_j ) {
				tmp = parent[j_2];
				parent[tmp] = collapsingFind(tmp);	// parent�� tmp�� �ٲ�
			}
		}
	}
	
	public int collapsingFind(int i) {
		// i�� ���� ������ root�� ã�´�.
		for( ; parent[i] > 0 ;) {
			i = parent[i];	// �ڽĿ��� �θ�� �̵�
		}
		return i;	// i = root ���
	}
	
	public void Kruskal(){	
		int connected_edges = 0;	// ����� ���� ��
		int check_edges = 0;	// Ȯ�ε� edge��
		int root_v = 0;	// v�� root
		int root_w = 0;	// w�� root
		int i = 0, j = 0;
		int length = input_edge.length;

		for( ; connected_edges != size && check_edges < length ; ) {
			root_v = sort_edge[check_edges].v;
			root_w = sort_edge[check_edges].w;

			if( parent[root_v] != 0 ){
				for( ; parent[root_v] >= 0; ) {	// root ��� Ž��
				root_v = parent[root_v];
				}
			}
			if( parent[root_w] != 0 ) {
				for( ; parent[root_w] >= 0 ; ) {	// root ��� Ž��
					root_w = parent[root_w];
				}
			}

			if( root_v != root_w ){	// root�� ���� �ٸ��� weightedUnion ȣ��
				weightedUnion(sort_edge[check_edges].v, sort_edge[check_edges].w);
				sort_edge[check_edges].selected = true;	// �������� ���õǾ����Ƿ� true
				connected_edges++;	// ���� �� ���� �� ����
			}
			check_edges++;	// ���� edge Ž��
		}
		
		// sort, weightedUnion,collapsingFind �� ������ �� ����� input_edge�� ����
		while( i < length  && j < length ) {
				if( input_edge[i].v == sort_edge[j].v ) {
					if( input_edge[i].w == sort_edge[j].w ) {
						input_edge[i] = sort_edge[j];
						j++;
					}
					i++;
				}
			}
		
		System.out.println("> �ּ� ���� Ʈ���� ���Ե� ����");
		System.out.print(">");
		for( i=0; i < length; i++ ){
			if( input_edge[i].selected == true ){
				System.out.print(" ( "+ input_edge[i].v +" , "+ input_edge[i].w +" ) ");
				minCost += input_edge[i].weight;
			}	// ����Ǿ� ������ �ּ� ���� Ʈ���� ���Ե� ������ ���, minCost�� ����ġ�� ���Ѵ�.
		}
		System.out.println();
		System.out.println("> Min Cost = "+ minCost);	// minCost ���
	}
}