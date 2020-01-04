package com.sample.test.tree;

public class TreeNode {
    int val;
    TreeNode left;
    TreeNode right;

    TreeNode(int data){
        this.val = data;
    }

    public void print(TreeNode root){
        TreePrinter.printNode(root);
    }
}
