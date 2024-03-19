import java.util.Scanner;

public class jobbyte {
    public static void main(String[] args) {
        Scanner keyboard = new Scanner(System.in);
        int N = keyboard.nextInt();
        int[] arr = new int[N];

        for (int i = 0; i < N; i++) {
            arr[i] = Integer.parseInt(keyboard.next());
        }

        int result = 0;
        int i = 0;
        while (true) {
            if (arr[i] != i + 1) {
                int temp = arr[i];
                arr[i] = arr[temp - 1];
                arr[temp - 1] = temp;
                result++;
            } else {
                i++;
            }
            if (i == N - 1) {
                break;
            }
        }
        System.out.println(result);
    }
}

