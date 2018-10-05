package DS01_08_201602038;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(int key){	// AVL Ʈ�� ������
		this.key = key;
		left = right = NIL;
	}
	private AVLTree(){	// AVL Ʈ�� ������
		left = right = this;
		height = -1;
	}
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}
	public boolean add(int key){	// AVL Ʈ�� ���� �޼ҵ�
		int oldSize = size(); //�����ϸ� true ����
		grow(key);
		return size() > oldSize;
	}
	public AVLTree grow(int key){	// AVL Ʈ�� Ȯ�� �޼ҵ�
		if (this == NIL) return new AVLTree(key);
		if (key == this.key) return this; // prevent key duplication
		if (key < this.key) left = left.grow(key);
		else right = right.grow(key);
		
		rebalance();
		height = 1 + Math.max( left.height, right.height );
		return this;
	}
	public int size(){
		if ( this == NIL ) return 0;
		return 1 + left.size() + right.size();
	}
	public String toString(){	// AVL Ʈ�� ����Ʈ �޼ҵ�
		if ( this.search(key) == false ) return "";
		int bf = left.height - right.height;
		return left + "(" + this.key + "," + bf + ") " + right;
	}
	private void rebalance(){	// AVL Ʈ�� ������ �޼ҵ�
		if ( right.height > left.height+1 ){
			if( right.left.height > right.right.height )
				right.rotateRight();
			rotateLeft();
		}
		else if( left.height > right.height+1 ){
			if( left.right.height > left.left.height )
				left.rotateLeft();
			rotateRight();
		}
	}
	private void rotateLeft(){ // AVL Left rotate �޼ҵ� 
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}
	private void rotateRight(){ // AVL Right rotate �޼ҵ�
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
	
	public AVLTree remove(int key){	// AVL Ʈ�� ���� �޼ҵ�
		if ( this.search(key) == false ) return NIL;	// remove �Ϸ��� ���� �������� ���� ���
		
		if ( key == this.key ) {	// key�� ���� key�� ���
			if( left == NIL ) {	// ������ �ڽĸ� ������ ���
				if( right != NIL) {
					this.key = right.key;
					
					if( right.left != NIL ) {
						left = right.left;
					}
					else if( right.right != NIL ) {
						right = right.right;
					}
					else this.right = NIL;
					rebalance();	// rebalance �޼ҵ� ȣ��
				}
				else return NIL;// reaf ����̸� NIL return
			}
			else if( left != NIL ) {	// ���� �ڽĸ� ������ ���
				if( right == NIL ) {
					this.key = left.key;

					if( left.left != NIL ) {
						left = left.left;
					}
					else if( left.right != NIL ) {
						right = left.right;
					}
					else this.left = NIL;
					rebalance();	// rebalance �޼ҵ� ȣ��
				}
				else this.key = removeCyc();
			}
			return this;
		}
		else if ( key < this.key ){	// �����Ϸ��� key�� ���� key���� ���� ���
			left = left.remove(key);	// �����ڽ� remove
		}
		else if( key > this.key ) {
			right = right.remove(key);	// �������ڽ� remove
		}
		rebalance();	// rebalance �޼ҵ� ȣ��
		height = 1 + Math.max( left.height, right.height );	// ���� ������Ʈ
		
		return this;
	}
	
	private int removeCyc() {	// ��ȯ���� remove
		AVLTree parent = this;	// �θ� ���

		if( right.left != NIL && right.right == NIL ) {
			parent = parent.right;	// parent ��带 �ļ����� �θ� ���� �̵���Ŵ
			right = right.left;	// �ļ��ڸ� ���� �ڽ����� �̵�
				
			for( ; right.left != NIL; ) {	// �ļ��ڸ� ������ ���� �ڽ����� ����
				right = right.left;
				parent = parent.left;
			}
			
			this.key = right.key;
			parent.left = NIL;	// �ļ��ڸ� NIL�� ����
		}
		else if( right.left != NIL && right.right != NIL ) {
			parent = parent.right;	// parent ��带 �ļ����� �θ� ���� �̵���Ŵ
			right = right.left;	// �ļ��ڸ� ���� �ڽ����� �̵�

			for( ; right.left != NIL; ) {	// �ļ��ڸ� ������ ���� �ڽ����� ����
				right = right.left;
				parent = parent.left;
			}
			
			this.key = right.key;	
			parent.left.key = right.right.key;
			parent.left = right.right;		
		}
		else if( (right.left == NIL && right.right == NIL) || (right.left == NIL && right.right != NIL) ){
			// �ļ��ڿ� ���� �ڽ��� ���� ���
			this.key = right.key;
			this.right = right.right;
			return this.key;
		}
		return this.key;
	}
	
	public boolean search(int key){	// AVL Ʈ�� �˻� �޼ҵ�		
		if( this == NIL ) return false; // search fail
		else {
			if( key == this.key ) return true;	// search success
			if( key < this.key ) return left.search(key);	// ã�� key�� ���� key���� ���� ��� left search
			if( key > this.key ) return right.search(key);	// ã�� key�� ���� key���� Ŭ ��� right search
		}
		return true;
	}
}