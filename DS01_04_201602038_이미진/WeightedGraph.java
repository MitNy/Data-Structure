package DS01_04_201602038;

// try catch
import java.util.Stack;

public class WeightedGraph {
	String[] vertices;	// 정점
	String[] prevPath;	// 전 경로
	boolean[] visit;	// 방문 여부
	int[][] a;	// 각 정점의 경로 길이
	int[] weight;	//가중치
	int size;	// 정점의 수
	static int MAX_LENGTH = 10;	// 정점의 거리

	
	public WeightedGraph(String args[]){ // 생성자
		
		// args의 길이만큼 각각의 배열들 생성
		size = args.length;
		vertices = new String[size];
		weight = new int[size];
		prevPath = new String[size];
		
		System.arraycopy(args, 0, vertices, 0, size);
		
		visit = new boolean[size];
		a = new int[size][size];
		
		for(int j = 0; j < size; j++) {
			for(int i = 0; i < size; i++){
				a[j][i] = MAX_LENGTH;
			}
		}
	}
	
	public void add(String v, String w, int weight) {	// 경로 저장
		int i = index(v);
		int j = index(w);
		a[i][j] = a[j][i] = weight;
	}
	
	private int index(String v) {
		for( int i=0; i<size; i++ ) {
			if( vertices[i].equals(v) ){	// vertices의 i번째 index에 있는 원소가 v와 같을 때 i return.
				return i;
			}
		}
		return a.length;
	}
	
	public void dijkstra(int i) {	// dijkstra 알고리즘 수행
		for(int j = 0; j < size; j++){
			// 초기화
			prevPath[j] = null;
			weight[j] = a[i][j];
			
			if( !(weight[j] == MAX_LENGTH) ) {	// 시작 정점과 인접하게 연결되어있을 경우
				prevPath[j] = "0";	// 시작 정점으로 초기화
			}
		}
		visit[i] = true;	// 방문했으므로 true
		weight[i] = 0;


		for( int rep=1 ; rep < size ; rep++ ){
			int n;
			int s = shortDistance(weight, visit);	// shortDistance 메소드 호출 결과를 저장
		
			for( n=0; n <size; n++ ){
				// 이전 거리보다 짧음, 방문X, 직접 연결, 시작 정점과 이어진 경로가 있음의 경우를 모두 만족할 경우
				if( (a[s][n] + weight[s] < weight[n])  && !(visit[n] || a[s][n] == MAX_LENGTH || weight[s] == MAX_LENGTH ) ) {
						prevPath[n] = String.valueOf(s);
						weight[n] = a[s][n] + weight[s];
					}
			}
			visit[s] = true;	// 방문했으므로 true
		}
	}
	
	public int shortDistance(int[] weight, boolean[] visit) {
		// 최단  거리 정점을 찾는다.
		int s = MAX_LENGTH;	// 10
		int index = 0;
		for( int i=0; i<size; i++ ) {
			if( !(visit[i] || s < weight[i]) ) {	// 방문하지 않았거나 MAX_LENGTH보다 weight[i]가 작을때 
				index = i;
				s = weight[i];
			}
		}
		return index;	// index 반환
	}
	
	public void printPaths(){	// 한 정점에서 다음 정점으로의 최단 경로 및 가중치를 출력
		Stack<Integer> stack = new Stack<Integer>();	// stack 객체 생성
		
		for( int i=1; i < size; i++ ){
			System.out.println(vertices[0]);	// 시작 정점 출력

			int pp = i;	// 이전 경로를 i로 초기화
			stack.add(pp);
			
			for(;;) {
				if( prevPath[pp] != "0" ) {	// 이전 경로가 시작 정점이 아닐 경우
					stack.add(Integer.parseInt(prevPath[pp]));
					pp = Integer.parseInt(prevPath[pp]);
				}
				else {
					break;
				}
			}
			for( ; !stack.isEmpty(); ) {	// 스택이 비어있지 않을 경우
				int sp = stack.pop();	// 스택에서 pop한 원소를 sp에 저장
				System.out.print("-> "+ vertices[sp]);	// 경로 출력
				System.out.println("("+weight[sp]+")");	// 가중치 출력
			}
		}
	}
}
/*

try{
	BufferedReader br = new BufferedReader(new FileReader(new File("파일명")));
	///
	 파일 읽는 코드
	 ///
	 br.close();
}
catch(IOException e) {
	e.printStackTrace();


*/
