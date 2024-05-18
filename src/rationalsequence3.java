import java.io.*;
import java.util.*;

public class rationalsequence3 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int P = Integer.parseInt(br.readLine());

        for (int i = 0; i < P; i++) {
            String[] arr = br.readLine().split(" ");
            int K = Integer.parseInt(arr[0]);
            long N = Integer.parseInt(arr[1]);
            Stack<Character> stack = new Stack<>();
            while (N > 1) {
                if (moveDown((moveUp(N))) == N) {
                    stack.push('L');
                } else {
                    stack.push('R');
                }

                N = moveUp(N);
            }

            int p = 1, q = 1;
            while (!stack.isEmpty()) {
                if (stack.peek() == 'L') {
                    q += p;
                } else {
                    p += q;
                }
                stack.pop();
            }

            System.out.println(K + " " + p + "/" + q);
        }


    }

    public static long moveUp(long i) {
        return i / 2;
    }

    public static long moveDown(long i) {
        return i * 2;
    }

    public static long moveSide(long i) {
        return i * 2 + 1;
    }
}

