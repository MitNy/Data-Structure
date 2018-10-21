package DS08_09;

public class Queue {
	private static int MAX_QUEUE_SIZE = 100;
	private Object[] queueArray = new Object[MAX_QUEUE_SIZE];
	int front = -1;
	int rear = -1;
	int size = 0;
	
	public void add(Object object) {
		queueArray[++rear] = object;
		size++;
	}
	
	public int size() {
		return size;
	}
	
	public Object first() {
		return queueArray[front];
	}
	
	public Object remove() {
		front++;
		Object tmp = first();
		queueArray[front] = null;
		size--;
		
		return tmp;
	}
}
