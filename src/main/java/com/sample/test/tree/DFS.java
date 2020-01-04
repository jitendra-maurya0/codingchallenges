package com.sample.test.tree;

import java.util.ArrayList;
import java.util.List;

public class DFS {

    public void printAllPath(TreeNode root){
      List<List<Integer>>lists = new ArrayList<>();
      List<Integer> current = new ArrayList<>();
      dfs(root,lists,current);
      for (List<Integer>path: lists){
          path.stream().forEach(integer -> System.out.print(integer +"->"));
          System.out.println();
      }
    }

    public void dfs(TreeNode root, List<List<Integer>>lists,List<Integer> current){

        current.add(root.val);
        if(root.left == null && root.right == null){
            lists.add(current);
            return;
        }

        if(root.left != null){
            ArrayList<Integer> tempPath = new ArrayList<>(current);
            dfs(root.left,lists,tempPath);
        }
        if(root.right != null){
          ArrayList<Integer> tempPath = new ArrayList<>(current);
          dfs(root.right,lists,tempPath);
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        TreePrinter.printNode(root);
       DFS dfs = new DFS();
       dfs.printAllPath(root);

    }
}
