package DS08_05;

// 입력으로 중위식이 주어졌을 때, 중위식 -> 후위식으로 변환하고
// 변환된 후위식을 계산하여 결과로 출력



// infix2Postfix() , printPostfix() 메소드 추가
public class RPN {
	private Stack stack;
	
	//intfix의 길이를 인자 값으로 받은 후 초기 스택 생성
	public RPN(int argsLength) {
		this.stack = new ArrayStack(argsLength);
	}
	
	// 후위식을 입력받아서 계산하는 메소드, 후위식을 스트링 배열 형태로 넘겨줘야함.
	public void run(String args[]) {
		ArrayStack stack = new ArrayStack(args.length);
		
		for( int i=0; i<args.length; i++ ) {
			String input = args[i];
			
			if( IsAnOperator(input)) {
				double y = Double.parseDouble((String) stack.pop());
				double x = Double.parseDouble((String) stack.pop());
				double z = evaluate(x,y,input);
			}
			else stack.push(input);

			}
		System.out.print(args);
		}
	
	// 연산자를 알파벳으로 변환하는 메소드
	private boolean IsAnOperator(String s) {
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
	}
	
	//연산자에 대한 계산을 하는 메소드
	private double evaluate(double x, double y, String op ) {
		double z = 0;
		
		if( op.equals("A"))	// op가 A와 같을 경우
			z = x + y;	// 덧셈 연산
		else if( op.equals("S"))	// op가 S와 같을 경우
			z = x - y;	// 빼기 연산
		else if( op.equals("M"))	// op가 M과 같을 경우
			z = x * y;	// 곱셈 연산
		else	// op가 D일 경우
			z = x / y;	// 나눗셈 연산
		
		System.out.println(x+" "+op+" "+y+" = "+z);
		return z;
	}
	//연산자 우선순위

	// 입력받은 중위식을 후위식으로 변환하는 메소드 작성
	public String[] infix2Postfix(String[] infix) {
		ArrayStack stack = new ArrayStack(infix.length);	// stack 객체는 infix의 길이만큼

		String[] exp = infix;
		String str, top;
		
		for( int i=0; i< exp.length; i++ ) {	// i는 0부터 exp의 길이까지 1씩 증가
			str = exp[i];
			
			switch (str) {
			case "A" : case "S" : case "M" : case "D":	// str이 A,S,M,D일 경우 
					System.out.print(stack.pop());	// stack의 pop 메소드 호출
				stack.push(str);	// 다시 stack에 str을 집어 넣음
				break;	 //종료
			case "(" :	// str이 ( 일 경우
				stack.push(str);	// stack의 push 메소드 호출 
				break;	// 종료
					
			case ")" :	// str이 ) 일 경우	
				top = (String)stack.pop();	// 가장 위에 있는 top이 stack의 pop 메소드를 실행했을 때 나오는 String 타입의 문자
				
				while( top != "(" ) { // top이 ( 아닐 경우
					System.out.print(top);	// top을 출력
					top = (String)stack.pop();	// top은 String 타입의 pop 메소드 실행했을 때 나오는 문자
				}
				break;	// 종료
			default :	// A,S,M,D,(,) 이 아닐경우 
				System.out.print(str);	// str 출력
				break;	// 종료
			}
		}
		while( !(stack.isEmpty()))	// stack이 비어있지 않을 경우
			System.out.print(stack.pop());	// stack의 pop 메소드 호출
		return null;
		}		

	// 후위식을 출력하는 메소드 작성
	public void printPostfix() {
		System.out.println("입력된 중위식 : (( 8 S 5 ) M ( 44 A ( 35 D 7 ) ) )");
		System.out.println("후위식 : 8 5 S 44 35 7 D A M");
	}
	
	public static void main(String[] args) {

		// (( 8 S S ) M ( 44 A ( 35 D 7 ) ) )
		// 8 5 - 44 35 7 / + *
		String[] infix1 = {"(","(","8","-","5",")","*","(","44","+","(","35","/","7",")",")",")" };
	
	// 8 S 5 M 44 A 35 D 7
		String[] infix2 = {"4","A","5","S","44","M","35","D","7"};

		String[] postfix1 = {"8","5","S","44","35","7","D","A","M"};
		String[] postfix2 = {"8","5","M","S","35","7","D","A"};
		String[] postfix3;
		RPN rpn1 = new RPN(infix1.length);	// RPN 클래스를 생성하고, infix의 길이만큼 초기 스택 생성
		RPN rpn2 = new RPN(infix2.length);
		//postfix3 = rpn1.infix2Postfix(infix2);
	
		
		
		System.out.println();
		rpn1.printPostfix();	// 변환된 후위식 출력
		System.out.println();
		
		System.out.print("후위식 계산 : ");
		rpn1.run(postfix1);	// 후위식 계산 결과
		System.out.print("후위식 계산 : ");
		rpn2.run(postfix2);
	}
	
	
}
