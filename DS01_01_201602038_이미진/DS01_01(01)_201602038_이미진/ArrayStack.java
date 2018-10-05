package DS01_01_1;

public class ArrayStack implements Stack {
	private Object[] array;
	private int size;

	
	public ArrayStack(int capacity) {	// test 클래스에서 입력받은 capacity로 배열 생성
		array = new Object[capacity];
	}
	public boolean isEmpty(){	// stack 이 비어있을 때 "Stack is empty"를 출력하고 stack 사이즈를 0으로 리턴
		System.out.println("Stack is empty");
		return (size == 0);
	}
	public Object peek() {	// 스택의 top 원소 반환
		if (size == 0)  return null;	// stack의 사이즈가 0이면 null 을 리턴해줌
		return array[size-1];	// stack의 사이즈가 0이 아니면 크기에서 1을 뺀 배열 값 리턴
	}
	public Object pop() {	// 스택의 top 원소 삭제 후 반환
		
		if(size == 0)	{	// stack의 사이즈가 0이면 isEmpty 호출
			isEmpty();
		}
		// stack의 사이즈가 0이 아니면
			Object object = array[--size];	// 배열의 크기를 줄이고
			array[size] = null;	// top 원소를 비운 후 object를 리턴
			return object;
		}
	
	public void push(Object object) {	// stack에 원소 삽입
		System.out.println("PUSH : "+object);
		if(size == array.length)	// size가 배열의 길이와 같아지면
			resize();	// resize를 호출하여 배열의 크기를 늘림
		array[size++] = object;
	}

	public void resize() {	// 배열의 크기를 재조정
		Object[] array_2 = array;	
		array = new Object[2*array_2.length];	// array는 array_2의 길이에 2를 곱한 만큼 크기가 늘어나게 된다.
		System.arraycopy(array_2, 0,array, 0, size);	// array_2에 array를 복사	
	}
	
	public int size() {	// stack의 사이즈를 리턴
		return size;
	}
	
}
