package com.philomath.trees.questions;

import java.util.ArrayList;
import java.util.List;

/**
 * https://www.geeksforgeeks.org/check-if-each-internal-node-of-a-bst-has-exactly-one-child/
 * https://www.ideserve.co.in/learn/check-whether-binary-tree-is-complete-tree-or-not
 */
public class CheckIfBSTHasOnlyOneInternalNode {
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
    public void createLeftTree(){
        this.root = new TreeNode(4,
                new TreeNode(3, new TreeNode(2, new TreeNode(1),null), null), null);
    }

    public void createRightTree(){
        this.root = new TreeNode(1,
                null, new TreeNode(2, null, new TreeNode(3, null, new TreeNode(4))));
    }

    public void createMixedOneNodeTree(){
        this.root = new TreeNode(1,null, new TreeNode(5,new TreeNode(2),null));
    }

    public void createTwoNodeTree(){
        this.root = new TreeNode(2,new TreeNode(1), new TreeNode(3));
    }

    /**
     * Since all the descendants of a node must either be larger or smaller than the node. We can do following for every node in a loop.
     * 1. Find the next preorder successor (or descendant) of the node.
     * 2. Find the last preorder successor (last element in pre[]) of the node.
     * 3. If both successors are less than the current node, or both successors are greater than the current node, then continue. Else, return false.
     * @return
     */
    public boolean checkBSTHasOneInternalNode(){
        List<Integer> preOrder = new ArrayList<>();
        getPreOrder(this.root,preOrder);
        for(int i = 0; i < preOrder.size()-1; i++){
            int nextDiff = preOrder.get(i)-preOrder.get(i+1);
            int lastDiff = preOrder.get(i)-preOrder.get(preOrder.size()-1);
            if(nextDiff*lastDiff < 0){
                return false;
            }
        }
        return true;
    }

    public boolean checkBSTHasOneNodeMinMax(){
        List<Integer> preOrder = new ArrayList<>();
        getPreOrder(this.root,preOrder);
        int minSoFar = preOrder.get(preOrder.size()-1);
        int maxSoFar = preOrder.get(preOrder.size()-1);
        for(int i = preOrder.size()-2; i >=0; i--){
            if(preOrder.get(i) < minSoFar){
                minSoFar = preOrder.get(i);
            }
            else if(preOrder.get(i) > maxSoFar){
                maxSoFar = preOrder.get(i);
            }
            else{
                return false;
            }
        }
        return true;
    }

    private void getPreOrder(TreeNode root, List<Integer> preOrder) {
        if(root == null) return;
        preOrder.add(root.data);
        getPreOrder(root.left, preOrder);
        getPreOrder(root.right,preOrder);
    }

    public static void main(String[] args) {
        CheckIfBSTHasOnlyOneInternalNode c =new CheckIfBSTHasOnlyOneInternalNode();
        c.createLeftTree();
        System.out.println(c.checkBSTHasOneInternalNode());
        c.createRightTree();
        System.out.println(c.checkBSTHasOneInternalNode());
        c.createMixedOneNodeTree();
        System.out.println(c.checkBSTHasOneInternalNode());
        c.createTwoNodeTree();
        System.out.println(c.checkBSTHasOneInternalNode());
        System.out.println("Solution with min max approach");
        c.createLeftTree();
        System.out.println(c.checkBSTHasOneNodeMinMax());
        c.createRightTree();
        System.out.println(c.checkBSTHasOneNodeMinMax());
        c.createMixedOneNodeTree();
        System.out.println(c.checkBSTHasOneNodeMinMax());
        c.createTwoNodeTree();
        System.out.println(c.checkBSTHasOneNodeMinMax());
    }
}
