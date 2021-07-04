package com.philomath.trees.questions;

public class MinDepthOfBinaryTree {
    TreeNode root;

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int data){
            this.data = data;
        }
    }

    public void createTree(){
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4, new TreeNode(8),null),
                        new TreeNode(5,null,new TreeNode(9))),
                new TreeNode(3,
                        new TreeNode(6), new TreeNode(7, null, new TreeNode(10))));
        this.root = node;
    }

    public int getMinDepth(){
        return getMinDepth(root);
    }

    private int getMinDepth(TreeNode root) {
        if(root == null){
            return 0;
        }
        if(root.left == null && root.right == null){
            return 1;
        }
        int leftDepth = Integer.MAX_VALUE;
        int rightDepth = Integer.MAX_VALUE;
        if(root.left != null)
         leftDepth= getMinDepth(root.left);
        if(root.right != null)
         rightDepth = getMinDepth(root.right);
        return 1+Math.min(leftDepth,rightDepth);
    }

    public static void main(String[] args) {
        MinDepthOfBinaryTree m = new MinDepthOfBinaryTree();
        m.createTree();
        System.out.println(m.getMinDepth());
    }
}
