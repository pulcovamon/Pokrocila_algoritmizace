package src.models;

public class Edge {
    private final int index;
    private  final Node fromNode;
    private  final Node toNode;
    public Edge(int index, Node fromNode, Node toNode) {
        this.index = index;
        this.fromNode = fromNode;
        this.toNode = toNode;
    }
    public int getIndex() {
        return this.index;
    }
    public Node getFromNode() {
        return this.fromNode;
    }
    public Node getToNode() {
        return this.toNode;
    }
}
