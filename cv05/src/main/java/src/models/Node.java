package src.models;

public class Node {
    private final int index;
    public Node(int index) {
        this.index = index;
    }
    public int getIndex() {
        return this.index;
    }

    @Override
    public String toString() {
        return Integer.toString(this.index);
    }
}
