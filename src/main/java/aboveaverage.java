import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;

public class aboveaverage {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int C = Integer.parseInt(br.readLine());

        for (int i = 0; i < C; i++) {
            String[] arr = br.readLine().split(" ");
            int result = 0;
            int num = Integer.parseInt(arr[0]);
            ArrayList<Integer> inputs = new ArrayList<>();
            for (int j = 1; j < arr.length; j++) {
                int temp = Integer.parseInt(arr[j]);
                inputs.add(temp);
                result += temp;
            }
            double avg = (double) result / num;
            int aboveAvg = 0;
            for (int j = 0; j < inputs.size(); j++) {
                if (inputs.get(j) > avg) {
                    aboveAvg++;
                }
            }
            double value = (double) aboveAvg / num * 100;
            String formattedValue = String.format("%.3f", value);
            System.out.println(formattedValue + "%");
        }
    }
}
