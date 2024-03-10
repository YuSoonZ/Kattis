import java.util.*;
import java.io.*;

public class weakvertices {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        String[] token;

        // To add the values into the AM
        while (true) {
            int n = Integer.parseInt(br.readLine());
            if (n == -1) {
                break;
            }
            int[][] AM = new int[n][n];
            for (int i = 0; i < n; i++) {
                token = br.readLine().split(" ");
                for (int j = 0; j < n; j++) {
                    AM[i][j] = Integer.parseInt(token[j]);
                }
            }

            // Now to check for weak vertices
            for (int i = 0; i < n; i++) {
                boolean weak = true;
                for (int j = 0; j < n; j++) {
                    if (AM[i][j] == 0) {
                        continue;
                    }
                    for (int k = 0; k < n; k++) {
                        if (AM[k][j] == 1 && AM[i][k] == 1) {
                            weak = false;
                            break;
                        }
                    }
                    if (!weak) {
                        break;
                    }
                }
                if (weak) {
                    printWriter.print(i + " ");
                }
            }
            printWriter.println();
        }
        printWriter.close();
    }
}