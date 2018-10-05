package DS01_01_1;


public class TestArrayStack {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);	// stack ����� 5�� ����
		
		stack.push(1);	// stack�� 1 ����
		stack.push(2);	// stack�� 2 ����
		stack.push(3);	// stack�� 3 ����
		stack.push(4);	// stack�� 4 ����
		stack.push(5);	// stack�� 5 ����
		
		System.out.println("POP : "+stack.pop());	// stack���� pop �Ͽ� �� ���� �ִ� ���Ҹ� ���� �� ��ȯ
		
		stack.push(6);	// stack�� 6 ����
		stack.push(7);	// stack�� 7 ����
		stack.push(8);	// stack�� 8 ����
		stack.push(9);	// stack�� 9 ����
		stack.push(10);	// stack�� 10 ����
		
		while( stack.size() >= 0  ) {	// stack ����� 0�� �ɶ� ���� pop ����
			System.out.println("POP : "+stack.pop());
		}
			
//		for( int i=stack.size(); i==0; --i ) {
//			System.out.println("POP : "+stack.pop());
//		}
		
	}
}
