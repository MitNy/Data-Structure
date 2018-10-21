package DS08_06;

import java.util.Random;

public class TestStack {
   public static void main(String[] args) {
      double start,end;
      Random random = new Random();
      int k = 10;
      int n,i;
      int comp=10;
      double atime, ltime;

      ArrayStack astack = new ArrayStack(10);
      LinkedStack lstack = new LinkedStack();

      //���� �ð� ����
      start = System.currentTimeMillis();
      
      //�ð��� ������ �Լ��� �ڵ带 start�� end ���̿� ��ġ
      for( n=1; n<=1000000; n++){
         int x = random.nextInt(100);   // 0~100  ������ ���� ���� ����
         if( x%k == 0 ) {   // n�� k�� ����� �� pop() ����
            astack.pop();
         }
         else {   // n�� k�� ����� �ƴϸ� push() ����
            astack.push(x);
         }
         if(comp == n){
            end = System.currentTimeMillis();
            atime = end-start;
            System.out.println("n :"+n +" || k : "+k+"\n" + "Array_Stack : "+atime+"ms");
            start = System.currentTimeMillis();      
            comp*=10;
         }
      }
      System.out.println();
      start = System.currentTimeMillis();   // ���� �ð� ����
      comp = 10;
      for( n=0; n<=1000000; n++){
         int x = random.nextInt(100);
         if( x%k == 0 ) {   // n�� k�� ����� �� pop() ����
            lstack.pop();
         }
         else {   // n�� k�� ����� �ƴϸ� push() ����
            lstack.push(x);   
         }
         if(comp == n){
            end = System.currentTimeMillis();
            ltime = end-start;
            System.out.println("n :"+n +" || k : "+k+ "\n" + "Linked_Stack : "+ltime+"ms");
            start = System.currentTimeMillis();      
            comp*=10;
         }
      }
   }
}
