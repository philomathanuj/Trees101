package com.philomath.trees.questions;

/**
 * Solution uses recursion to find out if the trees are identical.
 * 1. If root of both trees are null, then they are same. Return true.
 * 2. If roots of both the trees are not null, check if the data in the two nodes is same and recursively check if left and right subtrees are identical.
 * 3. If the roots of only one of the trees is null, then the trees are not identical, so return false.
 */
public class CheckForIdenticalTrees {
    TreeNode root;

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data){
            this.data = data;
        }
        public TreeNode(int data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }
    public TreeNode createTree(){
        return new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    }
    public boolean isIdentical(TreeNode root1, TreeNode root2){
        if(root1 == null && root2 == null){
            return true;
        }
        if(root1 != null && root2 != null) {
            if (root1.data == root2.data && isIdentical(root1.left, root2.left)
                    && isIdentical(root1.right, root2.right)) {
                return true;
            }
        }
        return false;
    }

    public static void main(String[] args) {
        CheckForIdenticalTrees c = new CheckForIdenticalTrees();
        TreeNode root1 = c.createTree();
        TreeNode root2 = c.createTree();
        System.out.println(c.isIdentical(root1,root2));
    }
}
