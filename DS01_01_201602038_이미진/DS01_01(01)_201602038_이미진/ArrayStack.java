package DS01_01_1;

public class ArrayStack implements Stack {
	private Object[] array;
	private int size;

	
	public ArrayStack(int capacity) {	// test Ŭ�������� �Է¹��� capacity�� �迭 ����
		array = new Object[capacity];
	}
	public boolean isEmpty(){	// stack �� ������� �� "Stack is empty"�� ����ϰ� stack ����� 0���� ����
		System.out.println("Stack is empty");
		return (size == 0);
	}
	public Object peek() {	// ������ top ���� ��ȯ
		if (size == 0)  return null;	// stack�� ����� 0�̸� null �� ��������
		return array[size-1];	// stack�� ����� 0�� �ƴϸ� ũ�⿡�� 1�� �� �迭 �� ����
	}
	public Object pop() {	// ������ top ���� ���� �� ��ȯ
		
		if(size == 0)	{	// stack�� ����� 0�̸� isEmpty ȣ��
			isEmpty();
		}
		// stack�� ����� 0�� �ƴϸ�
			Object object = array[--size];	// �迭�� ũ�⸦ ���̰�
			array[size] = null;	// top ���Ҹ� ��� �� object�� ����
			return object;
		}
	
	public void push(Object object) {	// stack�� ���� ����
		System.out.println("PUSH : "+object);
		if(size == array.length)	// size�� �迭�� ���̿� ��������
			resize();	// resize�� ȣ���Ͽ� �迭�� ũ�⸦ �ø�
		array[size++] = object;
	}

	public void resize() {	// �迭�� ũ�⸦ ������
		Object[] array_2 = array;	
		array = new Object[2*array_2.length];	// array�� array_2�� ���̿� 2�� ���� ��ŭ ũ�Ⱑ �þ�� �ȴ�.
		System.arraycopy(array_2, 0,array, 0, size);	// array_2�� array�� ����	
	}
	
	public int size() {	// stack�� ����� ����
		return size;
	}
	
}
