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
		if( 0 == key.compareTo(this.key)) {	// ���� �� ���� ����
			//System.out.println(key+": ���� ����");
			
			return false;
		}
		else if( 0 < key.compareTo(this.key) ) {	// Ű�� > Ʈ�� Ű��
			if( this.right == null ) {
				this.right = new BinarySearchTree(key);
				//System.out.println(key+": ���� ����");
			}
			else {
				this.right.insert(key);
			}
		}
		else if( 0 > key.compareTo(this.key) ){	// Ű�� < Ʈ�� Ű��
			if( this.left == null) {
				this.left = new BinarySearchTree(key);
				//System.out.println(key+": ���� ����");
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
		if( 0 == key.compareTo(this.key) ) {
			//System.out.println(key+": Ʈ�� �� ������");	
		}
		else if( 0 < key.compareTo(this.key) ) {
			if( this.right == null ) {
			//	System.out.println(key+": Ʈ�� �� �������� ����");
				return false;
			}
			else {
				this.right.contains(key);
			}
		}
		else if( 0 > key.compareTo(this.key) ) {
			if( this.left == null ) {
			//	System.out.println(key+": Ʈ�� �� �������� ����");
				return false;
			}
			else {
				this.left.contains(key);
			}
		}
		return true;
	}
}
