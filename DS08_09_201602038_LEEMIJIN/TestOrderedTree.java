package DS08_09;

import java.util.List;
import java.util.LinkedList;

public class TestOrderedTree {
	public static void main(String[] args) {
		OrderedTree treeA,treeB,treeD,treeE,treeG;
		OrderedTree treeC = new OrderedTree("C");
		OrderedTree treeF = new OrderedTree("F");
		OrderedTree treeH = new OrderedTree("H");
		OrderedTree treeI = new OrderedTree("I");
		OrderedTree treeJ = new OrderedTree("J");
		OrderedTree treeK = new OrderedTree("K");
		OrderedTree treeL = new OrderedTree("L");
		OrderedTree treeM = new OrderedTree("M");
		
		List<OrderedTree> subtreesOfE = new LinkedList<OrderedTree>();
		// E 에 H,I
		subtreesOfE.add(treeH);
		subtreesOfE.add(treeI);
		treeE = new OrderedTree("E",subtreesOfE);
		
		List<OrderedTree> subtreesOfB = new LinkedList<OrderedTree>();
		// B에 E,F
		subtreesOfB.add(treeE);
		subtreesOfB.add(treeF);
		treeB = new OrderedTree("B",subtreesOfB);
		
		List<OrderedTree> subtreesOfG = new LinkedList<OrderedTree>();
		// G에 J,K,L,M
		subtreesOfG.add(treeJ);
		subtreesOfG.add(treeK);
		subtreesOfG.add(treeL);
		subtreesOfG.add(treeM);
		treeG = new OrderedTree("G",subtreesOfG);
		
		List<OrderedTree> subtreesOfD = new LinkedList<OrderedTree>();
		// D에 G
		subtreesOfD.add(treeG);
		treeD = new OrderedTree("D", subtreesOfD);
		
		List<OrderedTree> subtreesOfA = new LinkedList<OrderedTree>();
		// A에 B,C,D
		subtreesOfA.add(treeB);
		subtreesOfA.add(treeC);
		subtreesOfA.add(treeD);
		treeA = new OrderedTree("A", subtreesOfA);
		
		OrderedTree ot = new OrderedTree();
		ot.levelOrder(treeA);

	}	
}
