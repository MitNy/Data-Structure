package DS01_09_201602038;

import java.util.ArrayList;
import java.util.Collections;

public class TestMain {
	public static void main(String args[]) {
	long start,end;
	ArrayList<Object> arrayl = new ArrayList<>();
	BinarySearchTree bst;
	QuadraticProbingHashTable qph = new QuadraticProbingHashTable();
	AVLTree avl;

	int i;
	int n=10000;
	for( ;n<10000000; ){ // n이 10000, 100000, 1000000 일 동안 반복
		int[] arrayi = new int[n];

		System.out.println("n = "+n);
		System.out.println("***** Insert *****");
		
		for( i = 0; i < n; i++ ) {
			arrayl.add(i);
		}
		Collections.shuffle(arrayl);	// 무작위 추출
		for( i = 0; i < n; i++ ) {
			arrayi[i]= (int) arrayl.get(i);
		}

		/* bst Insert start */
		start = System.currentTimeMillis();
		bst = new BinarySearchTree((Comparable<?>) arrayl.get(0));
		
		for( i = 0; i < n; i++ ) {
			bst.insert(arrayi[i]);
		}
		end = System.currentTimeMillis();
		
		System.out.println("BST insert : "+(end-start)+"ms");
		/* bst Insert end */
		/* qph Insert start */
		start = System.currentTimeMillis();
		
		for(i = 0; i < n; i++) {
			qph.put(arrayi[i], arrayi[i]);
		}
		end = System.currentTimeMillis();

		System.out.println("QPH insert : "+(end-start)+"ms");
		/* qph Insert end */
		
		/* avl Insert start */
		start = System.currentTimeMillis();
		
		avl = new AVLTree((int) arrayl.get(0));
		
		for( i = 1; i < n; i++ ) {
			avl.grow(arrayi[i]);
		}
	
		end = System.currentTimeMillis();

		System.out.println("AVL insert : "+(end-start)+"ms\n");
		/* avl Insert end */
		System.out.println("***** Search *****");
		
		/* bst Search start */
		start = System.currentTimeMillis();
		
		for( i = 0; i < n; i++ ) {
			bst.contains(i);
		}
		end = System.currentTimeMillis();
		
		System.out.println("BST Search : "+(end-start)+"ms");
		/* bst Search end */
		/* qph Search start */
		start = System.currentTimeMillis();
		
		for( i = 0; i < n; i++ ) {
			qph.get(i);
		}
		end = System.currentTimeMillis();
		System.out.println("QPH Search : "+(end-start)+"ms");
		/* qph Search end */
		/* avl Search start */
		start = System.currentTimeMillis();
		
		for( i= 0; i < n; i++ ) {
			avl.search(i);
		}
		
		end = System.currentTimeMillis();
		
		System.out.println("AVL Search : "+(end-start)+"ms\n");
		/* avl Search end */
		n = n*10;
	}
}
}
