package com.philomath.trees.questions;

import com.sun.source.tree.Tree;

public class LeftViewOfBinaryTree {
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

    int maxLevelSeenSoFar = Integer.MIN_VALUE;

    public void printLeftView(){
        printLeftView(root,0);
    }
    private void printLeftView(TreeNode root, int level){
        if(root == null) return;
        if(level > maxLevelSeenSoFar){
            System.out.println(root.data);
            maxLevelSeenSoFar = level;
        }
        if(root.left != null){
            printLeftView(root.left,level+1);
        }
        if(root.right != null){
            printLeftView(root.right, level+1);
        }
    }

    public static void main(String[] args) {
        LeftViewOfBinaryTree l = new LeftViewOfBinaryTree();
        l.createTree();
        l.printLeftView();
    }
}
