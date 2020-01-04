package com.sample.test.tree;

import java.util.Stack;

public class KthSmallestNodeOfTree {
    public void findKthNode(TreeNode root,int k){
        Stack<TreeNode> stack = new Stack<>();

      TreeNode p = root;
      int result = 0;

        while (!stack.isEmpty()||p !=null){
          if(p!= null){
              stack.push(p);
              p = p.left;
          }else{
              TreeNode t = stack.pop();
              k--;
              if(k ==0){
                  result = t.val;
              }
              p = t.right;
          }
        }
        System.out.println(result);
    }
    public int kthSmallest(TreeNode root, int k) {
        Stack<TreeNode> stack = new Stack<TreeNode>();
        TreeNode p = root;
        while(p!=null){
            stack.push(p);
            p=p.left;
        }
        int i=0;
        while(!stack.isEmpty()){
            TreeNode t = stack.pop();
            i++;

            if(i==k)
                return t.val;

            TreeNode r = t.right;
            while(r!=null){
                stack.push(r);
                r=r.left;
            }

        }

        return -1;
    }

    public static void main(String[] args) {
        TreeNode binaryTree = BinaryTree.createTree();
        TreePrinter.printNode(binaryTree);
        KthSmallestNodeOfTree kthSmallestNodeOfTree = new KthSmallestNodeOfTree();
        kthSmallestNodeOfTree.findKthNode(binaryTree,2);
    }
}
