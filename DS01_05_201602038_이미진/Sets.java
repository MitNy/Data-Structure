package DS01_05_201602038;

public class Sets {
	private int parent[];	// weightedUnion과 collapsingFind를 위한 배열
	private int size;	// 배열에 대한 크기(n값)
	
	public Sets(int n) {	// 초기 생성자, n값을 입력받음.
		this.size = n;
		this.parent = new int[size];
	}
	
	public void initialize() {	// parent 배열 초기화. 
		this.parent = new int[-size];
	}
	
	public void addSet(int set[]) {
	// set 배열을 입력받아서 parent 배열을 초기화, 집합의 root는 index 0번째 원소로 설정
		parent[set[0]] = -size;
	}
	
	public void printSets() {
	// root에 속한 원소들을 출력
		for( int i=0; i< size; i++ ) {	// 정점 탐색
			if( parent[i] <= 0 ) {	// parent[i] 가 root이면
				System.out.print("[ROOT: "+i+"], {");	// root 출력
			
				for( int j=0; j<size; j++ ) {	// 정점 확인
					int j_2 = j;
					if(i == j)	// i 와 j 가 같으면 continue
						continue;
					
					for( ; parent[j_2] > 0 ; ) {	// root 노드일 경우까지
						j_2 = parent[j_2];
					} 
					if( i == j_2 ) {  // i 가 root 노드일 때
						System.out.print(" "+j);	// root에 속한 원소들 출력
					}
				}
				System.out.println(" }");
			}
		}
		System.out.println();
	}
	
	public void weightedUnion(int i, int j) {
	// i가 속한 집합과 j가 속한 집합을 합집합으로 만든다
		int i_2 = i;	// 현재 i 를 i_2 변수에 저장
		int j_2 = j;	// 현재 j 를 j_2 변수에 저장
		int parent_i = parent[i];	// parent[i]의 값을 parent_i에 저장
		int parent_j = parent[j];	// parent[j]의 값을 parent_j에 저장
		
		System.out.println("weightedUnion("+i+","+j+")");	// i와 j 출력
		
		for( ; parent[i] > 0; ) {	// root 노드일 경우까지
			i = parent[i];
			for( ; parent[j] > 0; ) {	// root 노드일 경우까지
				j = parent[j];
			}
		}
		parent_i = i;
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
		
		while( parent[i_2] < 0 && parent[j_2] > 0 ) {	// root 노드일 경우까지
			int tmp;
				if( parent[i_2] != parent_i ) {
					tmp = parent[i_2];
					parent[tmp] = collapsingFind(tmp);	// parent를 tmp로 바꿈
				}
				if( parent[j_2] != parent_j ) {
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
}