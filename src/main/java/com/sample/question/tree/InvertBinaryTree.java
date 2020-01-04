package com.sample.question.tree;

import java.util.LinkedList;

/**
 * inversion is similar to mirror image of tree
 */
public class InvertBinaryTree {

    public TreeNode invertBinaryTree(TreeNode root){
        if(root == null) return null;
        invertBinaryTree(root.left);
        invertBinaryTree(root.right);
        TreeNode temp = root.left;
        root.left = root.right;
        root.right = temp;
        return root;
    }

    public TreeNode iterative(TreeNode treeNode){

        LinkedList<TreeNode> queue = new LinkedList<>();
        if(treeNode != null){
            queue.add(treeNode);
        }
        while (!queue.isEmpty()){
            TreeNode temp = queue.poll();
            if(temp.left != null){
                queue.add(temp.left);
            }
            if(temp.right != null){
                queue.add(temp.right);
            }

            TreeNode swap = temp.left;
            temp.left = temp.right;
            temp.right = swap;

        }
        return treeNode;
    }


    public static void main(String[] args) {
        TreeNode binaryTree  = new TreeNode(1);
        binaryTree.left = new TreeNode(2);
        binaryTree.right = new TreeNode(3);
        binaryTree.left.left = new TreeNode(4);
        binaryTree.left.left.right = new TreeNode(5);
        System.out.println("Before inversion");
        TreePrinter.printNode(binaryTree);
        System.out.println("after inversion");
        InvertBinaryTree invertBinaryTree = new InvertBinaryTree();
        TreeNode inverted = invertBinaryTree.invertBinaryTree(binaryTree);
        TreePrinter.printNode(inverted);
        System.out.println("============inversion==============");



    }
}
