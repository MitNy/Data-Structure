package DS01_06_201602038;

import java.io.BufferedReader;
import java.io.File;
import java.io.FileNotFoundException;
import java.io.FileReader;
import java.io.IOException;

public class TestMST {
	public static void main(String args[]) throws IOException {
		String string;
		String[] ssp;
	 
		try {
			BufferedReader br = new BufferedReader(new FileReader(new File("C://input.txt")));
			string = br.readLine();
			ssp = string.split(" ");
			int size = Integer.parseInt(ssp[0]);
			
			MST mst = new MST(size);
			mst.Kruskal();
			
			br.close();	// ÆÄÀÏ close
			
		}
		catch (FileNotFoundException e) {
			// TODO Auto-generated catch block
			e.printStackTrace();
		}	
	}
}
