package DS01_01_2;

public class TestHeapPriorityQueue {
	public static void main(String args[]) {
		PriorityQueue queue = new HeapPriorityQueue();
		
		queue.add(1);	// queue�� 1 ����
		queue.add(2);	// queue�� 2 ����
		queue.add(3);	// queue�� 3 ����
		queue.add(4);	// queue�� 4 ����
		queue.add(5);	// queue�� 5 ����
		
		queue.removeBest();	// queue���� �ְ� �켱������ ���� ���� ���� �� ��ȯ
		
		queue.add(6);	// queue�� 6 ����
		queue.add(7);	// queue�� 7 ����
		queue.add(8);	// queue�� 8 ����
		queue.add(9);	// queue�� 9 ����
		queue.add(10);	// queue�� 10 ����
		
		while( queue.size() >= 0 ) {	// queue�� ����� 0�� �������� ���� ���� ����
			queue.removeBest();
		}
		
		
	}
}
