package com.sample.test.tree;

import java.util.*;
import java.util.stream.Collectors;

public class BinaryTree {

    TreeNode root;
    TreeNode left;
    TreeNode right;





    void preOrder(TreeNode root) {
        if (root == null) return;

        System.out.print(" " + root.val);
        preOrder(root.left);
        preOrder(root.right);

    }

    void postOrder(TreeNode root) {
        if (root == null) return;
        postOrder(root.left);
        postOrder(root.right);
        System.out.print(" " + root.val);
    }

    void inOrder(TreeNode root) {
        if (root == null) return;
        inOrder(root.left);
        System.out.print(" " + root.val);
        inOrder(root.right);
    }

    void levelOrderRecursive(TreeNode treeNode) {
        if (treeNode == null) return;
        Queue<TreeNode> q = new LinkedList<>();
        q.offer(treeNode);
        while (!q.isEmpty()) {
            TreeNode item = q.poll();
            System.out.print(" " + item.val);

            if (item.left != null) {
                q.add(item.left);
            }
            if (item.right != null) {
                q.add(item.right);
            }
        }
    }

    public Map<Integer, List<Integer>> verticalOrder(TreeNode root) {
        Map<Integer, List<Integer>> map = new TreeMap<>();
        helper(map, root);
        return map;

    }

    private void helper(Map<Integer, List<Integer>> map, TreeNode root) {
        if (root == null) return;
        LinkedList<TreeNode> q1 = new LinkedList<>();
        LinkedList<Integer> q2 = new LinkedList<>();
        q1.offer(root);
        q2.add(0);

        while (!q1.isEmpty()) {
            TreeNode item = q1.poll();
            int order = q2.poll();
            List<Integer> list = map.get(order);
            if (list == null) {
                list = new ArrayList<>();
                map.put(order, list);
            }
            list.add(item.val);

            if (item.left != null) {
                q1.offer(item.left);
                q2.offer(order - 1);
            }
            if (item.right != null) {
                q1.offer(item.right);
                q2.offer(order + 1);
            }
        }
    }

    void verticalSumOfTree(TreeNode root) {
        Map<Integer, List<Integer>> verticalOrder = this.verticalOrder(root);
        verticalOrder.forEach((k, v) -> System.out.print(k + " -> " + v.stream().mapToInt(Integer::intValue).sum()));
    }


    int getheight(TreeNode treeNode) {
        if (treeNode == null) return 0;

        return 1 + Math.max(getheight(treeNode.left), getheight(treeNode.right));
    }

    public static TreeNode createTree(){
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        return root;
    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(1);
        root.left = new TreeNode(2);
        root.right = new TreeNode(3);
        root.left.left = new TreeNode(4);
        root.left.right = new TreeNode(5);
        BinaryTree tree = new BinaryTree();
/*        System.out.println("------preorder ---------------");
        tree.preOrder(root);
        System.out.println("-------PostOrder-------------");
        tree.postOrder(root);
        System.out.println("---------- in order ----------");
        tree.inOrder(root);



        tree.levelOrderRecursive(root);

 */
        //  tree.verticalOrder(root);
        tree.verticalSumOfTree(root);
    }

}
