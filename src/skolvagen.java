import java.io.BufferedReader;
import java.io.IOException;
import java.io.InputStreamReader;
import java.util.HashMap;

public class skolvagen {
    static final char NORTH = 'N';
    static final char SOUTH = 'S';
    static final char BOTH = 'B';

    static HashMap<Location, Integer> dp = new HashMap<>();

    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String input = br.readLine();

        System.out.println(totalCost(input));
    }

    private static int totalCost(String input) {
        int len = input.length();

        // at top init state
        dp.put(new Location(0, true), 0);
        // at btm init state
        dp.put(new Location(0, false), 1);

        boolean[] isTopArr = new boolean[]{true, false};

        for (int i = 0; i < len; i++) {
            char street = input.charAt(i);

            // to loop both sides of the street, top and bottom
            for (boolean isTop : isTopArr) {
                Location nextLoc = new Location(i + 1, isTop);
                int bothCost = 0;
                int topCost = 0;
                int bottomCost = 0;
                if (street == BOTH) {
                    bothCost += 1;
                } else {
                    topCost = street == SOUTH ? 0 : 1;
                    bottomCost = street == NORTH ? 0 : 1;
                }
                int prevCost1 = dp.getOrDefault(new Location(i, true), Integer.MAX_VALUE);
                int prevCost2 = dp.getOrDefault(new Location(i, false), Integer.MAX_VALUE);

                if (isTop) {
                    dp.put(nextLoc, Math.min(prevCost1 + topCost + bothCost, prevCost2 + 1 + bothCost));
                } else {
                    dp.put(nextLoc, Math.min(prevCost2 + bottomCost + bothCost, prevCost1 + 1 + bothCost));
                }
            }
        }
        return Math.min(dp.get(new Location(len, true)), dp.get(new Location(len, false)) + 1);
    }
}

class Location {
    private int numberOfCrossings;
    private boolean isTop;

    public Location (int numberOfCrossings, boolean isTop) {
        this.numberOfCrossings = numberOfCrossings;
        this.isTop = isTop;
    }

    @Override
    public boolean equals(Object o) {
        if (this == o) return true;
        if (o == null || getClass() != o.getClass()) return false;
        Location location = (Location) o;
        return numberOfCrossings == location.numberOfCrossings && isTop == location.isTop;
    }

    @Override
    public int hashCode() {
        return 31 * numberOfCrossings + (isTop ? 1 : 0);
    }
}

