package cv03;

import java.util.*;

//{} []
public class VectorOperations {
    private static void printMatrix(int[][] matrix){
        for (int i = 0; i < matrix.length; i++) {
            for (int j = 0; j < matrix[0].length; j++) {
                System.out.printf("" + matrix[i][j] + " ");
            }
            System.out.println();
        }
        System.out.println();
    }
    
    private static int[][] multiplyMatrices(int[][] arr1,int[][] arr2) {
        int[][] multipliedArr = new int[arr1.length][arr2.length];
        int ctr = 0;

        for (int i = 0; i < multipliedArr.length; i++) {
            for (int j = 0; j < multipliedArr[i].length; j++) {
                for (int k = 0; k < multipliedArr.length; k++) {
                    multipliedArr[i][j] += arr1[i][k] * arr2[k][j];
                    ctr++;
                }
            }
        }
        System.out.println("Number of steps: " + ctr);

        return multipliedArr;
    }

    private static int[][] multilyBinaryMatrices(int[][] arr1, int[][] arr2) {
        int[][] multipliedArr = new int[arr1[0].length][arr2[0].length];

        for (int i = 0; i < arr1[0].length; i++) {
            for (int j = 0; j < arr2.length; j++) {
                multipliedArr[i][j] = 0;
                for (int k = 0; k < arr1.length; k++) {
                    multipliedArr[i][j] += arr1[i][k] * arr2[k][j];
                    if (multipliedArr[i][j] == 2) multipliedArr[i][j] = 0;
                }
            }
        }
        System.out.println();

        return multipliedArr;
    }

    private static int[][] calculateDistanceMatrix(int[][] binaryMatrix) {
        int length = binaryMatrix.length;
        int[][] distanceMatrix = new int[length][length];
        int[][] temporaryMatrix = binaryMatrix.clone();

        for (int i = 0; i < length; i++) {
            for (int m = 0; m < length; m++) {
                for (int n = 0; n < length; n++) {
                    if (binaryMatrix[m][n] == 1) {
                        distanceMatrix[m][n] = i + 1;
                    }
                }
            }
        binaryMatrix = multiplyMatrices(temporaryMatrix, binaryMatrix);
        printMatrix(binaryMatrix);
        }

        for (int m = 0; m < length; m++) {
            for (int n = 0; n < length; n++) {
                if (distanceMatrix[m][n] == 0) {
                    distanceMatrix[m][n] = Integer.MAX_VALUE;
                }
            }
        }
        return distanceMatrix;
    }

    private static int[][] FloydAlgorithm(int[][] matrix) {
        int[][] priceMatrix = new int[matrix.length][matrix.length];
        return priceMatrix;
    }

    public static void main(String[] args) {
        int[][] matrix1 = new int[2][2];
        int[][] matrix2 = new int[2][2];
        Random rand = new Random();
        for (int i = 0; i < 2; i++) {
            for (int j = 0; j < 2;j++) {
                matrix1[i][j] = rand.nextInt(10);
                matrix2[j][i] = rand.nextInt(10);
            }
        }
        printMatrix(matrix2);
        printMatrix(matrix1);
        int[][] matrix = multiplyMatrices(matrix2, matrix1);
        printMatrix(matrix);

        int[][] binaryMatrix1 = new int[3][3];
        int[][] binaryMatrix2 = new int[3][3];

        for (int i = 0; i < 3; i++) {
            for (int j = 0; j < 3;j++) {
                binaryMatrix1[i][j] = rand.nextInt(2);
                binaryMatrix2[i][j] = rand.nextInt(2);
            }
        }
        int[][] binaryMatrix = multilyBinaryMatrices(binaryMatrix1, binaryMatrix2);

        int[][] neighborhoodMatrix = new int[4][4];
        neighborhoodMatrix[0][1] = 1;
        neighborhoodMatrix[1][2] = 1;
        neighborhoodMatrix[2][3] = 1;
        printMatrix(neighborhoodMatrix);
        int[][] distanceMatrix = calculateDistanceMatrix(neighborhoodMatrix);
        printMatrix(distanceMatrix);
    }
    
}
