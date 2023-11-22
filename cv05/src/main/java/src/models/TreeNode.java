package src.models;

public class TreeNode {
    private final int value;
    private TreeNode left = null;
    private TreeNode right = null;
    public TreeNode(int value) {
        this.value = value;
    }
    public int getValue() {
        return this.value;
    }
    public TreeNode getLeft() {
        return this.left;
    }
    public void setLeft(TreeNode left) {
        this.left = left;
    }
    public TreeNode getRight() {
        return this.right;
    }
    public void setRight(TreeNode right) {
        this.right = right;
    }

    @Override
    public String toString() {
        return Integer.toString(this.value);
    }
}
