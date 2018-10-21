package DS08_10;

public class TestBST {
	public static void main(String[] args) {
	BST bst1 = new BST("B");
	
	System.out.println("======== »ğÀÔ ========");
	bst1.insert("G");
	bst1.insert("D");
	bst1.insert("K");
	bst1.insert("A");
	bst1.insert("D");
	bst1.insert("J");
	bst1.insert("H");
	bst1.insert("C");
	bst1.insert("A");
	bst1.insert("F");
	bst1.insert("E");
	bst1.insert("N");
	
	System.out.println("======== Å½»ö ========");
	bst1.contains("A");
	bst1.contains("M");
	bst1.contains("H");
	
	System.out.println("======== ¼øÈ¸ ========");
	bst1.inorder();
	
	}
}