import java.util.HashSet;
import java.util.Scanner;
import java.util.Set;

public class onedfroggereasy {
    public static void main(String[] args) {
        final String MAGIC = "magic";
        final String LEFT = "left";
        final String RIGHT = "right";
        final String CYCLE = "cycle";
        Scanner sc = new Scanner(System.in);
        int n = sc.nextInt(), s = sc.nextInt() - 1, m = sc.nextInt();
        int[] arr = new int[n];
        for (int i = 0; i < n; i++) {
            arr[i] = sc.nextInt();
        }

        int hops = 0;
        HashSet<Integer> visited = new HashSet<>();
        int currPos = s;

        while (true) {
            if (arr[currPos] == m) {
                System.out.println(MAGIC);
                System.out.println(hops);
                break;
            } else if (arr[currPos] + currPos >= n) {
                System.out.println(RIGHT);
                hops++;
                System.out.println(hops);
                break;
            } else if (arr[currPos] + currPos < 0) {
                System.out.println(LEFT);
                hops++;
                System.out.println(hops);
                break;
            } else if (visited.contains(arr[currPos] + currPos)) {
                System.out.println(CYCLE);
                hops++;
                System.out.println(hops);
                break;
            } else {
                visited.add(currPos);
                hops++;
                int hopLen = arr[currPos];
                currPos += hopLen;
            }
        }
    }
}
