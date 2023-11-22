package src.models;

import java.util.LinkedList;

public class AVLTree{
    private TreeNode root;
    private final LinkedList<TreeNode> nodes = new LinkedList<>();
    private int leftSize = 0;
    private int rightSize = 0;
    private int[][] grid;
    public AVLTree(int rootValue) {
        this.root = new TreeNode(rootValue);
        nodes.add(root);
    }
    public void addNode(int value) {
        insert(this.root, value);
        /*if (this.leftSize > this.rightSize + 1) {
            System.out.println("left rotation");
            TreeNode newRoot = this.root.getLeft();
            this.root.setLeft(newRoot.getRight());
            this.root = newRoot;
        } else if (this.rightSize > this.leftSize + 1) {
            System.out.println("Right rotation");
            TreeNode newRoot = this.root.getRight();
            this.root.setRight(newRoot.getLeft());
            this.root = newRoot;
        }*/
    }
    private void insert(TreeNode current, int value) {
        if (value < current.getValue()) {
            if (current.getLeft() == null) {
                current.setLeft(new TreeNode(value));
                this.nodes.add(current.getLeft());
                //this.leftSize++;
                System.out.println("inserted " + value);
            } else  {
                insert(current.getLeft(), value);
            }
        } else if (value > current.getValue()) {
            if (current.getRight() == null) {
                current.setRight(new TreeNode(value));
                this.nodes.add(current.getRight());
                //this.rightSize++;
                System.out.println("inserted " + value);
            } else {
                insert(current.getRight(), value);
            }
        } else {
            throw new IllegalArgumentException("Cannot insert value, which is already present in the AVL tree.");
        }
    }
    public LinkedList<TreeNode> getNodes() {
        return this.nodes;
    }
    public TreeNode getRoot() {
        return this.root;
    }

    @Override
    public String toString() {
        /*for (int i = 0; i < (int)Math.log(this.nodes.size()+1; i++) {
            for (int j = 0; j < )
        }*/
        return "";
    }
    private void updateGrid(TreeNode current, int x, int y) {
        this.grid[x][y] = current.getValue();
        if (current.getLeft() != null) {
            updateGrid(current.getLeft(), x-1, y+1);
        }
        if (current.getRight() != null) {
            updateGrid(current.getRight(), x+1, y+1);
        }
    }
    public void printTree(TreeNode current, boolean newline) {
        System.out.print(current + " ");
        if (newline) System.out.println();
        if (current.getLeft() != null) {
            printTree(current.getLeft(), false);
        }
        if (current.getRight() != null) {
            printTree(current.getRight(), newline);
        }
    }
}
