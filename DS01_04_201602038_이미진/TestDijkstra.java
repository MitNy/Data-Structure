package DS01_04_201602038;
import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestDijkstra {
	public static void main(String[] args) throws IOException {
		String[] vertices;
		String[] ssp;
		String string;
		
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://input.txt")));
			int size = Integer.parseInt(br.readLine());	// readLine으로 파일 내용을 한 줄 읽어 size에 저장한다. 저장된 내용은 정점의 수.
			vertices = new String[size];	// vertices를 size만큼 생성
			
			for( int i=0; i<size; i++ ) {	// input.txt 파일로부터 배열 생성
				vertices[i] = br.readLine();	// 한 줄씩 읽어들여 vertices 배열에 순서대로 저장한다.
			}
			
			WeightedGraph graph = new WeightedGraph(vertices);	// vertices로 graph 객체 생성
			string = br.readLine();
			
			for( ; string!=null; ) {	// string이 null이 아닐때
				ssp = string.split(" ");	// 공백 문자로 문자열을 나눠서 ssp 변수에 저장
				String i = ssp[0];
				String j = ssp[1];
				string = br.readLine();
				graph.add(i, j, Integer.parseInt(ssp[2]));

			}
			graph.dijkstra(0);	// dijkstra 메소드 호출
			graph.printPaths();	// printPaths 메소드 호출
			
			br.close();	// 파일 close
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}	
 