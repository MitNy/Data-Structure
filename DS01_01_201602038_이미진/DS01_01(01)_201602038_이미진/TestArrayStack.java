package DS01_01_1;


public class TestArrayStack {
	public static void main(String[] args) {
		ArrayStack stack = new ArrayStack(5);	// stack 사이즈를 5로 정함
		
		stack.push(1);	// stack에 1 삽입
		stack.push(2);	// stack에 2 삽입
		stack.push(3);	// stack에 3 삽입
		stack.push(4);	// stack에 4 삽입
		stack.push(5);	// stack에 5 삽입
		
		System.out.println("POP : "+stack.pop());	// stack에서 pop 하여 맨 위에 있는 원소를 삭제 후 반환
		
		stack.push(6);	// stack에 6 삽입
		stack.push(7);	// stack에 7 삽입
		stack.push(8);	// stack에 8 삽입
		stack.push(9);	// stack에 9 삽입
		stack.push(10);	// stack에 10 삽입
		
		while( stack.size() >= 0  ) {	// stack 사이즈가 0이 될때 까지 pop 수행
			System.out.println("POP : "+stack.pop());
		}
			
//		for( int i=stack.size(); i==0; --i ) {
//			System.out.println("POP : "+stack.pop());
//		}
		
	}
}
