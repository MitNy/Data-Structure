package DS01_02;

public class Graph {
	private int size; // ������ ����
	private String[] vertices; // �������� ������ �迭
	private Node[] a; // �� ������ �ϳ��� ����Ʈ�� ������ �ϱ� ���� �迭
	
	public Graph(String[] args){
		// ������
		// ���ڷ� ���� args ����
		// �迭 a �ʱ�ȭ
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
		// ���� �߰�
		// ���� v�� ����Ʈ�� w �߰�, ���� w�� ����Ʈ�� v �߰�
		a[index(v)].add(index(w));
		a[index(w)].add(index(v));
	}
	
	public String toString(){
		// �׷��� ����Ʈ
		Node e;
		if(size == 0) return "{}";	// ����� 0�̸� �迭�� �ƹ��͵� ������ �����Ƿ� {} �� ���
		StringBuffer buf = new StringBuffer();
		for( int i=0; i<size; i++ ) {
			if( i == 0 ) {	// �ε����� 0�϶�
				buf.append("{"+vertices[0]+":");
			}
			else {	// �ε����� 0�� �ƴҶ�
				buf.append(","+vertices[i]+":");
			}
			for( e = a[i].next; e != null; e = e.next ) {	// ������ ���� buf�� ����
				buf.append(vertices[e.data]);
			}
		}
		return buf+"}";
		
		
	}
	
	private int index(String v){
		// vertices �迭���� ���� v�� �ε��� ��ȯ
		for(int i = 0; i<size; i++){
			if( vertices[i] == v ){
				return i;
			}
		}
		return 0;
	}
	
	public void calc_degree(){
		Node e;
		System.out.println("����	������ ���� ��");
		for(int i = 0; i<size; i++) {
			int edges = 0;	// �ʱ�ȭ
			System.out.print(" " + vertices[i] + "	    ");	// �ε����� ������Ű�� ������ ���
			for( e = a[i].next; e != null; e = e.next){	// ���� ���� ���� ������ ������ ���� ����
				++edges;	// ���� ����
			}
			System.out.println(edges);	// ���� �� ���
		}
	}
	
	private class Node {	// ��� Ŭ����
		private int data;
		private Node next;
		
		Node() {	// data�� next �Ѵ� ���� �ʴ� ������
			this.data = 0;
			this.next = null;
		}
		
		Node(int data){	// data�� �޴� ������
			this.data = data;
			this.next = null;
		}
		public Node(int data, Node next){	// data�� next ��� �޴� ������
			this.data = data;
			this.next = next;
		}
		
		public void add(int data) {	// data�� �Է¹޾� ����Ʈ�� �߰�
			this.next = new Node(data, next);
		}
		
	}
}
