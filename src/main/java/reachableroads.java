import java.io.*;
import java.util.*;

class reachableroads {
    private static ArrayList<Boolean> visited;
    private static ArrayList<ArrayList<Integer>> AL;

    private static void dfs(int u) {
        visited.set(u, true);
        for (Integer v : AL.get(u))
            if (!visited.get(v)) {
                dfs(v);
            }
    }

    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int TC = sc.nextInt();
        while (TC-- > 0) {
            int n = sc.nextInt();
            int m = sc.nextInt();

            AL = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                AL.add(new ArrayList<Integer>());
            while (m-- > 0) {
                int u = sc.nextInt(), v = sc.nextInt();
                AL.get(u).add(v);
                AL.get(v).add(u);
            }

            int CC = 0;
            visited = new ArrayList<>();
            for (int i = 0; i < n; ++i)
                visited.add(false);
            for (int i = 0; i < n; ++i) {
                if (!visited.get(i)) {
                    ++CC;
                    dfs(i);
                }
            }
            System.out.println(CC - 1);
        }
    }
}