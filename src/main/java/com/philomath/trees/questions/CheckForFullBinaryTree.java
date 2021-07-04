package com.philomath.trees.questions;

public class CheckForFullBinaryTree {

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

    public void createPartialTree(){
        this.root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4),null),
                new TreeNode(3, null, new TreeNode(7)));
    }
    public void createFullTree(){
        this.root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4),new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
    }

    public boolean isFullBinaryTree(){
        return isFullBinaryTree(root);
    }
    private boolean isFullBinaryTree(TreeNode root){
        if(root == null) return true;
        if(root.left == null && root.right == null) return true;
        boolean isLeftFull = false;
        boolean isRightFull = false;
        if(root.left != null){
            isLeftFull = isFullBinaryTree(root.left);
        }
        if(root.right != null){
            isRightFull = isFullBinaryTree(root.right);
        }
        return isLeftFull && isRightFull;
    }

    public static void main(String[] args) {
        CheckForFullBinaryTree c = new CheckForFullBinaryTree();
        c.createPartialTree();
        System.out.println(c.isFullBinaryTree());
        c.createFullTree();
        System.out.println(c.isFullBinaryTree());
    }
}
