import java.io.*;
import java.util.*;

public class kannafriendship {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int Q = Integer.parseInt(token[1]);
        TreeMap<Long, Long> treeMap = new TreeMap<>();
        PrintWriter printWriter = new PrintWriter(System.out);
        long result = 0;

        for (int i = 0; i < Q; i++) {
            token = br.readLine().split(" ");
            if (Integer.parseInt(token[0]) == 2) {
                printWriter.println(result);
            } else {
                long s = Long.parseLong(token[1]);
                long e = Long.parseLong(token[2]);
                long checker = -1;
                int added = -1;

                // If there is nothing there, just add and move on
                if (treeMap.size() == 0) {
                    treeMap.put(s, e);
                    result += (e - s + 1);
                    continue;
                }

                if (treeMap.containsKey(s)) {
                    long initVal = treeMap.get(s);
                    if (initVal < e) {
                        result -= (initVal - s + 1);
                        result += (e - s + 1);
                        treeMap.remove(s);
                        added = 0;
                        checker++;
                    }
                }

                while (true) {
                    Map.Entry<Long, Long> lowerEntry = treeMap.floorEntry(s);
                    if (lowerEntry == null || lowerEntry.getValue() + 1 < s) {
                        break;
                    }

                    long a = lowerEntry.getKey();
                    long b = lowerEntry.getValue();
                    if (b == s || b + 1 == s) {
                        if (added == 0) {
                            // To prevent double adding
                            result -= (e - s + 1);
                        }
                        result -= (b - a + 1);
                        result += (e - a + 1);
                        treeMap.remove(a);
                        s = a;
                        checker++;
                        added = 0;
                    } else if (b > s) {
                        if (b == e || b > e) {
                            if (added == 0) {
                                // To prevent double adding
                                result -= (e - s + 1);
                            }
                            treeMap.remove(a);
                            s = a;
                            e = b;
                            checker++;
                            added = 0;
                        } else {    // b < e
                            if (added == 0) {
                                // To prevent double adding
                                result -= (e - s + 1);
                            }
                            treeMap.remove(a);
                            result -= (b - a + 1);
                            result += (e - a + 1);
                            s = a;
                            checker++;
                            added = 0;
                        }
                    }
                }

                while (true) {
                    Map.Entry<Long, Long> upperEntry = treeMap.ceilingEntry(s);
                    if (upperEntry == null || e + 1 < upperEntry.getKey()) {
                        break;
                    }

                    long a = upperEntry.getKey();
                    long b = upperEntry.getValue();

                    if (e == a || e + 1 == a) {
                        if (added == 0) {
                            // To prevent double adding
                            result -= (e - s + 1);
                        }
                        result -= (b - a + 1);
                        treeMap.remove(a);
                        result += (b - s + 1);
                        e = b;
                        checker++;
                        added = 0;
                    } else if (e > a) {
                        if (e == b || e < b) {
                            if (added == 0) {
                                // To prevent double adding
                                result -= (e - s + 1);
                            }
                            result -= (b - a + 1);
                            result += (b - s + 1);
                            e = b;
                            treeMap.remove(a);
                            checker++;
                            added = 0;
                        } else {    // e > b
                            if (added == 0) {
                                // To prevent double adding
                                result -= (e - s + 1);
                            }
                            result -= (b - a + 1);
                            result += (e - s + 1);
                            treeMap.remove(a);
                            checker++;
                            added = 0;
                        }
                    }
                }

                if (checker == -1) {
                    result += (e - s + 1);
                }
                treeMap.put(s, e);
            }
        }
        printWriter.close();
    }
}