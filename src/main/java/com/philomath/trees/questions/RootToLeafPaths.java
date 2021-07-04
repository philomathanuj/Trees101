package com.philomath.trees.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * The algorithm traverses the tree in pre-order manner and uses an array list to store the paths.
 * When a leaf node is reached, the path is printed.
 * path - an array list that stores the current path.
 *
 * Step 1: Add root data to the array list.
 * Step 2: If root is a leaf, print the path and return.
 * Step 3: Recursively traverse the left subtree.
 * Step 4: Recursively traverse the right subtree.
 *
 * Note: A new array list is created in the recursive calls (Steps 3 and 4) because we do not want to share the same array list in left and right subtree calls as the paths will be different.
 * We add nodes up to the current path to the array list because the paths up to the current node are common for left and right subtrees.
 */
public class RootToLeafPaths {
    public TreeNode root;

    class TreeNode{
        int data;
        TreeNode left;
        TreeNode right;

        public TreeNode(int data, TreeNode left, TreeNode right){
            this.data =data;
            this.left = left;
            this.right = right;
        }
        public TreeNode(int data){
            this.data = data;
        }
    }
    public void createTree(){
        TreeNode treeNode = new TreeNode(1, new TreeNode(2, new TreeNode(4), new TreeNode(5))
                , new TreeNode(3, new TreeNode(6), new TreeNode(7)));
        this.root  =treeNode;
    }

    public void rootToLeafPaths(){
        rootToLeafPaths(this.root, new ArrayList<>());
    }

    private void rootToLeafPaths(TreeNode root, List<Integer> path) {
        if(root == null) return;
        path.add(root.data);
        if(root.left == null && root.right == null){
            System.out.println(path);
        }
        else{
            rootToLeafPaths(root.left, new ArrayList<>(path));
            rootToLeafPaths(root.right, new ArrayList<>(path));
        }

    }

    public static void main(String[] args) {
        RootToLeafPaths r = new RootToLeafPaths();
        r.createTree();
        r.rootToLeafPaths();
    }

}
