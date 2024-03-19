import java.io.*;
import java.util.*;

public class sim {
    public static void main(String[] args) throws IOException {
        BufferedReader reader = new BufferedReader(new InputStreamReader(System.in));
        int T = Integer.parseInt(reader.readLine());
        ArrayList<String> str = new ArrayList<>();

        for (int i = 0; i < T; i++) {
            str.add(reader.readLine());
        }

        for (int i = 0; i < T; i++) {
            String temp = str.get(i);
            LinkedList<Character> result = improved(temp);
            ListIterator<Character> ls = result.listIterator();
            StringBuilder toPrint = new StringBuilder();
//            String str2 = "";
//            long start = System.nanoTime();
            while (ls.hasNext()) {
                toPrint.append(ls.next());
//                str2 += ls.next();
            }
//            long finish = System.nanoTime();
//            long timeTaken = finish - start;
//            System.out.println(timeTaken);
            System.out.println(toPrint);
        }
    }

    public static LinkedList<Character> improved(String str) {
        int size = str.length();
        int counter = 0;
        int pointer = 0;
        LinkedList<Character> ll = new LinkedList<>();
        int dllSize = 1;
        while (counter < size) {
            char temp = str.charAt(counter);
            if (temp == '<') {
                if (dllSize != 1 && pointer != 0) {
                    ll.remove(pointer - 1);
                    pointer--;
                    dllSize--;
                }
            } else if (temp == '[') {
                pointer = 0;
            } else if (temp == ']') {
                pointer = dllSize - 1;
            } else {
                dllSize++;
                ll.add(pointer, temp);
                pointer++;
            }
            counter++;
        }

        return ll;
    }
}


