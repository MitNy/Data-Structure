package DS08_12;

/*
 * (1) a={3, 1, 5, 9, 6, 4, 8, 0, 2, 7}�� build_recu_min_heap()�� �̿��Ͽ� minheap���� �����ϰ� �������� ��ȸ �湮
 * (2) a={3, 1, 5, 9, 6, 4, 8, 0, 2, 7}�� build_iter_min_heap()�� �̿��Ͽ� minheap���� �����ϰ� �������� ��ȸ �湮
*/
public class testMinHeap {
	public static void main(String[] args) {
		int[] a = {3,1,5,9,6,4,8,0,2,7};
		minHeap recu_min_heap = new minHeap(a);	// ��ȯ�� minHeap ��ü
		minHeap iter_min_heap = new minHeap(a);	// �ݺ��� minHeap ��ü
		
		System.out.println("===== ��ȯ�� minHeap =====");
		System.out.print("Heapify �޼ҵ� ȣ�� Index : ");
		recu_min_heap.build_recu_min_heap(a,0, a.length);
		System.out.println();
		System.out.print("level-order : ");
		recu_min_heap.level_order();

		System.out.println();
		System.out.println("\n===== �ݺ��� minHeap =====");
		System.out.print("Heapify �޼ҵ� ȣ�� Index : ");
		iter_min_heap.build_iter_min_heap(a,a.length);
		System.out.println();
		System.out.print("level-order : ");
		iter_min_heap.level_order();
		
		
			
	}
		
}