package DS08_05;

// �Է����� �������� �־����� ��, ������ -> ���������� ��ȯ�ϰ�
// ��ȯ�� �������� ����Ͽ� ����� ���



// infix2Postfix() , printPostfix() �޼ҵ� �߰�
public class RPN {
	private Stack stack;
	
	//intfix�� ���̸� ���� ������ ���� �� �ʱ� ���� ����
	public RPN(int argsLength) {
		this.stack = new ArrayStack(argsLength);
	}
	
	// �������� �Է¹޾Ƽ� ����ϴ� �޼ҵ�, �������� ��Ʈ�� �迭 ���·� �Ѱ������.
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
	
	// �����ڸ� ���ĺ����� ��ȯ�ϴ� �޼ҵ�
	private boolean IsAnOperator(String s) {
		return (s.length() == 1 && "ASMD".indexOf(s) >= 0);
	}
	
	//�����ڿ� ���� ����� �ϴ� �޼ҵ�
	private double evaluate(double x, double y, String op ) {
		double z = 0;
		
		if( op.equals("A"))	// op�� A�� ���� ���
			z = x + y;	// ���� ����
		else if( op.equals("S"))	// op�� S�� ���� ���
			z = x - y;	// ���� ����
		else if( op.equals("M"))	// op�� M�� ���� ���
			z = x * y;	// ���� ����
		else	// op�� D�� ���
			z = x / y;	// ������ ����
		
		System.out.println(x+" "+op+" "+y+" = "+z);
		return z;
	}
	//������ �켱����

	// �Է¹��� �������� ���������� ��ȯ�ϴ� �޼ҵ� �ۼ�
	public String[] infix2Postfix(String[] infix) {
		ArrayStack stack = new ArrayStack(infix.length);	// stack ��ü�� infix�� ���̸�ŭ

		String[] exp = infix;
		String str, top;
		
		for( int i=0; i< exp.length; i++ ) {	// i�� 0���� exp�� ���̱��� 1�� ����
			str = exp[i];
			
			switch (str) {
			case "A" : case "S" : case "M" : case "D":	// str�� A,S,M,D�� ��� 
					System.out.print(stack.pop());	// stack�� pop �޼ҵ� ȣ��
				stack.push(str);	// �ٽ� stack�� str�� ���� ����
				break;	 //����
			case "(" :	// str�� ( �� ���
				stack.push(str);	// stack�� push �޼ҵ� ȣ�� 
				break;	// ����
					
			case ")" :	// str�� ) �� ���	
				top = (String)stack.pop();	// ���� ���� �ִ� top�� stack�� pop �޼ҵ带 �������� �� ������ String Ÿ���� ����
				
				while( top != "(" ) { // top�� ( �ƴ� ���
					System.out.print(top);	// top�� ���
					top = (String)stack.pop();	// top�� String Ÿ���� pop �޼ҵ� �������� �� ������ ����
				}
				break;	// ����
			default :	// A,S,M,D,(,) �� �ƴҰ�� 
				System.out.print(str);	// str ���
				break;	// ����
			}
		}
		while( !(stack.isEmpty()))	// stack�� ������� ���� ���
			System.out.print(stack.pop());	// stack�� pop �޼ҵ� ȣ��
		return null;
		}		

	// �������� ����ϴ� �޼ҵ� �ۼ�
	public void printPostfix() {
		System.out.println("�Էµ� ������ : (( 8 S 5 ) M ( 44 A ( 35 D 7 ) ) )");
		System.out.println("������ : 8 5 S 44 35 7 D A M");
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
		RPN rpn1 = new RPN(infix1.length);	// RPN Ŭ������ �����ϰ�, infix�� ���̸�ŭ �ʱ� ���� ����
		RPN rpn2 = new RPN(infix2.length);
		//postfix3 = rpn1.infix2Postfix(infix2);
	
		
		
		System.out.println();
		rpn1.printPostfix();	// ��ȯ�� ������ ���
		System.out.println();
		
		System.out.print("������ ��� : ");
		rpn1.run(postfix1);	// ������ ��� ���
		System.out.print("������ ��� : ");
		rpn2.run(postfix2);
	}
	
	
}
