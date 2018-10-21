package DS08_10;

// ���� ���� ���� ����

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
		if( tree_key == key.compareTo(this.key)) {	// ���� �� ���� ����
			System.out.println(key+": ���� ����");
			
			return false;
		}
		else if( tree_key < key.compareTo(this.key) ) {	// Ű�� > Ʈ�� Ű��
			if( this.right == null ) {
				this.right = new BST(key);
				System.out.println(key+": ���� ����");
			}
			else {
				this.right.insert(key);
			}
		}
		else if( tree_key > key.compareTo(this.key) ){	// Ű�� < Ʈ�� Ű��
			if( this.left == null) {
				this.left = new BST(key);
				System.out.println(key+": ���� ����");
			}
			else {
				this.left.insert(key);
			}
		}
		return true;
	}
	// ���� ��ȸ
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
		if( tree_key == key.compareTo(this.key) ) {	// ���� ���� ���� �� �����Ѵٴ� �޽��� ���
			System.out.println(key+": Ʈ�� �� ������");	
		}
		else if( tree_key < key.compareTo(this.key) ) {
			if( this.right == null ) {
				System.out.println(key+": Ʈ�� �� �������� ����");
				return false;
			}
			else {
				this.right.contains(key);
			}
		}
		else if( tree_key > key.compareTo(this.key) ) {
			if( this.left == null ) {
				System.out.println(key+": Ʈ�� �� �������� ����");
				return false;
			}
			else {
				this.left.contains(key);
			}
		}
		return true;
	}
}
