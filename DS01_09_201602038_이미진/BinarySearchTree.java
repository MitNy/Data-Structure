package DS01_09_201602038;

public class BinarySearchTree {
	private Comparable key;
	private BinarySearchTree left,right;
	
	public BinarySearchTree(Comparable key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public boolean insert(Comparable key) {
		if( 0 == key.compareTo(this.key)) {	// 같은 값 삽입 실패
			//System.out.println(key+": 삽입 실패");
			
			return false;
		}
		else if( 0 < key.compareTo(this.key) ) {	// 키값 > 트리 키값
			if( this.right == null ) {
				this.right = new BinarySearchTree(key);
				//System.out.println(key+": 삽입 성공");
			}
			else {
				this.right.insert(key);
			}
		}
		else if( 0 > key.compareTo(this.key) ){	// 키값 < 트리 키값
			if( this.left == null) {
				this.left = new BinarySearchTree(key);
				//System.out.println(key+": 삽입 성공");
			}
			else {
				this.left.insert(key);
			}
		}
		return true;
	}
	// 중위 순회
	public void inorder() {
		if( this.left != null ) {
			this.left.inorder();
		}
		System.out.print(this.key+" ");
		
		if( this.right != null ) {
			this.right.inorder();
		}
	}
	
	public boolean contains(Comparable key) {
		if( 0 == key.compareTo(this.key) ) {
			//System.out.println(key+": 트리 내 존재함");	
		}
		else if( 0 < key.compareTo(this.key) ) {
			if( this.right == null ) {
			//	System.out.println(key+": 트리 내 존재하지 않음");
				return false;
			}
			else {
				this.right.contains(key);
			}
		}
		else if( 0 > key.compareTo(this.key) ) {
			if( this.left == null ) {
			//	System.out.println(key+": 트리 내 존재하지 않음");
				return false;
			}
			else {
				this.left.contains(key);
			}
		}
		return true;
	}
}
