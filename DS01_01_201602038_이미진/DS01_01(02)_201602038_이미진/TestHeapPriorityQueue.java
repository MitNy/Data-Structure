package DS01_01_2;

public class TestHeapPriorityQueue {
	public static void main(String args[]) {
		PriorityQueue queue = new HeapPriorityQueue();
		
		queue.add(1);	// queue에 1 삽입
		queue.add(2);	// queue에 2 삽입
		queue.add(3);	// queue에 3 삽입
		queue.add(4);	// queue에 4 삽입
		queue.add(5);	// queue에 5 삽입
		
		queue.removeBest();	// queue에서 최고 우선순위를 갖는 원소 삭제 후 반환
		
		queue.add(6);	// queue에 6 삽입
		queue.add(7);	// queue에 7 삽입
		queue.add(8);	// queue에 8 삽입
		queue.add(9);	// queue에 9 삽입
		queue.add(10);	// queue에 10 삽입
		
		while( queue.size() >= 0 ) {	// queue의 사이즈가 0과 같아질때 까지 삭제 연산
			queue.removeBest();
		}
		
		
	}
}
