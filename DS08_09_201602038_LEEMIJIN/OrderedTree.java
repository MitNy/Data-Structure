package DS08_09;

import java.util.*;

public class OrderedTree {
	private Object root;
	private List<OrderedTree> subtrees;
	private int size;
	
	public OrderedTree(){}
	
	public OrderedTree(Object root){
		this.root = root;
		subtrees = new LinkedList<OrderedTree>();
		size = 1;
	}
	
	public OrderedTree(Object root, List<OrderedTree> trees){
		this(root);
		for( Iterator<OrderedTree> i=trees.iterator(); i.hasNext(); ){
			Object next = i.next();
			if(next instanceof OrderedTree){
				OrderedTree tree = (OrderedTree)next;
				subtrees.add(tree);
				size = tree.size++;
			}
		}
	}
	
	public int size(){	// size �� ����
		return size;
	}
	
	public void levelOrder(OrderedTree root){
		// ���� ���� ��ȸ
		Queue queue = new Queue();
		queue.add(root);
		
		while( queue.size != 0 ){	// ť�� ũ�Ⱑ 0�� �ƴϸ� ��� �ݺ�
			OrderedTree ot= (OrderedTree)queue.remove();

				System.out.print(ot.root);

				if( queue.size == 0 ) {
					if( queue.size == queue.front) {
					System.out.print(",");
					}
					else System.out.println(" ");
				}
				else System.out.print(",");

			for( Iterator<OrderedTree> i=ot.subtrees.iterator(); i.hasNext(); ){
				Object next = i.next();
				if( next instanceof OrderedTree ){
					OrderedTree tree = (OrderedTree)next;
					queue.add(tree);
				}
			}
		}
	}
}