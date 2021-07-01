package com.philomath.trees.questions;

public class NodesWithoutSibling {
      class TreeNode{
          int data;
        TreeNode left;
        TreeNode right;
        public TreeNode(int data){
            this.data = data;
        }

          public void printNodesWithoutSiblings(){
              printNodesWithoutSiblings(this);
          }

          /**
           * Nodes without sibling are nodes that have either left child
           * and right child. This problem can be solved easily
           * with inorder traversal
           */
          private void printNodesWithoutSiblings(TreeNode root){
              if(root == null){
                  return;
              }
              if(root.left == null && root.right != null){
                  System.out.println(root.right.data);
              }
              if(root.right == null && root.left != null){
                  System.out.println(root.left.data);
              }
              printNodesWithoutSiblings(root.left);
              printNodesWithoutSiblings(root.right);
          }

        }

    public static void main(String[] args) {
         NodesWithoutSibling n = new NodesWithoutSibling();
        NodesWithoutSibling.TreeNode root = n.new TreeNode(1);
        root.left = n.new TreeNode(2);
        root.left.left = n.new TreeNode(4);
        root.right = n.new TreeNode(3);
        root.right.right = n.new TreeNode(5);
        root.printNodesWithoutSiblings();
    }


}
