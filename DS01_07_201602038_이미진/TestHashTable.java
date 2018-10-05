package DS01_07_201602038;

import java.io.*;
import java.util.StringTokenizer;

public class TestHashTable{
	public static void main(String[] args) throws IOException {
		LinearProbingHashTable linearHash = new LinearProbingHashTable();
		DoubleHashingHashTable DoubleHash = new DoubleHashingHashTable();
		QuadraticProbingHashTable quadHash = new QuadraticProbingHashTable();
		
		try{
			BufferedReader br = new BufferedReader(new FileReader("C://Caesar.txt"));
			String line = br.readLine();
			while(line != null){
				StringTokenizer parser = new StringTokenizer(line, " .,:;-'?!");
			
				while( parser.hasMoreTokens() ) {
					String word = parser.nextToken().toUpperCase();
					linearHash.put(word, word);
					DoubleHash.put(word, word);
					quadHash.put(word, word);
					
				}
				line = br.readLine();
			}
			br.close();
		}
		catch(FileNotFoundException e) {
			System.out.println(e);
		}
		
		System.out.println("***** Collision Count *****");	// 충돌 횟수 출력
		System.out.println("LineProb: "+linearHash.Collision);
		System.out.println("DoubHash: "+DoubleHash.Collision);
		System.out.println("QuadProb: "+quadHash.Collision);
		System.out.println();
		System.out.println("***** Word Count *****");	// 서로 다른 단어 개수 출력
		System.out.println("LineProb: "+linearHash.size());
		System.out.println("DoubHash: "+DoubleHash.size());
		System.out.println("QuadProb: "+quadHash.size());
		
	}
}