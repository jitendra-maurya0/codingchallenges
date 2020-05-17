package com.sample.question.tree;

import java.util.ArrayList;

/**
 * implement iterator for binary search tree has two method
 *   next() -> will return next smallest element from tree;
 *   hasNext() -> will return true/false.
 *   idea is simple flatten binary tree in array or List InOrder fashion
 *   inorder is always maintain item is sorted manner
 */
public class BSTIterator {

    ArrayList<Integer> sortedNode;
    int index;
    public BSTIterator(TreeNode root){
        this.sortedNode = new ArrayList<>();
        this.index = -1;
        this.inorder(root);
    }

    // process left subtree -> node -> process right subtree
    private void inorder(TreeNode root){
        if(root == null) return;
        this.inorder(root.left);
        this.sortedNode.add(root.val);
        this.inorder(root.right);
    }

    public Integer next(){
      return this.sortedNode.get(++this.index);
    }

    public  boolean hasNext(){
        return this.index+1 < this.sortedNode.size();
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        BSTIterator it = new BSTIterator(root);
        while (it.hasNext()){
            System.out.println(it.next());
        }
    }
}
