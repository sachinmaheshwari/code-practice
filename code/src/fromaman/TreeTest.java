package fromaman;


import java.io.IOException;

public class TreeTest {

	/**
	 * @param args
	 */
	public static void main(String[] args) {
		

		//Created a tree
		Tree tree = new Tree("a");
		
		//Added Child
		tree.addChild("b");
		tree.addChild("c");

		//Added child of child
		Tree child = new Tree("d");
		tree.getChildAt(1).addChild(child);
		
		//Tree Traversal
		tree.traverse();

		//Tree serialization 
		//format is 
		//parent:[child1,child2,] and next line 
		//child1(as parent):[child1's child1:child1's child2,] and so on
		String fileName = "gur.txt";
		try {
			tree.serialize(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}

		//Tree de-serialization
		Tree deserializedTree = null;
		try {
			 deserializedTree = tree.deserialize(fileName);
		} catch (IOException e) {
			e.printStackTrace();
		}
		
		//Traversing de-serialized tree
		deserializedTree.traverse();
		
		
	}

}
