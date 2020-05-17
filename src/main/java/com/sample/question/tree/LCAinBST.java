package com.sample.question.tree;
/*
The lowest common ancestor is defined between two nodes p and q as the lowest node in T that has both p and q as
descendants (where we allow a node to be a descendant of itself).

Algorithm:
1. Start traversing the tree from the root node.
2. If both the nodes p and q are in the right subtree, then continue the search with right subtree starting step 1.
3. If both the nodes p and q are in the left subtree, then continue the search with left subtree starting step 1.
4. If both step 2 and step 3 are not true, this means we have found the node which is common to node p's and q's subtrees.
and hence we return this common node as the LCA.
 */
public class LCAinBST {

    TreeNode LCA(TreeNode root,TreeNode p,TreeNode q){

        // step1: start traversing from root node
        int parentVal = root.val;

         // step2: check if both p and q are in right subtree of root node then search with root.right from step 1
        if(parentVal < p.val && parentVal < q.val){
                return LCA(root.right,p,q);
        }else if(parentVal > p.val && parentVal > q.val){
            //step 3:
            return LCA(root.left, p,q);
        }else{
            return root;
        }

    }

    public static void main(String[] args) {
        TreeNode root = new TreeNode(2);
        root.left = new TreeNode(1);
        root.right = new TreeNode(3);
        System.out.println(new LCAinBST().LCA(root,root.left,root.right).val);
    }
}
