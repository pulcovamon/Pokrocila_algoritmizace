import src.models.AVLTree;
import src.models.TreeNode;

import java.util.LinkedList;

public class Main {
    public static void main(String[] args) {
        /*int[][] matrix = {
                {0, 0, 0, 0, 0, 0, 0},
                {1, 0, 1, 0, 0, 0, 0},
                {1, 1, 0, 1, 0, 0, 0},
                {0, 0, 1, 0, 0, 0, 0},
                {0, 0, 0, 0, 0, 1, 0},
                {0, 0, 0, 0, 1, 0, 0},
                {0, 0, 0, 0, 0, 0, 0}};
        Graph myGraph = new Graph(matrix);
        myGraph.bfs(0);*/
        AVLTree tree = new AVLTree(10);
        tree.addNode(20);
        tree.addNode(5);
        tree.addNode(25);
        tree.addNode(15);
        tree.addNode(17);
        tree.addNode(12);
        LinkedList<TreeNode> nodes = tree.getNodes();
        System.out.println(tree);
        //tree.printTree(tree.getRoot(), true);
    }
}
