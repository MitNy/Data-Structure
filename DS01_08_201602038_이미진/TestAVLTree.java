package DS01_08_201602038;

public class TestAVLTree {
	public static void main(String args[]) {
	AVLTree avl = new AVLTree(1);
	avl.grow(2);
	avl.grow(3);
	avl.grow(4);
	avl.grow(5);
	avl.grow(6);
	avl.grow(7);
	avl.grow(8);
	avl.grow(9);
	avl.grow(10);
	System.out.println("***** Search *****");
	System.out.println("1 �˻���� : " + avl.search(1));
	System.out.println("3 �˻���� : " + avl.search(3));
	System.out.println("5 �˻���� : " + avl.search(5));
	System.out.println("11 �˻���� : " + avl.search(11));
	System.out.println();
	// Remove
	System.out.println("***** Remove *****");
	avl.remove(1);
	System.out.println("1 ����");
	System.out.println(avl);
	avl.remove(3);
	System.out.println("3 ����");
	System.out.println(avl);
	avl.remove(5);
	System.out.println("5 ����");
	System.out.println(avl);
	avl.remove(11);
	System.out.println("11 ����");
	System.out.println(avl);
	}
}