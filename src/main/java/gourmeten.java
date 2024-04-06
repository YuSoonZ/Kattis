import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.ArrayList;
import java.util.HashMap;

public class gourmeten {
    public static void main(String[] args) throws IOException  {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int M = Integer.parseInt(br.readLine());
        int N = Integer.parseInt(br.readLine());

        ArrayList<Integer> timeForEachCourse = new ArrayList<>(N);
        for (int i = 0; i < N; i++) {
            timeForEachCourse.add(Integer.parseInt(br.readLine()));
        }

        HashMap<Integer, Long> hashMap = new HashMap<>();

        System.out.println(numberOfWays(M, timeForEachCourse, hashMap));
    }

    public static long numberOfWays(int time, ArrayList<Integer> coursesTime, HashMap<Integer, Long> hashMap) {
        long result = 0L;
        if (time < 0) {
            return result;
        }
        if (time == 0) {
            return result + 1;
        }

        if (hashMap.containsKey(time)) {
            return hashMap.get(time);
        }

        for (int courseTiming : coursesTime) {
            result += numberOfWays(time - courseTiming, coursesTime, hashMap);
        }

        hashMap.put(time, result);
        return result;
    }
}
