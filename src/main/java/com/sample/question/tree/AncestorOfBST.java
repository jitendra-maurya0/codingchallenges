package com.sample.question.tree;

public class AncestorOfBST {

    // Iterative Function to print all ancestors of a given key
    //The time complexity of this solution is O(log(n)) since a path from the root to k is traced.
    public static String findAncestors(Node root, int k) {

        String result = "";
        Node tempNode = root;
        while(tempNode != null && tempNode.getData() != k){
            result = result + tempNode.getData() + ",";
            if(k <= tempNode.getData()){
                tempNode = tempNode.getLeftChild();
            } else{
                tempNode = tempNode.getRightChild();
            }
        }
        if(tempNode == null){
            return "";
        }
        return result;
    }

    // Driver code
    public static void main(String[] args)
    {
        BinarySearchTree tree = new BinarySearchTree();
		/* Construct a binary tree like this
				6
			   / \
			  4   9
			 / \  |  \
			2	5 8	  12
					  / \
					 10  14
		*/
        tree.add(6);
        tree.add(4);
        tree.add(9);
        tree.add(2);
        tree.add(5);
        tree.add(8);
        tree.add(8);
        tree.add(12);
        tree.add(10);
        tree.add(14);

        int key = 10;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));

        System.out.println();
        key = 5;
        System.out.print(key + " --> ");
        System.out.print(findAncestors(tree.getRoot(), key));
    }

}
