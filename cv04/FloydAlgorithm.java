package cv04;

public class FloydAlgorithm {
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("" + matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }

    private static int[][] generateD(int numberOfNodes) {
        int[][] priceMatrix = new int[numberOfNodes][numberOfNodes];

        for (int i = 0; i < numberOfNodes; i++) {
            for (int j = 0; j < numberOfNodes; j++) {
                priceMatrix[i][j] = Integer.MAX_VALUE;
                if (i == j) priceMatrix[i][j] = 0;
            }
        }
        priceMatrix[0][1] = 4;
        priceMatrix[1][2] = 4;
        priceMatrix[1][3] = 3;
        priceMatrix[3][0] = 5;
        priceMatrix[3][2] = 1;
        priceMatrix[2][4] = 8;
        priceMatrix[4][1] = 7;

        return priceMatrix;
    }

    private static int[][] nextStep(int[][] matrix, int k) {
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix.length; j++) {
                if ((matrix[i][j] > matrix[i][k] + matrix[k][j]) && (matrix[i][k] + matrix[k][j] > 0)) matrix[i][j] = matrix[i][k] + matrix[k][j];
            }
        }
        return matrix;
    }

    public static void main(String[] args) {
        int numberOfNodes = 5;
        int[][] matrix = generateD(numberOfNodes);
        printMatrix(matrix);

        for (int i = 0; i < numberOfNodes; i++) {
            matrix = nextStep(matrix, i);
        }

        printMatrix(matrix);
    }
}
