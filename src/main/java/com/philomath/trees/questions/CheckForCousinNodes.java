package com.philomath.trees.questions;

/**
 * 1: If node A == B return false as a node cannot be cousin of itself.
 * 2: Check nodes A and B are not siblings and
 * 3: Check nodes A and B are on same level.
 *
 * How to find if 2 nodes are siblings:
 * 1. If A and B are left and right children of the root, then they are siblings.
 * 2. Else check Step 1 in left and right subtrees.
 * 3. If the condition in Step 1 is not true for any node, then the nodes are not siblings.
 */
public class CheckForCousinNodes {
    TreeNode root;

    TreeNode node4 = new TreeNode(4);
    TreeNode node6 = new TreeNode(6);
    TreeNode node5 = new TreeNode(5);

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
        this.root = new TreeNode(1,
                new TreeNode(2,
                        node4, node5),
                new TreeNode(3, node6, new TreeNode(7)));
    }

    public boolean isCousin(TreeNode node1, TreeNode node2){
        if(node1 == node2){
            return false;
        }
        if(!isSibling(node1, node2) && getLevel(node1) == getLevel(node2)){
            return true;
        }
        return false;
    }

    private int getLevel(TreeNode node) {
        return getLevel(root, node,0);
    }

    private int getLevel(TreeNode root, TreeNode node, int level) {
        if(root == node || root == null){
            return level;
        }
        if(root.left != null){
            level = getLevel(root.left, node, level+1);
        }
        if(level != 0){
            return level;
        }
        else{
            level = getLevel(root.right, node, level+1);
        }
        return level;

    }


    private boolean isSibling(TreeNode node1, TreeNode node2) {
        return isSibling(node1, node2, this.root);
    }

    private boolean isSibling(TreeNode node1, TreeNode node2, TreeNode root) {
        if(root == null) return false;
        if((node1 == root.left && node2 == root.right) ||
                (node1 == root.right && node2 == root.left)
            || isSibling(node1,node2, root.left)
            || isSibling(node1, node2, root.right)){
            return true;
        }
        return false;
    }

    public static void main(String[] args) {
        CheckForCousinNodes c = new CheckForCousinNodes();
        c.createTree();
        System.out.println(c.isCousin(c.node4, c.node5));
        System.out.println(c.isCousin(c.node5, c.node6));
    }

}
