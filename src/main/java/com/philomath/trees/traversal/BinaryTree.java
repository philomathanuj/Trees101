package com.philomath.trees.traversal;

import java.util.LinkedList;
import java.util.Queue;

public class BinaryTree {
    Node root;

    public BinaryTree(Node root){
        this.root = root;
    }

    static class Node{
        int data;
        Node left;
        Node right;
        public Node(int data){
            this.data = data;
        }
        public Node(int data, Node left, Node right){
            this.data = data;
            this.left = left;
            this.right = right;
        }
    }

    public void preOrderTraversal(){
        preOrderTraversal(root);
        System.out.println();
    }

    private void preOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        System.out.print(root.data+" --> ");
        preOrderTraversal(root.left);
        preOrderTraversal(root.right);
    }

    public void inOrderTraversal(){
        inOrderTraversal(root);
        System.out.println();
    }

    private void inOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        inOrderTraversal(root.left);
        System.out.print(root.data+" --> ");
        inOrderTraversal(root.right);
    }

    public void postOrderTraversal(){
        postOrderTraversal(root);
        System.out.println();
    }

    private void postOrderTraversal(Node root) {
        if(root == null){
            return;
        }
        postOrderTraversal(root.left);
        postOrderTraversal(root.right);
        System.out.print(root.data+" --> ");
    }

    public void levelOrderTraversal(){
        levelOrderTraversal(root);
        System.out.println();
    }

    private void levelOrderTraversal(Node root) {
        if(root == null) return;
        Queue<Node> q  = new LinkedList<>();
        q.add(root);
        while(!q.isEmpty()){
            Node node = q.remove();
            System.out.print(node.data+" --> ");
            if(node.left != null){
                q.add(node.left);
            }
            if(node.right != null){
                q.add(node.right);
            }
        }
    }

    public static void main(String[] args) {
        BinaryTree bt = new BinaryTree(
                new Node(1, new Node(2, new Node(3), new Node(4)), new Node(5, new Node(6), new Node(7))));
        bt.preOrderTraversal();
        bt.inOrderTraversal();
        bt.postOrderTraversal();
        bt.levelOrderTraversal();
    }

}
