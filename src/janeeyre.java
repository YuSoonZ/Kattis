import java.io.*;
import java.util.*;

public class janeeyre {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] str1 = br.readLine().split(" ");
        int n = Integer.parseInt(str1[0]);  // Init number of books
        int m = Integer.parseInt(str1[1]);  // No of books friends will give
        int k = Integer.parseInt(str1[2]);  // pages on Jane
        PriorityQueue<String> pqInit = new PriorityQueue<>((s1, s2) -> {
            int b = 0;
            for (int i = 0; i < 20; i++) {
                char first = s1.charAt(i);
                char second = s2.charAt(i);
                int result = Character.compare(first, second);
                if (result != 0) {
                    b = result;
                    break;
                }
            }
            return b;
        });
        PriorityQueue<String> pqAdd = new PriorityQueue<>((s1, s2) -> {
            int first = Integer.parseInt(s1.split(" ")[0]);
            int second = Integer.parseInt(s2.split(" ")[0]);
            return Integer.compare(first, second);
        });
        final String jane = "\"Jane Eyre\" " + k;

        pqInit.add(jane);

        for (int i = 0; i < n; i++) {
            String input = br.readLine();
            pqInit.add(input);
        }

        for (int j = 0; j < m; j++) {
            String input = br.readLine();
            pqAdd.add(input);
        }

        long result = 0;

        while (true) {
            // can do a conditional loop to check for time while the toadd pq is not empty
            // and everytime it returns true/aka to add, then we just add
            for (int i = 0; i < pqAdd.size(); i++) {
                String check = checkTime(result, pqAdd).strip();
                //System.out.println(check);
                if (!check.equals("")) {
                    pqInit.add(check);
                } else {
                    break;
                }
            }
           // System.out.println(pqInit.peek());
            String curr = pqInit.remove();
            //System.out.println(curr);
            String[] currArr = curr.split(" ");
            int len = currArr.length;
            long pages = Long.parseLong(currArr[len - 1]);
            result += pages;
            //System.out.println(result);
            if (curr.equals(jane)) {
                break;
            }
        }

        System.out.println(result);
    }

    public static String checkTime(long curr, PriorityQueue<String> pqAdd) {
        long time = 0;
        String result = "";
        String top = pqAdd.peek();
        if (top != null) {
            time = Long.parseLong(top.split(" ")[0]);
            if (curr >= time) {
                String toAdd = pqAdd.remove();
                result = toAdd.replace(Long.toString(time), "");
            }
        }
        return result;
    }
}

