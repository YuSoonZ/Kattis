import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;

public class rijeci {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter pw = new PrintWriter(System.out);

        int K = Integer.parseInt(br.readLine());
        int numA = 1;
        int numB = 0;
        while (K > 0) {
            int tempA = 0;
            int tempB = 0;
            if (numA != 0) {
                // Increase number of B's by there are number of As
                tempB += numA;
                numA = 0;
            }
            if (numB != 0) {
                // numB does not change
                // Increase number of As
                tempA += numB;
            }
            numA += tempA;
            numB += tempB;
            K--;
        }

        pw.println(numA + " " + numB);
        pw.close();
    }
}
