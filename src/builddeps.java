import java.util.*;
import java.io.*;

public class builddeps {
    private static HashMap<String, Boolean> visited = new HashMap<>();
    private static HashMap<String, ArrayList<String>> hashMap = new HashMap<>();
    private static ArrayList<String> toposort = new ArrayList<>();

    private static void dfs(String u) {
        visited.put(u, true);
        if (hashMap.get(u) != null) {
            for (String v : hashMap.get(u)) {
                if (!visited.get(v)) {
                    dfs(v);
                }
            }
        }
        toposort.add(u);
    }

    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);
        int N = Integer.parseInt(br.readLine());

        hashMap = new HashMap<>();
        visited = new HashMap<>();

        String[] token;
        for (int i = 0; i < N; i++) {
            token = br.readLine().split(":");
            String fileName = token[0];
            visited.put(fileName, false);
//            if (!hashMap.containsKey(fileName)) {
//                hashMap.put(fileName, new ArrayList<>());
//            }

            if (token.length > 1) {
                String substring = token[1].substring(1);
                String[] fileDependents = substring.split(" ");

                for (String fileDependent : fileDependents) {
                    visited.put(fileDependent, false);
                    hashMap.computeIfAbsent(fileDependent, k -> new ArrayList<>());
                    hashMap.get(fileDependent).add(fileName);
                }
            }
        }

        String toChange = br.readLine();
        toposort = new ArrayList<>();

        dfs(toChange);

        for (int i = toposort.size() - 1; i >= 0; --i) {
            printWriter.println(toposort.get(i));
        }
        printWriter.close();
    }
}
