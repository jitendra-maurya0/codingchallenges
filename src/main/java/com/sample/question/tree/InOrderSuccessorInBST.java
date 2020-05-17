package com.sample.question.tree;

import java.util.ArrayDeque;

/*
Successor is the smallest node in the inorder traversal after the current one.
 */
public class InOrderSuccessorInBST {

    public TreeNode inorderSuccessor(TreeNode root, TreeNode p) {
        // the successor is somewhere lower in the right subtree
        // successor: one step right and then left till you can
        if (p.right != null) {
            p = p.right;
            while (p.left != null) p = p.left;
            return p;
        }

        // the successor is somewhere upper in the tree
        ArrayDeque<TreeNode> stack = new ArrayDeque<>();
        int inorder = Integer.MIN_VALUE;

        // inorder traversal : left -> node -> right
        while (!stack.isEmpty() || root != null) {
            // 1. go left till you can
            while (root != null) {
                stack.push(root);
                root = root.left;
            }

            // 2. all logic around the node
            root = stack.pop();
            // if the previous node was equal to p
            // then the current node is its successor
            if (inorder == p.val) return root;
            inorder = root.val;

            // 3. go one step right
            root = root.right;
        }

        // there is no successor
        return null;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new InOrderSuccessorInBST().inorderSuccessor(root,root.left).val);
    }

}
