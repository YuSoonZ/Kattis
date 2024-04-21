import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class artichoke {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] input = br.readLine().split(" ");
        int p = Integer.parseInt(input[0]), a = Integer.parseInt(input[1]), b = Integer.parseInt(input[2]),
                c = Integer.parseInt(input[3]), d = Integer.parseInt(input[4]), n = Integer.parseInt(input[5]);
        double[] prices = new double[n];
        for (int i = 1; i <= n; i++) {
            double price = p * (Math.sin(a * i + b) + Math.cos(c * i + d) + 2);
            prices[i - 1] = price;
        }
        double result = 0;
        double maxValue = prices[0];
        for (int i = 1; i < prices.length; i++) {
            double temp1 = prices[i];
            if (maxValue - temp1 > result) {
                result = maxValue - temp1;
            } else if (temp1 > maxValue) {
                maxValue = temp1;
            }
        }
        System.out.println(result);
    }
}