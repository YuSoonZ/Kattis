import java.io.*;
import java.util.*;

public class speedrun {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int G = Integer.parseInt(token[0]);
        int N = Integer.parseInt(token[1]);
        ArrayList<List<Integer>> sortedArr = new ArrayList<>();
        ArrayList<List<Integer>> temp = new ArrayList<>();
        final int max = 24000;

        for (int i = 0; i < N; i++) {
            token = br.readLine().split(" ");
            temp.add(Arrays.asList(Integer.parseInt(token[0]), Integer.parseInt(token[1])));
        }
        temp.sort(Comparator.comparingInt((List<Integer> pair) -> pair.get(1)).thenComparing(pair -> pair.get(0)));
        sortedArr.addAll(temp);

        int iteration = 0;
        int time = 0;
        int counter = 0;
        while (counter < G) {
            if (iteration == sortedArr.size()) {
                break;
            }
            List<Integer> curr = sortedArr.get(iteration);
            if (counter == 0) {
                //int start = curr.get(0);
                int end = curr.get(1);
                if (end <= max) {
                    counter++;
                    time = end;
                }
            } else {
                int start = curr.get(0);
                int end = curr.get(1);
                if (start >= time && end <= max) {
                    counter++;
                    time = end;
                }
            }
            iteration++;
        }

        if (counter == G) {
            System.out.println("YES");
        } else {
            System.out.println("NO");
        }
    }
}
