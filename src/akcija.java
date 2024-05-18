import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.Collections;
import java.util.Comparator;

public class akcija {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        ArrayList<Integer> books = new ArrayList<>();
        for (int i = 0; i < N; i++) {
            books.add(Integer.parseInt(br.readLine()));
        }

        Collections.sort(books, new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                // Sort in descending order
                return o2.compareTo(o1);
            }
        });

        long result = 0;

        for (int i = 0; i < N / 3; i++) {
            result += books.get(0);
            books.remove(0);
            result += books.get(0);
            books.remove(0);
            books.remove(0);
        }

        for (int book : books) {
            result += book;
        }

        System.out.println(result);
    }
}
