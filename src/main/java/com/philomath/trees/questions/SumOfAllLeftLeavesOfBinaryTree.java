package com.philomath.trees.questions;

public class SumOfAllLeftLeavesOfBinaryTree {

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
                        new TreeNode(4),
                        new TreeNode(5)),
                new TreeNode(3,
                        new TreeNode(6),
                        new TreeNode(7)));
        this.root = node;
    }

    public int sumOfLeftLeaves(){
        int[] sum = new int[1];
        sumOfLeftLeaves(root,sum);
        return sum[0];
    }

    private void sumOfLeftLeaves(TreeNode root, int[] sum){
        if(root == null) return;
        if(root.left != null && (root.left.left == null && root.left.right == null)){
            // has left node and that is leaf as well
            sum[0]+=root.left.data;
        }
        sumOfLeftLeaves(root.left,sum);
        sumOfLeftLeaves(root.right,sum);
    }

    public static void main(String[] args) {
        SumOfAllLeftLeavesOfBinaryTree s =new SumOfAllLeftLeavesOfBinaryTree();
        s.createTree();
        System.out.println(s.sumOfLeftLeaves());
    }
}
