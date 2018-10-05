package DS01_08_201602038;

public class AVLTree {
	private int key, height;
	private AVLTree left, right;
	public static final AVLTree NIL = new AVLTree();
	
	public AVLTree(int key){	// AVL 트리 생성자
		this.key = key;
		left = right = NIL;
	}
	private AVLTree(){	// AVL 트리 생성자
		left = right = this;
		height = -1;
	}
	private AVLTree(int key, AVLTree left, AVLTree right){
		this.key = key;
		this.left = left;
		this.right = right;
		height = 1 + Math.max(left.height, right.height);
	}
	public boolean add(int key){	// AVL 트리 삽입 메소드
		int oldSize = size(); //성공하면 true 리턴
		grow(key);
		return size() > oldSize;
	}
	public AVLTree grow(int key){	// AVL 트리 확장 메소드
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
	public String toString(){	// AVL 트리 프린트 메소드
		if ( this.search(key) == false ) return "";
		int bf = left.height - right.height;
		return left + "(" + this.key + "," + bf + ") " + right;
	}
	private void rebalance(){	// AVL 트리 재정렬 메소드
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
	private void rotateLeft(){ // AVL Left rotate 메소드 
		left = new AVLTree(key, left, right.left);
		key = right.key;
		right = right.right;
	}
	private void rotateRight(){ // AVL Right rotate 메소드
		right = new AVLTree(key, left.right, right);
		key = left.key;
		left = left.left;
	}
	
	public AVLTree remove(int key){	// AVL 트리 삭제 메소드
		if ( this.search(key) == false ) return NIL;	// remove 하려는 것이 존재하지 않을 경우
		
		if ( key == this.key ) {	// key가 현재 key일 경우
			if( left == NIL ) {	// 오른쪽 자식만 존재할 경우
				if( right != NIL) {
					this.key = right.key;
					
					if( right.left != NIL ) {
						left = right.left;
					}
					else if( right.right != NIL ) {
						right = right.right;
					}
					else this.right = NIL;
					rebalance();	// rebalance 메소드 호출
				}
				else return NIL;// reaf 노드이면 NIL return
			}
			else if( left != NIL ) {	// 왼쪽 자식만 존재할 경우
				if( right == NIL ) {
					this.key = left.key;

					if( left.left != NIL ) {
						left = left.left;
					}
					else if( left.right != NIL ) {
						right = left.right;
					}
					else this.left = NIL;
					rebalance();	// rebalance 메소드 호출
				}
				else this.key = removeCyc();
			}
			return this;
		}
		else if ( key < this.key ){	// 삭제하려는 key가 현재 key보다 작을 경우
			left = left.remove(key);	// 왼쪽자식 remove
		}
		else if( key > this.key ) {
			right = right.remove(key);	// 오른쪽자식 remove
		}
		rebalance();	// rebalance 메소드 호출
		height = 1 + Math.max( left.height, right.height );	// 높이 업데이트
		
		return this;
	}
	
	private int removeCyc() {	// 순환적인 remove
		AVLTree parent = this;	// 부모 노드

		if( right.left != NIL && right.right == NIL ) {
			parent = parent.right;	// parent 노드를 후속자의 부모 노드로 이동시킴
			right = right.left;	// 후속자를 왼쪽 자식으로 이동
				
			for( ; right.left != NIL; ) {	// 후속자를 마지막 왼쪽 자식으로 만듦
				right = right.left;
				parent = parent.left;
			}
			
			this.key = right.key;
			parent.left = NIL;	// 후속자를 NIL로 설정
		}
		else if( right.left != NIL && right.right != NIL ) {
			parent = parent.right;	// parent 노드를 후속자의 부모 노드로 이동시킴
			right = right.left;	// 후속자를 왼쪽 자식으로 이동

			for( ; right.left != NIL; ) {	// 후속자를 마지막 왼쪽 자식으로 만듦
				right = right.left;
				parent = parent.left;
			}
			
			this.key = right.key;	
			parent.left.key = right.right.key;
			parent.left = right.right;		
		}
		else if( (right.left == NIL && right.right == NIL) || (right.left == NIL && right.right != NIL) ){
			// 후속자에 왼쪽 자식이 없을 경우
			this.key = right.key;
			this.right = right.right;
			return this.key;
		}
		return this.key;
	}
	
	public boolean search(int key){	// AVL 트리 검색 메소드		
		if( this == NIL ) return false; // search fail
		else {
			if( key == this.key ) return true;	// search success
			if( key < this.key ) return left.search(key);	// 찾은 key가 현재 key보다 작을 경우 left search
			if( key > this.key ) return right.search(key);	// 찾은 key가 현재 key보다 클 경우 right search
		}
		return true;
	}
}