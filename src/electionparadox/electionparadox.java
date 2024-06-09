import java.util.Arrays;
import java.util.Collections;
import java.util.Scanner;

public class electionparadox {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int N = sc.nextInt();
        Integer[] arr = new Integer[N];
        for (int i = 0; i < N; i++) {
            arr[i] = sc.nextInt();
        }

        Arrays.sort(arr, Collections.reverseOrder());

        int maxWin = Math.floorDiv(N, 2);
        int result = 0;
        for (int i = 0; i < N; i++) {
            if (i < maxWin) {
                result += arr[i];
            } else {
                int temp = arr[i];
                result += (Math.floorDiv(temp, 2));
            }
        }
        System.out.println(result);
    }
}
