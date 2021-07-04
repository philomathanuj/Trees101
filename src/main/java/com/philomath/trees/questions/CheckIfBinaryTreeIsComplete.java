package com.philomath.trees.questions;

import java.util.LinkedList;
import java.util.Queue;

/**
 * The idea to solve this problem is simple. We do a usual level order traversal and
 * whenever we see that there is a node which does not have both left and right child,
 * then we set nonFullNodeSeen = true. This indicates that while doing level order traversal,
 * we have seen our first node with either right or left or both children absent.
 * And for a complete binary tree, all the nodes visited during level order traversal
 * after visiting a nonFullNode would be leaf nodes. If this is not true, we return false.
 * For example, in the left-hand side complete tree shown above, once we visit node '3' which is a
 * nonFullNode, the nodes visited after this node are node '4','5' and '6' all of which are leaf nodes.
 *
 * We also need to check if there is any node with right child but with no left child. In this case, we simply return false.
 * https://www.ideserve.co.in/learn/check-whether-binary-tree-is-complete-tree-or-not
 */
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
