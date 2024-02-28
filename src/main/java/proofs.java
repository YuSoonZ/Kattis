import java.util.*;
import java.io.*;

public class proofs {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);
        int line = 1;
        HashSet<String> proven = new HashSet<>();

        for (int i = 0; i < n; i++) {
            token = br.readLine().split("-> ");
            //System.out.println(token[0] + "->" + token[1]);
            boolean correct = true;
            String[] s = token[0].split(" ");
            //System.out.println(s.length);
            for (int j = 0; j < s.length; ++j) {
                if ((s[j].length() > 0) && !proven.contains(s[j])) {
                    correct = false;
                    break;
                }
            }
            if (!correct) {
                System.out.println(line);
                System.exit(0);
            } else {
                proven.add(token[1]);
            }
            line += 1;
        }
        System.out.println("correct");
    }
}
