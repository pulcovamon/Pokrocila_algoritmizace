package src.models;

import java.util.LinkedList;
import java.util.Queue;

public class Graph {
    private LinkedList<Node> nodes = new LinkedList<>();
    private LinkedList<Edge> edges = new LinkedList<>();
    public Graph(int[][] matrix) {
        int edgeIndex = 0;
        Node fromNode = null;
        Node toNode = null;
        for (int i = 0; i < matrix[0].length; i++) {
            this.nodes.add(new Node(i));
        }
        for (int i = 0; i < matrix[0].length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if (matrix[i][j] == 1) {
                    for (Node node : this.nodes) {
                        if (node.getIndex() == i) {
                            fromNode = node;
                        } else if (node.getIndex() == j) {
                            toNode = node;
                        }
                    }
                    if (fromNode == null || toNode == null) {
                        throw new IllegalStateException("There are some missing nodes.");
                    }
                    this.edges.add(new Edge(edgeIndex, fromNode, toNode));
                    edgeIndex++;
                    fromNode = null;
                    toNode = null;
                }
            }
        }
    }
    public void bfs(int startIndex) {
        Queue<Node> waiting = new LinkedList<>();
        LinkedList<Node> explored = new LinkedList<>();
        for (src.models.Node node : this.nodes) {
            if (node.getIndex() == startIndex) {
                waiting.add(node);
            }
        }
        while (!waiting.isEmpty()) {
            for (Edge edge : this.edges) {
                if (edge.getFromNode() == waiting.peek() && !explored.contains(edge.getToNode()) && !waiting.contains(edge.getToNode())) {
                    waiting.add(edge.getToNode());
                    System.out.println("Explored: " + edge.getToNode().toString());
                }
            }
            explored.add(waiting.poll());
        }
    }
    public LinkedList<Node> getNodes() {
        return this.nodes;
    }
    public LinkedList<Edge> getEdges() {
        return this.edges;
    }
}
