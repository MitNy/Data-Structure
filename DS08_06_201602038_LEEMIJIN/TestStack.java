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

      //시작 시간 측정
      start = System.currentTimeMillis();
      
      //시간을 측정할 함수나 코드를 start와 end 사이에 위치
      for( n=1; n<=1000000; n++){
         int x = random.nextInt(100);   // 0~100  사이의 랜덤 정수 생성
         if( x%k == 0 ) {   // n이 k의 배수일 때 pop() 수행
            astack.pop();
         }
         else {   // n이 k의 배수가 아니면 push() 실행
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
      start = System.currentTimeMillis();   // 시작 시간 측정
      comp = 10;
      for( n=0; n<=1000000; n++){
         int x = random.nextInt(100);
         if( x%k == 0 ) {   // n이 k의 배수일 때 pop() 수행
            lstack.pop();
         }
         else {   // n이 k의 배수가 아니면 push() 실행
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
