import java.io.*;
import java.util.*;

public class kaploeb {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int l = Integer.parseInt(token[0]);
        int k = Integer.parseInt(token[1]);
        int s = Integer.parseInt(token[2]);
        HashMap<Integer, int[]> hashMap = new HashMap<>(l);
        HashMap<Integer, Integer> hashMap2 = new HashMap<>(l);

        for (int i = 0; i < l; i++) {
            token = br.readLine().split(" ");
            int startNumber = Integer.parseInt(token[0]);
            Time t = new Time(token[1]);
            int minutes = t.getMin();
            int seconds = t.getSec();
            if (!hashMap.containsKey(startNumber)) {
                hashMap.put(startNumber, new int[]{0, 0});
            }

            int[] temp = hashMap.get(startNumber);
            temp[0] = temp[0] + 1;

            temp[1] = temp[1] + minutes * 60 + seconds;
            hashMap.put(startNumber, temp);
        }

        Object[] keySet = hashMap.keySet().toArray();

        // To check whether fulfils minimum laps
        for (int j = 0; j < keySet.length; j++) {
            int num = (int) keySet[j];
            if (hashMap.containsKey(num)) {
                int[] temp = hashMap.get(num);
                int first = temp[0];
                int second = temp[1];
                if (first == k) {
                    hashMap2.put(num, second);
                }
            }
        }
        // Now with the hashmap only including those who pass, we need to sort it according to ascending order for time
        // If same time, BE with rank by smallest first
        Map<Integer,Integer> sortedMap = MapUtil.sortByValue(hashMap2);
        for (Map.Entry<Integer, Integer> entry : sortedMap.entrySet()) {
            System.out.println(entry.getKey());
        }
    }
}

class Time {

    private int min;
    private int sec;

    public Time(String s) {
        String[] arr = s.split("\\.");
        this.min = Integer.parseInt(arr[0]);
        this.sec = Integer.parseInt(arr[1]);;
    }

    public int getMin() {
        return this.min;
    }

    public int getSec() {
        return this.sec;
    }
}

// Quoted from "https://stackoverflow.com/questions/109383/sort-a-mapkey-value-by-values" and adjusted some to
// make it work for this qn 
class MapUtil {
    public static <K extends Comparable<? super K>, V extends Comparable<? super V>> Map<K, V> sortByValue(Map<K, V> map) {
        List<Map.Entry<K, V>> list = new ArrayList<>(map.entrySet());

        Comparator<Map.Entry<K, V>> comparator = (entry1, entry2) -> {
            int value = entry1.getValue().compareTo(entry2.getValue());
            if (value == 0) {
                return entry1.getKey().compareTo(entry2.getKey());
            }
            return value;
        };

        list.sort((comparator));

        Map<K, V> result = new LinkedHashMap<>();
        for (Map.Entry<K, V> entry : list) {
            result.put(entry.getKey(), entry.getValue());
        }
        return result;
    }
}

