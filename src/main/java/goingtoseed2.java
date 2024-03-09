import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;

public class goingtoseed2 {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        Pair<Integer, Integer> pair = new Pair<>(1, N + 1);

        while (true) {
            int y = (pair.getFirst() + pair.getSecond()) / 2;   // Midpoint of pair
            int x = (pair.getFirst() + y) / 2;      // 1Q
            int z = (pair.getSecond() + y) / 2;     // 3Q

            System.out.println("Q " + pair.getFirst() + " " + (y - 1) + " " + x + " " + (z - 1));
            System.out.flush();

            String[] temp = br.readLine().split(" ");
            int w1 = Integer.parseInt(temp[0]);
            int w2 = Integer.parseInt(temp[1]);

            if (w1 == 1 && w2 == 1) {
                // Intersection
                pair.first = x;
                pair.second = y;
            } else if (w1 == 0 && w2 == 1) {
                // Right side
                pair.first = y;
                pair.second = z;
            } else if (w1 == 1 && w2 == 0) {
                // Left side
                pair.second = x;
            } else {
                // None, out of range
                pair.first = z;
            }

            if (pair.second - pair.first == 1) {
                System.out.println("A " + pair.first);
                System.out.flush();
                break;
            } else {
                pair.first = Math.max(pair.first - 1, 1);
                pair.second = Math.min(pair.second + 1, N + 1);
            }
        }
    }

    public static class Pair<K, V> {
        private K first;
        private V second;

        public Pair(K first, V second) {
            this.first = first;
            this.second = second;
        }

        public K getFirst() {
            return first;
        }

        public V getSecond() {
            return second;
        }
    }
}
