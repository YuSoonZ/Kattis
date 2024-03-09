import java.util.;
import java.io.;

public class bokforing {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split( );
        int N = Integer.parseInt(token[0]);
        int Q = Integer.parseInt(token[1]);
        final String set = SET;
        final String restart = RESTART;
        HashMapInteger, Integer hashMap = new HashMap();

        int restartedAmount = 0;
        for (int i = 0; i  Q; i++) {
            token = br.readLine().split( );
            String task = token[0];
            if (task.equals(set)) {
                int person = Integer.parseInt(token[1]);
                int amount = Integer.parseInt(token[2]);
                hashMap.put(person, amount);
            } else if (task.equals(restart)) {
                restartedAmount = Integer.parseInt(token[1]);
                hashMap = new HashMap();
            } else {
                int result = restartedAmount;
                if (hashMap.containsKey(Integer.parseInt(token[1]))) {
                    result = hashMap.get(Integer.parseInt(token[1]));
                }
                PrintWriter out = new PrintWriter(System.out);
                out.println(result);
                out.flush();
            }
        }
    }
}