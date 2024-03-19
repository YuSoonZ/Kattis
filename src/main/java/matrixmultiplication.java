import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.Arrays;
import java.util.Random;

public class matrixmultiplication {
    public static void main(String[] args) throws IOException {
        final String WRONG_DIMENSION = "Inner matrix dimensions must agree";
        final String WRONG_ANSWER = "WA";
        final String RIGHT_ANSWER = "AC";
        final int ITERATIONS = 10;

        PrintWriter printWriter = new PrintWriter(System.out);
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        int TC = Integer.parseInt(br.readLine());

        for (int i = 0; i < TC; i++) {
            br.readLine();
            String[] temp = br.readLine().split(" ");
            int n = Integer.parseInt(temp[0]);
            int x = Integer.parseInt(temp[1]);
            int y = Integer.parseInt(temp[2]);
            int m = Integer.parseInt(temp[3]);

            if (x != y) {
                printWriter.println(WRONG_DIMENSION);
                for (int j = 0; j < n + y + n; j++) {
                    br.readLine();
                }
            } else {
                int[][] matrixA = new int[n][x];
                for (int j = 0; j < n; j++) {
                    String[] row = br.readLine().split(" ");
                    for (int k = 0; k < x; k++) {
                        matrixA[j][k] = Integer.parseInt(row[k]);
                    }
                }
                int[][] matrixB = new int[y][m];
                for (int j = 0; j < y; j++) {
                    String[] row = br.readLine().split(" ");
                    for (int k = 0; k < m; k++) {
                        matrixB[j][k] = Integer.parseInt(row[k]);
                    }
                }
                int[][] matrixC = new int[n][m];
                for (int j = 0; j < n; j++) {
                    String[] row = br.readLine().split(" ");
                    for (int k = 0; k < m; k++) {
                        matrixC[j][k] = Integer.parseInt(row[k]);
                    }
                }

                boolean isCorrect = isProduct(matrixA, matrixB, matrixC, ITERATIONS);
                if (isCorrect) {
                    printWriter.println(RIGHT_ANSWER);
                } else {
                    printWriter.println(WRONG_ANSWER);
                }
            }
        }
        printWriter.close();
    }

    private static boolean isProduct(int[][] A, int[][] B, int[][] C, int iterations) {
        int m = B[0].length;

        for (int i = 0; i < iterations; i++) {
            int[] r = generateRandomVector(m);
            int[] Br = multiplyMatrixVector(B, r);
            int[] AxBr = multiplyMatrixVector(A, Br);
            int[] Cr = multiplyMatrixVector(C, r);

            if (!Arrays.equals(AxBr, Cr)) {
                return false;
            }
        }
        return true;
    }

    private static int[] generateRandomVector(int n) {
        Random random = new Random();
        int[] vector = new int[n];
        for (int i = 0; i < n; i++) {
            vector[i] = random.nextInt(2);
        }
        return vector;
    }

    private static int[] multiplyMatrixVector(int[][] matrix, int[] vector) {
        int m = matrix.length;
        int n = matrix[0].length;
        int[] result = new int[m];
        for (int i = 0; i < m; i++) {
            int sum = 0;
            for (int j = 0; j < n; j++) {
                sum += matrix[i][j] * vector[j];
            }
            result[i] = sum;
        }
        return result;
    }
}

