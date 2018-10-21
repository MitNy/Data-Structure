package DS08_10;

// 같은 값은 삽입 실패

public class BST {
	private Comparable key;
	private BST left,right;
	
	public BST(Comparable key) {
		this.key = key;
		this.left = null;
		this.right = null;
	}
	
	public boolean insert(Comparable key) {
		int tree_key = 0;
		if( tree_key == key.compareTo(this.key)) {	// 같은 값 삽입 실패
			System.out.println(key+": 삽입 실패");
			
			return false;
		}
		else if( tree_key < key.compareTo(this.key) ) {	// 키값 > 트리 키값
			if( this.right == null ) {
				this.right = new BST(key);
				System.out.println(key+": 삽입 성공");
			}
			else {
				this.right.insert(key);
			}
		}
		else if( tree_key > key.compareTo(this.key) ){	// 키값 < 트리 키값
			if( this.left == null) {
				this.left = new BST(key);
				System.out.println(key+": 삽입 성공");
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
		int tree_key = 0;
		if( tree_key == key.compareTo(this.key) ) {	// 같은 값이 있을 때 존재한다는 메시지 출력
			System.out.println(key+": 트리 내 존재함");	
		}
		else if( tree_key < key.compareTo(this.key) ) {
			if( this.right == null ) {
				System.out.println(key+": 트리 내 존재하지 않음");
				return false;
			}
			else {
				this.right.contains(key);
			}
		}
		else if( tree_key > key.compareTo(this.key) ) {
			if( this.left == null ) {
				System.out.println(key+": 트리 내 존재하지 않음");
				return false;
			}
			else {
				this.left.contains(key);
			}
		}
		return true;
	}
}
