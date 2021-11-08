package fromaman;

//import hashmap.HashMap;
//import linkedlist.IntegerLinkedList;
//import org.omg.CORBA.SystemException;

import java.util.*;

public class BST {

	static TreeNode root;
    public static TreeMap<Integer, Integer> ht = new TreeMap<Integer, Integer>();
	/**
	 *        5
	 *      2   19
	 *     1 4 13 
	 */
	public static void main(String[] args) {
		
		BST bst = new BST();
		bst.insert(5);
		bst.insert(2);
		bst.insert(19);
		bst.insert(13);
		bst.insert(4);
		bst.insert(1);

		System.out.println(" In order ");
		bst.inorderTraversal(root);
		System.out.println(" Pre order ");
		bst.preorderTraversal(root);
		System.out.println(" Post order ");
		bst.postTraversal(root);

        //5 19 13
        System.out.println(" Print Right View");
        bst.printRightViewLevelByLevel(root, 1, 0);

        //5 2 1
        System.out.println(" Print Left View");
        bst.printLeftViewLevelByLevel(root, 1, 0);


        //1 2 5 19
        System.out.println(" Print Top View");
        bst.printTopView(root);

        //1 2 4 13 19
        System.out.println(" Print Bottom View");
        bst.printBottomView(root);

        bst.search(root,13);
		
		System.out.println(" Inorder successor of 4 is 5 : " + bst.inorderSuccessorOf(4, root));
		System.out.println(" Inorder successor of 13 is 19 : " + bst.inorderSuccessorOf(13,root));
		System.out.println(" Inorder successor of 19 is null : " + bst.inorderSuccessorOf(19,root));

		System.out.println("Size of tree is " + bst.size(root));
		
		System.out.println("Height of tree is " + bst.height(root, 0));
		
		System.out.println("Min value of tree is " + bst.minValue(root));
		
		System.out.println("Max value of tree is " + bst.maxValue(root));
	
		bst.printAllPossiblePaths(root);
		
		bst.hasPathSumEqualTo(root, 8);
		bst.hasPathSumEqualTo(root, 11);
		bst.hasPathSumEqualTo(root, 21);
		
		System.out.println(" Has children sum equal to " + bst.hasChildrenSumEqualTo(root,44));
		
		bst.printLevelByLevel(root);
		bst.printSpiral(root);
		
		bst.printVerticalOrder(root);

        TreeNode r = createNonBSTTree();
		System.out.println(" Is BST "+bst.isBST(r));
		
		System.out.println("LCA " + bst.findLeastCommonAncestorOfNodes(1,19,root));
		
		//Diameter of a tree is longest path between the leaves of a tree including the leaves for above tree its 5
		System.out.println(" Diameter " +bst.diameter(root));
		bst.printLevelByLevelBottumUp(root);

		bst.delete(1,root);
		bst.printLevelByLevel(root);

		bst.delete(19,root);
		bst.printLevelByLevel(root);

		bst.delete(2,root);
		bst.printLevelByLevel(root);

		System.out.print("Mirroring tree ");
		bst.mirror(root);
		bst.printLevelByLevel(root);

		System.out.println("Is tree height balanced");
		System.out.println(bst.isHeightBalanced(root));

		System.out.println("Is Sub Tree");
		System.out.println(bst.isSubTree(root, root));


        //Find distance between 2 nodes
        //Dist(n1, n2) = Dist(root, n1) + Dist(root, n2) - 2*Dist(root, lca)
        // Dist(root, n1)  finding level of tree where node is
        //Dist(root, lca) Distance between root and least common ancestor of 2 nodes
	}

    private static TreeNode createNonBSTTree() {
        TreeNode r = new TreeNode(2);
        TreeNode child = new TreeNode(1);
        r.setLeftChild(child);
        TreeNode wrongChild = new TreeNode(9);
        child.setRightChild(wrongChild);
        return  r;
    }


    private boolean isSubTree(TreeNode main, TreeNode child) {

		if(child == null) {
			return true;
		}

		if(main == null) {
			return  false;
		}

		if(areIdentical(main, child)) {
			return  true;
		}

		return areIdentical(main.getLeftChild(), child.getLeftChild()) || areIdentical(main.getRightChild(),child.getRightChild());
	}


	private boolean areIdentical(TreeNode main, TreeNode child) {

		if(main == null && child == null) {
			return true;
		}

		if(main == null || child == null) {
			return false;
		}

		if(main.getData() == child.getData() && areIdentical(main.getLeftChild(),child.getLeftChild()) &&
				areIdentical(main.getRightChild(),child.getRightChild())) {
			return true;
		}
		return  false;
	}

	/**
	 * Difference between height of left and right subtree is not more than 1
	 */
	private boolean isHeightBalanced(TreeNode root) {

		if(root == null || isLeaf(root)) {
			return true;
		}

		int leftHeight = height(root.getLeftChild(), 0);
		int rightHeight = height(root.getRightChild(),0);

		if((Math.abs(leftHeight-rightHeight) <= 1)
				&& isHeightBalanced(root.getLeftChild()) && isHeightBalanced(root.getRightChild())){
			return true;
		}

		return false;
	}


	private int inorderSuccessorOf(int i,TreeNode root2) {

		TreeNode node = search(root2, i);
		
		//If the right subtree is not null then the min value of right subtree is the successor 
		if( node.getRightChild() != null ) {
		        return minValue(node.getRightChild());
		 }
		 
		TreeNode succ = null;
		//Otherwise Start from root and search for successor down the tree
		while (root2 != null)
	    {
	        if (node.getData() < root2.getData())
	        {
	            succ = root2;
	            root2 = root.getLeftChild();
	        }
	        else if (node.getData() > root2.getData())
	            root2 = root2.getRightChild();
	        else
	           break;
	    }
		 
		return (succ!=null ? succ.getData() : 0);
	}


	private boolean hasChildrenSumEqualTo(TreeNode root2, int i) {

		return returnAllChildrenSum(root2) == i;
	}


	private int returnAllChildrenSum(TreeNode root2) {

		if(root2 == null) {
			return 0;
		}
		return root2.getData() + returnAllChildrenSum(root2.getLeftChild()) + returnAllChildrenSum(root2.getRightChild());
	}


	private int diameter(TreeNode root2) {

		if(root2 == null) {
			return 0;
		}
		
		int leftHeight = height(root2.getLeftChild(),0);
		int rightHeight = height(root2.getRightChild(),0);
		
		int leftDiameter = diameter(root2.getLeftChild());
		int rightDiameter = diameter(root2.getRightChild());
		
		return max(leftHeight+1+rightHeight, max(leftDiameter,rightDiameter));
	}


	private int findLeastCommonAncestorOfNodes(int i, int j, TreeNode root) {
		Stack<Integer> pathOfB = new Stack<Integer>();
		Stack<Integer> pathOfA = new Stack<Integer>();
		
		findPath(i,root,pathOfA);
		findPath(j,root,pathOfB);
		int commonAncestor = 0;

		for(int x=0;x<pathOfA.size();x++) {
			
			if(pathOfA.get(x) == pathOfB.get(x)) {
				commonAncestor = pathOfA.get(x); 
			}
			else {
				return commonAncestor;
			}
		}
		return commonAncestor;
	}


	private boolean findPath(int i,TreeNode root, Stack<Integer> path) {

		if(root == null) {
			return false;
		}
		
		path.push(root.getData());
		
		if(i==root.getData()) {
			return true;
		}

		 if ( findPath(i,root.getLeftChild(), path) || findPath(i,root.getRightChild(), path)) {
		        return true;
		 }
		 path.pop();
		 return false;
		 
	}

	private void delete(int i, TreeNode root2) {
		System.out.println("Deleting "+i);
		if(i==root2.getData()) {
			replaceNextNode(root2, root2);
			return;
		}
		
		TreeNode parent = searchParent(i,root2, root2);
		
		if(parent != null && parent.getLeftChild() != null && parent.getLeftChild().getData() == i) {

			if(isLeaf(parent.getLeftChild())) {
				parent.setLeftChild(null);
			}else
			{
				replaceNextNode(parent, parent.getLeftChild());
			}
		}
		else if(parent != null && parent.getRightChild() != null && parent.getRightChild().getData() == i) {
			if(isLeaf(parent.getRightChild())) {
				parent.setRightChild(null);
			}else{
				replaceNextNode(parent, parent.getRightChild());
			}
		}
	}

	private void replaceNextNode(TreeNode parent, TreeNode child) {

		if(child.getLeftChild() == null ) {
			parent.setLeftChild(child.getRightChild()) ;
			return;
		} else if(child.getRightChild() == null) {
			parent.setRightChild(child.getLeftChild()) ;
			return;
		}
		
		child = child.getRightChild();
		
		while(child.getLeftChild().getLeftChild() != null) {
			child = child.getLeftChild();
		}

		parent.setRightChild(child.getLeftChild());
		child.setLeftChild(null);
	}


	private boolean isLeaf(TreeNode rightChild) {

		if(rightChild.getLeftChild() == null && rightChild.getRightChild() == null)
			return true;
		else
			return false;
	}


	private TreeNode searchParent(int i, TreeNode root2, TreeNode parent) {

		
		if(root2 == null) {
			return null;
		}

		if(i == root2.getData()) {
			return parent;
		}
		
		if(i< root2.getData()) {
			return searchParent(i, root2.getLeftChild(), root2);
		}else{
			return searchParent(i, root2.getRightChild(), root2);
		}
		
	}


	private boolean isBST(TreeNode root2) {

		if(root2 == null) {
			return true;
		}
		
		if(root2.getLeftChild() != null && maxValue(root2.getLeftChild()) > root2.getData()) {
			return false;
		}
		
		if(root2.getRightChild() != null && minValue(root2.getRightChild()) < root2.getData()) {
			return false;
		}
		
		if(!(isBST(root2.getLeftChild())) || !isBST(root2.getRightChild())) {
			return false;
		}
		
		return true;
	}


    /**
     * It is just like level by level view but we just print the first element in that level
     * so if a level has been printed we store it in a set and do not print it again
     */
    private void printTopView (TreeNode root2) {
        System.out.println("printTopView");
        TreeNode root3 = root2;
        //Treat root as 0 th position

        // find min height of left tree
        int leftHeight = 0;
        while(root3.getLeftChild() != null) {

            leftHeight++;
            root3 = root3.getLeftChild();
        }

        //find max height of rightTree
        root3 = root2;
        int rightHeight = 0;
        while(root3.getRightChild() != null) {

            rightHeight++;
            root3 = root3.getRightChild();
        }


        leftHeight = -leftHeight;
        HashSet levelSet = new HashSet();
        for(int i = leftHeight ; i <= rightHeight ; i ++ ) {

            printTopView(root2, 0, i, levelSet);
        }
    }

    private void printTopView(TreeNode root2, int currrentLevel, int levelToPrint, HashSet levelSet) {
        if(root2 == null) {
            return;
        }

        if(currrentLevel == levelToPrint && !levelSet.contains(levelToPrint)) {
            System.out.println(root2.getData());
            levelSet.add(levelToPrint);
        }

        printTopView(root2.getLeftChild(), currrentLevel - 1, levelToPrint, levelSet);
        printTopView(root2.getRightChild(), currrentLevel + 1, levelToPrint, levelSet);
    }

	private void printVerticalOrder(TreeNode root2) {

		System.out.println("printVerticalOrder");
		TreeNode root3 = root2;
		//Treat root as 0 th position 
		
		// find min height of left tree
		int leftHeight = 0;
		while(root3.getLeftChild() != null) {
			
			leftHeight++;
			root3 = root3.getLeftChild();
		}
		
		//find max height of rightTree
		root3 = root2;
		int rightHeight = 0;
		while(root3.getRightChild() != null) {
			
			rightHeight++;
			root3 = root3.getRightChild();
		}
		
		System.out.println(" Height of left tree is " + -leftHeight);
		System.out.println(" Height of right tree is " + rightHeight);
		leftHeight = -leftHeight;
		for(int i = leftHeight ; i <= rightHeight ; i ++ ) {
			
			printVerticalOrder(root2, 0, i);
		}
	}

    private void printVerticalOrder(TreeNode root2, int currrentLevel, int levelToPrint) {
        if(root2 == null) {
            return;
        }

        if(currrentLevel == levelToPrint) {
            System.out.println(root2.getData());
        }

        printVerticalOrder(root2.getLeftChild(), currrentLevel-1, levelToPrint);
        printVerticalOrder(root2.getRightChild(), currrentLevel+1, levelToPrint);
    }



	private void printLevelByLevelBottumUp(TreeNode root2) {
		System.out.println(" Printing Level by Level Bottum Up");
		for(int i=height(root2,0) ; i >0 ; i --) {
			printLevelByLevel(root2, i);
		}
	}


	public void printLevelByLevel(TreeNode root2) {

		System.out.println(" Printing Level by Level");
		for(int i=1 ; i <= height(root2, 0) ; i ++) {
			printLevelByLevel(root2, i);
		}
	}

    private void printLevelByLevel(TreeNode root2, int level) {

        if(root2 == null) {
            return;
        }

        if(level==1) {
            System.out.println(root2.getData());
        }
        else if(level > 1) {
            printLevelByLevel(root2.getLeftChild(),level-1);
            printLevelByLevel(root2.getRightChild(),level-1);

        }
    }


	private void printSpiral(TreeNode root2) {

		System.out.println(" Printing Spiral");
		boolean flag = true;
		for(int i=1 ; i <= height(root2, 0) ; i ++) {
			printSpiral(root2, i,flag);
			flag = !flag;
		}
	}


	private void printSpiral(TreeNode root2, int level, boolean flag) {

        if (root2 == null) {
            return;
        }

        if (level == 1) {
            System.out.println(root2.getData());
        } else if (level > 1) {
            if (flag) {
                printLevelByLevel(root2.getLeftChild(), level - 1);
                printLevelByLevel(root2.getRightChild(), level - 1);
            } else {
                printLevelByLevel(root2.getRightChild(), level - 1);
                printLevelByLevel(root2.getLeftChild(), level - 1);
            }
        }
    }


//http://algorithms.tutorialhorizon.com/print-the-bottom-view-of-the-binary-tree/
        // Method that prints the bottom view.
        public void printBottomView(TreeNode root2) {

            System.out.println(" printBottomView ");
            if (root2 == null)
                return;

            // Initialize a variable 'hd' with 0 for the root element.
            int hd = 0;

            // TreeMap which stores key value pair sorted on key value
            Map<Integer, Integer> map = new TreeMap<Integer,Integer>();

            // Queue to store tree nodes in level order traversal
            Queue<TreeNode> queue = new LinkedList<TreeNode>();

            // Assign initialized horizontal distance value to root
            // node and add it to the queue.
            root2.setHd(hd);
            queue.add(root);

            // Loop until the queue is empty (standard level order loop)
            while (!queue.isEmpty())
            {
                TreeNode temp = queue.remove();

                // Extract the horizontal distance value from the
                // dequeued tree node.
                hd = temp.getHd();

                // Put the dequeued tree node to TreeMap having key
                // as horizontal distance. Every time we find a node
                // having same horizontal distance we need to replace
                // the data in the map.
                map.put(hd, temp.getData());

                // If the dequeued node has a left child add it to the
                // queue with a horizontal distance hd-1.
                if (temp.getLeftChild() != null)
                {
                    temp.getLeftChild().setHd( hd-1);
                    queue.add(temp.getLeftChild());
                }
                // If the dequeued node has a left child add it to the
                // queue with a horizontal distance hd+1.
                if (temp.getRightChild() != null)
                {
                    temp.getRightChild().setHd(hd+1);
                    queue.add(temp.getRightChild());
                }
            }

            // Extract the entries of map into a set to traverse
            // an iterator over that.
            Set<Map.Entry<Integer, Integer>> set = map.entrySet();

            // Make an iterator
            Iterator<Map.Entry<Integer, Integer>> iterator = set.iterator();

            // Traverse the map elements using the iterator.
            while (iterator.hasNext())
            {
                Map.Entry<Integer, Integer> me = iterator.next();
                System.out.println(me.getValue()+" ");
            }
        }

    private void printRightViewLevelByLevel(TreeNode root2, int level, int maxLevel) {

        if(root2 == null) {
            return;
        }

        if(level > maxLevel) {
            System.out.println(root2.getData());
            maxLevel= level;
        }

        printRightViewLevelByLevel(root2.getRightChild(), level+1, maxLevel);
        printRightViewLevelByLevel(root2.getLeftChild(),level+1, maxLevel);
    }

    private void printLeftViewLevelByLevel(TreeNode root2, int level, int maxLevel) {

        if(root2 == null) {
            return;
        }

        if(level > maxLevel) {
            System.out.println(root2.getData());
            maxLevel = level;
        }


        printLeftViewLevelByLevel(root2.getLeftChild(), level + 1, maxLevel);
        printLeftViewLevelByLevel(root2.getRightChild(), level +1, maxLevel);
    }



    private void hasPathSumEqualTo(TreeNode root2, int sum) {

		if(root2 == null) {
			return;
		}
		
		sum = sum - root2.getData();
		
		if(sum  == 0 && isLeaf(root2)) {
			System.out.println(" Yes reached leaf and it has the sum ");
			return;
		}
		
		hasPathSumEqualTo(root2.getLeftChild(), sum);
		hasPathSumEqualTo(root2.getRightChild(), sum);
		
		
	}


	private void printAllPossiblePaths(TreeNode root2) {
	
		  int[] path = new int[1000];
		  printPaths(root2, path, 0);

	}

	private void printPaths(TreeNode node, int[] path, int pathLen) {
	
		  if (node==null) return;

		  // append this node to the path array
		  path[pathLen] = node.getData();
		  pathLen++;

		  // it's a leaf, so print the path that led to here
		  if (node.getLeftChild()==null && node.getRightChild()==null) {
		    printArray(path, pathLen);
		  }
		  else {
		  // otherwise try both subtrees
		    printPaths(node.getLeftChild(), path, pathLen);
		    printPaths(node.getRightChild(), path, pathLen);
		  }
	}

	private void printArray(int[] ints, int len) {
		  int i;
		  for (i=0; i<len; i++) {
		   System.out.print(ints[i] + " ");
		  }
		  System.out.println();
	}


	private int maxValue(TreeNode root2) {

		while(root2.getRightChild() != null) {
			root2 = root2.getRightChild();
		}

		return root2.getData();

	}


	private int minValue(TreeNode root2) {
	
		while(root2.getLeftChild() != null) {
			root2 = root2.getLeftChild();
		}

		return root2.getData();
	}




	private int  height(TreeNode root2, int count) {
		
		if(root2 == null) {
			return count;
		}

		return max ( height(root2.getLeftChild() ,count+1) , height(root2.getRightChild() ,count+1) );
	}


	private int max(int height, int height2) {
		if(height>height2)
		return height;
		else
			return height2;
	}


	private int size(TreeNode root) {
		if(root == null) {
			return 0;
		}
		return size(root.getLeftChild())+ 1 + size(root.getRightChild());
	}

	private TreeNode search(TreeNode root2, int i) {

		if(root2 == null) {
			System.out.println(" Not Found");
			return null;
		}
		
		if(i==root2.getData()) {
			System.out.println("Found");
			return root2;
		} else if(i<root2.getData()) {
			return search(root2.getLeftChild(), i);
		}else {
			return search(root2.getRightChild(), i);
		}
			
		
	}

	private void postTraversal(TreeNode root2) {

		if(root2 == null) {
			return;
		}
			
		postTraversal(root2.getLeftChild());
		postTraversal(root2.getRightChild());
		System.out.println(root2.getData());

	}

	private void preorderTraversal(TreeNode root2) {

		if(root2 == null) {
			return;
		}
			
		System.out.println(root2.getData());
		preorderTraversal(root2.getLeftChild());
		preorderTraversal(root2.getRightChild());

	}

	private void inorderTraversal( TreeNode root) {


		if(root == null) {
			return;
		}
			
		inorderTraversal(root.getLeftChild());
		System.out.println(root.getData());
		inorderTraversal(root.getRightChild());
		
		
	}

	private void insert(int i) {
	
		if(root == null) {
			root = new TreeNode(i);
		}
		else{
			insert(i, root);
		}
		
		
	}

	private void insert(int i, TreeNode root2) {
		
		if( root2.getLeftChild() == null || root2.getRightChild() == null) {
			if(i < root2.getData()) {
				root2.setLeftChild(new TreeNode(i));	
				return;
			}else{
				root2.setRightChild(new TreeNode(i));
				return;
			}
		}
		
		if(i < root2.getData()) {
			insert(i, root2.getLeftChild());	
		}else{
			insert(i, root2.getRightChild());
		}
	
	}


	private static void mirror(TreeNode node) {
		if (node != null) {
			// do the sub-trees
			mirror(node.getLeftChild());
			mirror(node.getRightChild());

			// swap the left/right pointers
			TreeNode temp = node.getLeftChild();
			node.setLeftChild(node.getRightChild());
			node.setRightChild(temp);
		}
	}

}
