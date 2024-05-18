import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.io.PrintWriter;
import java.util.ArrayList;
import java.util.Collections;

public class dingdongditch {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        PrintWriter printWriter = new PrintWriter(System.out);

        String[] strArr = br.readLine().split(" ");
        int N = Integer.parseInt(strArr[0]);
        int Q = Integer.parseInt(strArr[1]);

        strArr = br.readLine().split(" ");
        ArrayList<Integer> angerList = new ArrayList<>(N);
        for (String anger : strArr) {
            angerList.add(Integer.parseInt(anger));
        }
        Collections.sort(angerList);

        long[] angersForN = new long[N];
        long currAnger = 0;
        for (int i = 0; i < N; i++) {
            currAnger += angerList.get(i);
            angersForN[i] = currAnger;
        }

        strArr = br.readLine().split(" ");
        ArrayList<Integer> ambitionList = new ArrayList<>(Q);
        for (String ambition : strArr) {
            ambitionList.add(Integer.parseInt(ambition));
        }

        for (int i = 0; i < Q; i++) {
            int ambition = ambitionList.get(i);
            printWriter.println(angersForN[ambition - 1]);
        }

        printWriter.close();
    }
}
