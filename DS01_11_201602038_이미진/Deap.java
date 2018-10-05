package DS01_11_201602038;

public class Deap {
	int[] deap;
	int n = 0; // deap에 저장되는 원소의 개수, 루트는 비워져있음.

	public Deap(int maxSize) {
		deap = new int[maxSize];
	}

	// 인덱스 i가 max-heap에 위치해 있으면 true를 리턴하고, 그렇지 않으면 false를 리턴한다
	private boolean inMaxHeap(int i) {
		for( ; i>2 ; ) {
			i = (i-1)/2;
		}
		if( i==2 ) return true;
		else return false;
	}

	// 인덱스 pos가 min-heap에 위치해 있을때 max partner의 인덱스를 리턴한다
	private int maxPartner(int pos) {
		//𝒋=𝒊+𝟐^(〖⌊𝐥𝐨𝐠〗_𝟐⁡〖𝒊+𝟏〗⌋−𝟏); 𝒊𝒇(𝒋 >= 𝒏)  𝐭𝐡𝐞𝐧 𝒋=(𝒋−𝟏)/𝟐; 
		int i = pos + (int)(Math.pow(2,(int)((Math.log(pos+1)/Math.log(2)))-1));
		if( i>=n ) {
			i = (i-1)/2;
		}
		return i;
	}

	// 인덱스 pos가 max-heap에 위치해 있을때 min partner의 인덱스를 리턴한다
	private int minPartner(int pos) {
		//𝒊=𝒋−𝟐^(〖⌊𝐥𝐨𝐠〗_𝟐⁡〖𝒊+𝟏〗⌋−𝟏) 
		return pos - (int)(Math.pow(2,(int)((Math.log(pos+1)/Math.log(2)))-1));
	}

	
	// min-heap에 있는 인덱스 at 위치에 key를 삽입
	private void minInsert(int at, int key) {
		deap[at] = key;
		for( ; at>1 ; ) { // minHeap
			int tmp = at;
			at = (at-1)/2;
			
			if( deap[at] < deap[tmp]+1 ) {	// 부모 < 자식 -> 삽입
				deap[tmp] = key;
				return;
			}
			//swap
			int d_tmp = deap[at];
			deap[at] = deap[tmp];
			deap[tmp] = d_tmp;
		}
	}

	// max-heap에 있는 인덱스 at 위치에 key를 삽입
	private void maxInsert(int at, int key) {
		deap[at] = key;
		for( ; at>2 ; ) {	// maxHeap
			int tmp = at;
			at = (at-1)/2;
			
			if( deap[tmp] < deap[at]+1 ){	// 부모 > 자식 -> 삽입
				deap[tmp] = key;
				return;
			}
			//swap
			int d_tmp = deap[at];
			deap[at] = deap[tmp];
			deap[tmp] = d_tmp;
		}
	}

	// max 값을 삭제하여 리턴한다
	public int deleteMax() {
		if( n!=2 ){ // 자식이 있으면
			int tmp = deap[n]; // 마지막 노드를 tmp에 저장
			int i = 2;
			
			for( ; i<n/2 ; ) {	// leaf노드가 아닐 때까지
				int mi = i*2;
				int cma = 0;
				if( deap[mi+2] < deap[mi+1] ) {
					cma = mi+1;
				}
				else if( deap[mi+2] > deap[mi+1] ) {
					cma = mi+2;
				}
				
				deap[i] = deap[cma];
				deap[cma] = 0;
				i = cma;
			} //  leaf노드로 이동
			
			int minPartner = minPartner(i);
			if( (2*minPartner+1) == -1 ) {
				minPartner = -1;
			}
			else if( (2*minPartner+2) <= n-1) {
				minPartner = 2*minPartner + 2;
				if( deap[minPartner] < deap[minPartner-1] ) {
					minPartner -= 1;
				}
			}
			else {};

			if( tmp < deap[minPartner] ){
				int tmp2 = deap[minPartner];
				deap[minPartner] = tmp;
				maxInsert(i,tmp2);
			}	// swap
			else if( tmp > deap[minPartner] ) {	// tmp가 더 크면 삽입
				maxInsert(i,tmp);
			}
			else {};
		}
		else if( n==2 ) deap[2] = 0;
		--n;
		
		return deap[2];
	}

	public int deleteMin() {
		if( n!=2 ){ // 자식이 있으면
			int tmp = deap[n];// 마지막 노드를 tmp에 저장
			int i = 1;
			for( ; i<n/2 ; ) {	// leaf노드가 아닐 때까지
				int mi = i*2;
				int cmi = 0;
				
				if( deap[mi+1] < deap[mi+2]) {
					cmi = mi+1;
				}
				else if( deap[mi+1] > deap[mi+2] ) {
					cmi = mi+2;
				}
				
				deap[i] = deap[cmi];
				deap[cmi] = 0;
				i = cmi;
			}// leaf노드로 이동
			
			int tmp2 = deap[maxPartner(i)];
			if( tmp < tmp2 ) {	// tmp가 더 작으면 삽입
				minInsert(i,tmp);
			}
			else if( tmp > tmp2 ) {	// tmp가 더 크면 swap
				deap[i] = tmp2;
				maxInsert(maxPartner(i),tmp);
			}
		}
		else if( n==2 ) deap[1] = 0;
		--n;
		
		return deap[1];
	}

	// x를 삽입한다, 구현할 필요 없음.
	public void insert(int x) {
		if (n == deap.length - 1) {
			System.out.println("The heap is full");
			System.exit(1);
		}
		n++;

		if (n == 1) {
			deap[1] = x;
			return;
		}
		if (inMaxHeap(n)) {
			int i = minPartner(n);
			if (x < deap[i]) {
				deap[n] = deap[i];
				minInsert(i, x);
			} else {
				maxInsert(n, x);
			}
		} else {
			int i = maxPartner(n);
			if (x > deap[i]) {
				deap[n] = deap[i];
				maxInsert(i, x);
			} else {
				minInsert(n, x);
			}
		}
	}

	// Deap를 트리 형식으로 프린트한다, 구현할 필요 없음.
	public void print() {
		int levelNum = 2;
		int thisLevel = 0;
		int gap = 8;
		for (int i = 1; i <= n; i++) {
			for (int j = 0; j < gap - 1; j++) {
				System.out.print(" ");
			}
			if (thisLevel != 0) {
				for (int j = 0; j < gap - 1; j++) {
					System.out.print(" ");
				}
			}
			if (Integer.toString(deap[i]).length() == 1) {
				System.out.print(" ");
			}
			System.out.print(deap[i]);
			thisLevel++;
			if (thisLevel == levelNum) {
				System.out.println();
				thisLevel = 0;
				levelNum *= 2;
				gap /= 2;
			}
		}
		System.out.println();
		if (thisLevel != 0) {
			System.out.println();
		}
	}

	// 메인 함수 작성
	public static void main(String[] argv) {
		Deap deap = new Deap(1024);
		deap.insert(235);
		deap.insert(33);
		deap.insert(88);
		deap.insert(63);
		deap.insert(242);
		deap.insert(423);
		deap.insert(253);
		deap.insert(332);
		deap.insert(444);
		deap.insert(48);
		deap.insert(29);
		deap.insert(87);
		deap.insert(999);
		
		System.out.println("Initial Deap-------------------------------");
		deap.print();

		System.out.println("Delete Min---------------------------------");
		deap.deleteMin();
		deap.print();
		System.out.println("Delete Min---------------------------------");
		deap.deleteMin();
		deap.print();
		System.out.println("Delete Min---------------------------------");
		deap.deleteMin();
		deap.print();
		
		System.out.println("Delete Max---------------------------------");
		deap.deleteMax();
		deap.print();
		System.out.println("Delete Max---------------------------------");
		deap.deleteMax();
		deap.print();
		System.out.println("Delete Max---------------------------------");
		deap.deleteMax();
		deap.print();
		
	}
}
