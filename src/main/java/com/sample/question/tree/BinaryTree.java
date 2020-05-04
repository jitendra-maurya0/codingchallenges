package com.sample.question.tree;

import java.util.*;

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

    /**
     * this programs gets timeout
     *
     * @param treeNode
     */
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

    List<List<Integer>> levels = new ArrayList<List<Integer>>();

    public List<List<Integer>> levelOrderItr(TreeNode root) {

        if (root == null) return levels;
        helper(root, 0);
        return levels;


    }

    public void helper(TreeNode node, int level) {
        // start the current level
        if (levels.size() == level)
            levels.add(new ArrayList<Integer>());

        // fulfil the current level
        levels.get(level).add(node.val);

        // process child nodes for the next level
        if (node.left != null)
            helper(node.left, level + 1);
        if (node.right != null)
            helper(node.right, level + 1);
    }
    public List<List<Integer>> levelOrderV2(TreeNode root){
        List<List<Integer>> ans = new ArrayList<>();
        Queue<TreeNode> q = new LinkedList<>();
        if (root != null) {
            q.offer(root);
        }
        TreeNode cur;
        while (!q.isEmpty()) {
            int size = q.size();
            List<Integer> subAns = new LinkedList<Integer>();
            for (int i = 0; i < size; ++i) {        // traverse nodes in the same level
                cur = q.poll();
                subAns.add(cur.val);                // visit the root
                if (cur.left != null) {
                    q.offer(cur.left);              // push left child to queue if it is not null
                }
                if (cur.right != null) {
                    q.offer(cur.right);             // push right child to queue if it is not null
                }
            }
            ans.add(subAns);
        }
        return ans;
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

    public static TreeNode createTree() {
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
        tree.levelOrderV2(root);
    }

}
