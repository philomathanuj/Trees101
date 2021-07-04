package com.philomath.trees.questions;

public class DeepestOddLevelLeafNode {
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

    public void createTree(){
        TreeNode node = new TreeNode(1,
                new TreeNode(2,
                        new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        this.root = node;
    }

    public void deepestOddLevelLeaves(){
        deepestOddLevelLeaves(root,1);
    }
    private void deepestOddLevelLeaves(TreeNode root, int level){
        if(root == null) return;
        if(root.left == null && root.right == null && level % 2 != 0){
            System.out.println(root.data);
        }
        deepestOddLevelLeaves(root.left, level+1);
        deepestOddLevelLeaves(root.right, level+1);
    }

    public static void main(String[] args) {
        DeepestOddLevelLeafNode d = new DeepestOddLevelLeafNode();
        d.createTree();
        d.deepestOddLevelLeaves();
    }
}
