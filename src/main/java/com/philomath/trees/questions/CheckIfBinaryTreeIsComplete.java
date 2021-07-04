package com.philomath.trees.questions;

import java.util.LinkedList;
import java.util.Queue;

public class CheckIfBinaryTreeIsComplete {
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
        /**
         *        1
         *       / \
         *      2   3
         *     / \  /
         *    4  5  6
         */
        this.root = new TreeNode(1,
                new TreeNode(2, new TreeNode(4), new TreeNode(5)),
                new TreeNode(3, new TreeNode(6), null));
    }

    public void createUnCompleteTree(){
        /**
         *        1
         *       / \
         *      2   3
         *      \
         *      5
         */
        this.root = new TreeNode(1,
                new TreeNode(2, null, new TreeNode(5)),
                new TreeNode(3));
    }

    public boolean isCompleteBinaryTree(){
        if(root == null){
            return true;
        }
        Queue<TreeNode> q = new LinkedList<>();
        q.add(root);
        boolean nonFullNodeSeen = false;
        while(!q.isEmpty()){
            TreeNode node = q.remove();
            if(node.left != null && node.right != null){
                if(nonFullNodeSeen){
                    return false;
                }
                q.add(node.left);
                q.add(node.right);
            }
            if(node.left != null && node.right == null){
                if(nonFullNodeSeen){
                    return false;
                }
                nonFullNodeSeen = true;
                q.add(node.left);
            }
            if(node.left == null && node.right != null){
                return false;
            }
        }
        return true;
    }

    public static void main(String[] args) {
        CheckIfBinaryTreeIsComplete c = new CheckIfBinaryTreeIsComplete();
        c.createTree();
        System.out.println(c.isCompleteBinaryTree());
        c.createUnCompleteTree();
        System.out.println(c.isCompleteBinaryTree());
    }

}
