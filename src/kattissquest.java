import java.io.*;
import java.util.*;

public class kattissquest {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        int N = Integer.parseInt(br.readLine());
        PrintWriter printWriter = new PrintWriter(System.out);
        TreeMap<Quest, Integer> treeMap = new TreeMap<>(new QuestCompare());

        String[] token;

        for (int i = 0; i < N; i++) {
            token = br.readLine().split(" ");
            if (token[0].equals("add")) {
                int E = Integer.parseInt(token[1]);
                int G = Integer.parseInt(token[2]);
                Quest q = new Quest(E, G);
                if (!treeMap.containsKey(q)) {
                    treeMap.put(q, 0);
                } else {
                    treeMap.put(q, treeMap.get(q) + 1);
                }
            } else {
                int X = Integer.parseInt(token[1]);
                long value = 0;
                while (X > 0) {
                    Quest temp = new Quest(X, Long.MAX_VALUE);
                    Map.Entry<Quest, Integer> pos = treeMap.lowerEntry(temp);
                    if (pos == null) {
                        break;
                    }
                    //System.out.println(treeMap.get(temp));
                    Quest q = pos.getKey();
                    value += q.gold;
                    X -= q.energy;

                    if (pos.getValue() == 0) {
                        treeMap.remove(pos.getKey());
                    } else {
                        treeMap.put(pos.getKey(), pos.getValue() - 1);
                    }
                }
                printWriter.println(value);
            }
        }
        printWriter.close();
    }
}

class Quest {
    public long energy;
    public long gold;

   // long place;

    public Quest(long energy, long gold) {
        this.energy = energy;
        this.gold = gold;
       // this.place = 200000L * energy * gold;
    }

    @Override
    public String toString() {
        return "Energy: " + this.energy + " " + "Gold: " + this.gold;
    }
}

class QuestCompare implements Comparator<Quest> {
    @Override
    public int compare(Quest q1, Quest q2) {
        if (q1.energy < q2.energy) {
            return -1;
        } else if (q1.energy > q2.energy) {
            return 1;
        } else {
            if (q1.gold < q2.gold) {
                return -1;
            } else if (q1.gold > q2.gold) {
                return 1;
            } else {
                return 0; // Consider them equal if both energy and gold are the same
            }
        }
    }
}

