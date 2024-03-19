import java.util.*;
import java.io.*;

public class coursescheduling {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        HashMap<String, ArrayList<String>> hashMap = new HashMap<>(N / 2);
        //HashMap<String, Integer> hashMap2 = new HashMap<>(N / 2);
        TreeMap<String, Integer> treeMap = new TreeMap<>();

        String[] token;
        for (int i = 0; i < N; i++) {
            token = br.readLine().split(" ");
            String first = token[0];
            String second = token[1];
            String course = token[2];
            String name = first + second;

            if (!treeMap.containsKey(course)) {
                treeMap.put(course, 0);
            }

            if (!hashMap.containsKey(name)) {
                ArrayList<String> arr = new ArrayList<>();
                arr.add(course);
                hashMap.put(name, arr);
                int curr = treeMap.get(course);
                treeMap.put(course, curr + 1);
            } else {
                ArrayList<String> temp = hashMap.get(name);
                if (!temp.contains(course)) {
                    temp.add(course);
                    hashMap.put(name, temp);
                    int curr = treeMap.get(course);
                    treeMap.put(course, curr + 1);
                }
            }
        }

        Object[] set = treeMap.keySet().toArray();
        Object[] collection = treeMap.values().toArray();
        for (int j = 0; j < treeMap.size(); j++) {
            System.out.println(set[j] + " " + collection[j]);
        }
    }
}

