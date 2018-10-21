package DS08_12;
import java.util.*;

public class minHeap {
	int heap[];
	
	public minHeap(int[] a) {
		this.heap = new int[a.length];
	}
	
	// 부모 노드 : (i-1)/2
	// 왼쪽 자식 노드 : 2i+1
	// 오른쪽 자식 노드 : 2i+2
	
	// 순환적으로 작성, heapify()를 호출할 때 루트 노드의 인덱스를 프린트
	public void build_recu_min_heap(int[] a,int i, int n) {
		int single_tree = n/2;
		
		if( i >= single_tree ) {
			return;
		}
 		build_recu_min_heap(a, 2*i+1, n);
 		build_recu_min_heap(a, 2*i+2, n);
 		heapify(a, i, n);
 		heap = a;
		
	}
	
	// 반복적으로 작성, heapify()를 호출할 때 루트 노드의 인덱스를 프린트
	public void build_iter_min_heap(int[] a,int n) {
		int single_tree = n/2;
		for( int i=single_tree-1; i>=0; i-- ) {
			heapify(a,i,n);
		}
		heap = a;
	}
	
	public void heapify(int[] a,int i, int n) {
		System.out.print(i+" ");
		int heapi = a[i];
		int single_tree = n/2;
		
		while( i < single_tree ) {
			int left_child = 2*i+1;
			
			if( left_child+1 < n && a[left_child+1] < a[left_child]) {
				++left_child;
			}
			if( a[left_child] >= heapi ) {
				break;
			}
			a[i] = a[left_child];
			i = left_child;
		}
		a[i] = heapi;
	}
	
	// 레벨순서 순회로 방문
	public void level_order() {
		for( int i=0; i< heap.length; i++ ) {
			System.out.print(this.heap[i]+" ");
		}
	}
	
	
}
