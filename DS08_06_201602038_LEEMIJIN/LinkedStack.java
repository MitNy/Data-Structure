package DS08_06;

public class LinkedStack implements Stack {
	private Node top;
	private int size;
	
	public boolean isEmpty() {
		return (size == 0);
	}
	public Object peek(){
		if( size == 0 )  return null;
		return top.object;
	}
	public Object pop() {
		if( size == 0 )  return null;
		Object oldTop = top.object;
		top = top.next;
		--size;
		return oldTop;
	}
	public void push(Object object) {
		top = new Node(object,top);
		++size;
	}
	public int size() {
		return size;
	}
	private static class Node {
		Object object;
		Node next;
		Node(Object object, Node next) {
			this.object = object;
			this.next = next;
		}
	}

	
}
