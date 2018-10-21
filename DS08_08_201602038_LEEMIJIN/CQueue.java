package DS08_08;

public class CQueue implements Queue {
	int MAX_QUEUE_SIZE = 4;
	int front = 0; int rear = 0;
	private Object[] queueArray1 = new Object[MAX_QUEUE_SIZE];
	int CURRENT_MAX_QUEUE_SIZE;

	public void add(Object object) {
		int i = rear+1;
		if( i == front ) {
			resize();
		}
		else if ( i % queueArray1.length == 0 ) {	// rear 다음이 front일 경우 resize 함수 호출
			resize();
		}
		queueArray1[++rear] = object;	// queueArray1의 rear에 값 저장
	}
	
	public Object first() {
		return queueArray1[front];	// queueArray1의 front 값을 리턴
		
	}
	
	public Object remove() {
		int i = front+1;
		if ( i > queueArray1.length ) {
			front = i / queueArray1.length;
		}
		Object tmp = queueArray1[++front];	// 다음 frot의 값을 tmp에 저장 후 ++
		queueArray1[front] = null;
		return tmp;
	}
	
	public int size() {
		if( (front-1 == rear) || (front+MAX_QUEUE_SIZE-1 == rear) ) {
			return 0;
		}
		else if( rear >= front ) {
			return (rear-front+1);
		}
		else {
			return ((MAX_QUEUE_SIZE - front));
		}
	} 
	public void resize() {
		int qLength = queueArray1.length;
		Object[] queueArray2 = queueArray1;
		queueArray1 = new Object[queueArray2.length * 2];
		//queueArray1 배열의 크기를 2배 늘린다
		if( front <= rear) {	// 처음 인덱스부터 끝 인덱스까지 복사
			System.arraycopy( queueArray2, 0, queueArray1, 0, queueArray2.length );
		}
		else {	// 인덱스 0부터 rear까지 복사 
			System.arraycopy(queueArray2, 0, queueArray1, 0, rear+1);
			int length = queueArray2.length - front - 1;
			System.arraycopy(queueArray2, front, queueArray1, queueArray1.length-length, length);
		}
		System.out.println("Queue의 크기가"+qLength+" 에서 "+queueArray1.length+" 로 증가했습니다.");
	}
		
	public void print() {

		System.out.print("Queue : ");
		int i;
		for( i = front+1; i <= rear; i++ ) {
			
			if( i > queueArray1.length )  {
				i = i/queueArray1.length;
			}
			System.out.print(queueArray1[i]+"->");
			if( i == rear ) {	// i가 rear와 같으면 끝
				System.out.print("end\n");
			}
		}		
	}
}
