package DS08_08;

public class testQueue {
	public static void main(String[] args) {
		CQueue Q = new CQueue();
	
	Q.add("A");
	Q.add("B");
	Q.add("C");
	Q.remove();
	Q.print();
	Q.add("D");
	Q.add("E");
	Q.add("F");
	Q.add("G");
	Q.add("H");
	Q.add("I");
	Q.remove();
	Q.print();
	}
}
