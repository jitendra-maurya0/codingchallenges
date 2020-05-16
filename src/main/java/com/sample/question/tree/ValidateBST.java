package com.sample.question.tree;

import java.util.LinkedList;
import java.util.Stack;

public class ValidateBST {

    // return true if binary is valid i.e root > left and root < right
    // can be solve using recursion time  complexity is O(n)
    boolean isValidBST(TreeNode root){

        return helper(root,null,null);

    }
    boolean helper(TreeNode root, Integer lower,Integer upper){
        if(root == null) return true;
        int val = root.val;
        if(lower !=  null && val <= lower ) return  false;
        if(upper != null && val >= upper) return false;

        if(!helper(root.left,lower,val)) return false;
        if(helper(root.right,val,upper)) return false;
        return true;
    }

    // Solution 2 using recursion
    LinkedList<TreeNode> stack = new LinkedList<>();
    LinkedList<Integer> lower = new LinkedList<>();
    LinkedList<Integer> upper = new LinkedList<>();

    boolean isValidBSTUsingRecursion(TreeNode root){
       update(root,null,null);
       while (!stack.isEmpty()){
           TreeNode node = stack.pop();
           Integer val = node.val;
           Integer l = lower.pop();
           Integer u = upper.pop();

           if(l != null && l <= val ) return false;

           if(u != null && u >= val) return false;
           update(root.left,val,l);
           update(root.right,u,val);
       }
        return true;

    }

    void update(TreeNode root,Integer l,Integer u){
        stack.add(root);
        lower.add(l);
        upper.add(u);
    }

    // Solution 3 Using Inorder traversal
    public boolean isValidBSTUsingInorder(TreeNode root) {
        Stack<TreeNode> stack = new Stack();
        double inorder = - Double.MAX_VALUE;

        while (!stack.isEmpty() || root != null) {
            while (root != null) {
                stack.push(root);
                root = root.left;
            }
            root = stack.pop();
            // If next element in inorder traversal
            // is smaller than the previous one
            // that's not BST.
            if (root.val <= inorder) return false;
            inorder = root.val;
            root = root.right;
        }
        return true;
    }

    public static void main(String[] args) {

    }
}
