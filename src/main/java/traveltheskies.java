import java.util.*;

public class traveltheskies {
    public static void main(String[] args) {
        Scanner sc = new Scanner(System.in);
        int k = sc.nextInt();   // number of airports
        int n = sc.nextInt();   // number of days of flight departure
        int m = sc.nextInt();   // number of flights in the window
        sc.nextLine();
        HashMap<Integer, ArrayList<FlightDetails>> flights = new HashMap<>();
        HashMap<Integer, ArrayList<Pair>> inflows = new HashMap<>();
        int[] passengers = new int[k];
        boolean optimal = true;

        // to put all respective details about the flight in a hashmap
        for (int i = 0; i < m; i++) {
            int u = sc.nextInt() - 1;   // starting location
            int v = sc.nextInt() - 1;   // ending location
            int d = sc.nextInt() - 1;   // day it flies
            int z = sc.nextInt();   // capacity
            FlightDetails flightDetails = new FlightDetails(u, v, z);
            if (!flights.containsKey(d)) {
                flights.put(d, new ArrayList<>());
            }
            flights.get(d).add(flightDetails);
        }

        // To put all respective passengers coming
        for (int i = 0; i < k * n; i++) {
            int a = sc.nextInt() - 1;   // Airport
            int b = sc.nextInt() - 1;   // Day
            int c = sc.nextInt();   // Number of customer going to airport a and can leave from day
            Pair pair = new Pair(a, c);
            if (!inflows.containsKey(b)) {
                inflows.put(b, new ArrayList<>());
            }
            inflows.get(b).add(pair);
        }

        for (int i = 0; i < n; i++) {
            // Set the number of passengers that arrive
            if (inflows.containsKey(i)) {
                for (Pair pair : inflows.get(i)) {
                    int a = pair.getFirst();
                    int c = pair.getSecond();
                    passengers[a] += c;

                }
            }

            // Check flights and allow it to fly
            if (flights.containsKey(i)) {
                for (FlightDetails flight : flights.get(i)) {
                    int cap = flight.getCapacity();
                    int from = flight.getStartLocation();
                    int numOfPassenger = passengers[from];
                    if (numOfPassenger < cap) {
                        optimal = false;
                        break;
                    } else {
                        passengers[from] -= cap;
                    }
                }
            }

            if (!optimal) {
                break;
            }

            // To add people flying in
            if (flights.containsKey(i)) {
                for (FlightDetails flight : flights.get(i)) {
                    int to = flight.getEndLocation();
                    int cap = flight.getCapacity();
                    passengers[to] += cap;
                }
            }
        }

        if (optimal) {
            System.out.println("optimal");
        } else {
            System.out.println("suboptimal");
        }
    }
}

class Pair {
    private int first;
    private int second;

    public Pair(int front, int back) {
        this.first = front;
        this.second = back;
    }

    public int getFirst() {
        return this.first;
    }

    public int getSecond() {
        return this.second;
    }
}

class FlightDetails {
    private int startLocation;
    private int endLocation;
    private int capacity;

    public FlightDetails(int start, int end, int cap) {
        this.startLocation = start;
        this.endLocation = end;
        this.capacity = cap;
    }

    public int getStartLocation() {
        return this.startLocation;
    }

    public int getEndLocation() {
        return this.endLocation;
    }

    public int getCapacity() {
        return this.capacity;
    }
}