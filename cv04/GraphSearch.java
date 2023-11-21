package cv04;
import java.util.LinkedList;

public class GraphSearch {

    private static int[][] createNeighborhoodMatrix() {
        int[][] neighborhoodMatrix = new int[][]{   {0, 1, 1, 0, 0, 0, 0},
                                                    {1, 0, 1, 0, 0, 0, 0},
                                                    {1, 1, 0, 1, 0, 0, 0},
                                                    {0, 0, 1, 0, 0, 0, 0},
                                                    {0, 0, 0, 0, 0, 1, 0},
                                                    {0, 0, 0, 0, 1, 0, 0},
                                                    {0, 0, 0, 0, 0, 0, 0}};
        return neighborhoodMatrix;
    }

    private static int[][] createMatrix() {
        int[][] matrix = new int[][]{   {0, 5, 8, 0},
                                        {5, 0, 4, 0},
                                        {1, 3, 0, 7},
                                        {0, 0, 2, 0}};
        return matrix;
    }

    public static void BFS(int[][] matrix, int start) {
        LinkedList<Integer> fifo = new LinkedList<>();
        LinkedList<Integer> explored = new LinkedList<>();
        int exploredNow;
        fifo.addLast(start);
        int[] nodeNeighbours;
        while (!fifo.isEmpty()) {
            exploredNow = fifo.poll();
            nodeNeighbours = matrix[exploredNow];
            explored.add(exploredNow);
            for (int i = 0; i < nodeNeighbours.length; i++) {
                if (nodeNeighbours[i] == 1 && !fifo.contains(i) && !explored.contains(i)) {
                    fifo.addLast(i);
                    System.out.println("Discovered: " + i);
                }
            }
        }
    }

    public static void DFS(int[][] matrix, int start) {
        LinkedList<Integer> lifo = new LinkedList<>();
        LinkedList<Integer> explored = new LinkedList<>();
        int exploredNow;
        lifo.addFirst(start);
        int[] nodeNeighbours;
        while (!lifo.isEmpty()) {
            exploredNow = lifo.poll();
            nodeNeighbours = matrix[exploredNow];
            explored.add(exploredNow);
            for (int i = 0; i < nodeNeighbours.length; i++) {
                if (nodeNeighbours[i] == 1 && !lifo.contains(i) && !explored.contains(i)) {
                    lifo.addFirst(i);
                    System.out.println("Discovered: " + i);
                }
            }
        }
    }

    private static int[][] getListOfEdges() {
        int[][] listOfEdges = new int[][] {
            {1, 2, 4}, {4, 1, 5}, {4, 3, 2}, {2, 3, 5}, {3, 5, 10}, {5, 2, 2}, {2, 7, 1}, {7, 8, 1}, {8, 5, 1}, {1, 6, 30}
        };
        return listOfEdges;
    }

    public static void BellmanFord(int[][] listOfEdges, int numberOfNodes) {
        int[] distanceFromZeroNode = new int[numberOfNodes];
        distanceFromZeroNode[0] = 0;
        int[] previousDistanceList = new int[numberOfNodes];
        for (int i = 1; i < numberOfNodes; i++) distanceFromZeroNode[i] = Integer.MAX_VALUE;
        while (previousDistanceList != distanceFromZeroNode) {
            for (int[] edge:listOfEdges) {
                if (distanceFromZeroNode[edge[0]-1] + edge[2] < distanceFromZeroNode[edge[1]-1] && distanceFromZeroNode[edge[0]-1] + edge[2] > 0) {
                    distanceFromZeroNode[edge[1]-1] = distanceFromZeroNode[edge[0]-1] + edge[2];
                }
            }
            previousDistanceList = distanceFromZeroNode;
        }
        for (int i = 0; i < numberOfNodes; i++) {
            System.out.printf(i+1 + ": " + distanceFromZeroNode[i] + "\n");
        }
    }

    public static void Dijkstra(int[][] matrix, int start) {
        LinkedList<Integer> fifo = new LinkedList<>();
        LinkedList<Integer> explored = new LinkedList<>();
        int[] dijkstraResult = new int[matrix.length];
        for (int i = 1; i < matrix.length; i++) dijkstraResult[i] = Integer.MAX_VALUE;
        dijkstraResult[start] = 0;
        int exploredNow;
        fifo.addLast(start);
        int[] nodeNeighbours;
        while (!fifo.isEmpty()) {
            exploredNow = fifo.poll();
            nodeNeighbours = matrix[exploredNow];
            explored.add(exploredNow);
            for (int i = 0; i < nodeNeighbours.length; i++) {
                if (nodeNeighbours[i] == 1 && !fifo.contains(i) && !explored.contains(i)) {
                    fifo.addLast(i);
                    if (dijkstraResult[i] == Integer.MAX_VALUE) {
                        dijkstraResult[i] = nodeNeighbours[i];
                    } else {
                        dijkstraResult[i] += nodeNeighbours[i];
                    }
                }
            }
        }
        for (int i = 0; i < matrix.length; i++) {
            System.out.println(i + ": " + dijkstraResult[i] + "\n");
        }
    }


    public static void main(String[] args) {
        int[][] matrix = createNeighborhoodMatrix();
        System.out.println("BFS");
        BFS(matrix, 0);
        System.out.println();
        BFS(matrix, 4);
        System.out.println();
        System.out.println("DFS");
        DFS(matrix, 0);
        System.out.println();
        DFS(matrix, 4);

        System.out.println("Bellman Ford");
        BellmanFord(getListOfEdges(), 8);

        System.out.println("Dijkstra");
        Dijkstra(createMatrix(), 0);
    }
    
}
