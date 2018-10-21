package DS08_12;

/*
 * (1) a={3, 1, 5, 9, 6, 4, 8, 0, 2, 7}를 build_recu_min_heap()를 이용하여 minheap으로 구축하고 레벨순서 순회 방문
 * (2) a={3, 1, 5, 9, 6, 4, 8, 0, 2, 7}를 build_iter_min_heap()를 이용하여 minheap으로 구축하고 레벨순서 순회 방문
*/
public class testMinHeap {
	public static void main(String[] args) {
		int[] a = {3,1,5,9,6,4,8,0,2,7};
		minHeap recu_min_heap = new minHeap(a);	// 순환적 minHeap 객체
		minHeap iter_min_heap = new minHeap(a);	// 반복적 minHeap 객체
		
		System.out.println("===== 순환적 minHeap =====");
		System.out.print("Heapify 메소드 호출 Index : ");
		recu_min_heap.build_recu_min_heap(a,0, a.length);
		System.out.println();
		System.out.print("level-order : ");
		recu_min_heap.level_order();

		System.out.println();
		System.out.println("\n===== 반복적 minHeap =====");
		System.out.print("Heapify 메소드 호출 Index : ");
		iter_min_heap.build_iter_min_heap(a,a.length);
		System.out.println();
		System.out.print("level-order : ");
		iter_min_heap.level_order();
		
		
			
	}
		
}