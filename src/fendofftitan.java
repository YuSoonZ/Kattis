import java.io.*;
import java.util.*;

public class fendofftitan {
    public static void main (String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));

        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);     // Number of villages
        int M = Integer.parseInt(token[1]);     // Number of roads
        int X = Integer.parseInt(token[2]);     // To deliver from here
        int Y = Integer.parseInt(token[3]);     // To deliver to here
        ArrayList<ArrayList<Edge>> AL = new ArrayList<>();

        // 1-based indexing turn to 0 based
        for (int i = 0; i < N; i++) {
            ArrayList<Edge> neighbour = new ArrayList<>();
            AL.add(neighbour);
        }

        for (int i = 0; i < M; i++) {
            token = br.readLine().split(" ");
            int A = Integer.parseInt(token[0]) - 1;     // From
            int B = Integer.parseInt(token[1]) - 1;     // To
            int W = Integer.parseInt(token[2]);     // Length of Road
            int C = Integer.parseInt(token[3]);     // Whether got XXX obstacle
            int shamanNo = 0;
            int titanNo = 0;
            if (C == 1) {
                shamanNo++;
            } else if (C == 2) {
                titanNo++;
            }
            // Add the current vertex, to the vertex it wants to go to
            IntegerTriple triple = new IntegerTriple(W, shamanNo, titanNo);
            Edge e1 = new Edge(B, triple.distance(), shamanNo, titanNo);
            Edge e2 = new Edge(A, triple.distance(), shamanNo, titanNo);
            AL.get(A).add(e1);
            AL.get(B).add(e2);
        }
        dijkstra(AL, X - 1, Y - 1, N);
    }

    // https://github.com/stevenhalim/cpbook-code/blob/master/ch4/sssp/dijkstra.java
    public static void dijkstra(ArrayList<ArrayList<Edge>> AL, int start, int end, int numOfVillage) {
        PrintWriter printWriter = new PrintWriter(System.out);
        ArrayList<Long> dist = new ArrayList<>(Collections.nCopies(numOfVillage, Long.MAX_VALUE));
        ArrayList<IntegerPair> shamanToTitan = new ArrayList<>(Collections.nCopies(numOfVillage, new IntegerPair(0, 0)));

        dist.set(start, 0L);

        PriorityQueue<Edge> pq = new PriorityQueue<>();
        pq.offer(new Edge(start, 0, 0, 0));
        while (!pq.isEmpty()) {
            Edge curr = pq.poll();
            int vertex = curr.vertice;
            long distance = curr.weight;
            int currShaman = curr.noOfShaman;
            int currTitan = curr.noOfTitan;
            if (distance > dist.get(vertex)) {
                continue;
            }
            for (Edge n : AL.get(vertex)) {
                int neighbourVertex = n.vertice;
                long weight = n.weight;
                int shamanNo = n.noOfShaman;
                int titanNo = n.noOfTitan;
                if (dist.get(vertex) + weight >= dist.get(neighbourVertex)) {
                    continue;
                }
                dist.set(neighbourVertex, dist.get(vertex) + weight);
                pq.offer(new Edge(neighbourVertex, dist.get(neighbourVertex), currShaman + shamanNo, currTitan + titanNo));
                shamanToTitan.set(neighbourVertex, new IntegerPair(currShaman + shamanNo, currTitan + titanNo));
            }
        }

        if (dist.get(end) != Long.MAX_VALUE) {
            IntegerPair pair = shamanToTitan.get(end);
            long first = pair._first * 100000000000L;
            long second = pair._second * 100000000000000L;
            long toPrint = dist.get(end) - first - second;
            printWriter.println(toPrint + " " + pair._first + " " + pair._second);
        } else {
            printWriter.println("IMPOSSIBLE");
        }
        printWriter.close();
    }
}

class Edge implements Comparable<Edge> {
    int vertice;

    long weight;

    int noOfShaman;

    int noOfTitan;

    public Edge(int v, long weight, int noOfShaman, int noOfTitan) {
        this.vertice = v;
        this.weight = weight;
        this.noOfShaman = noOfShaman;
        this.noOfTitan = noOfTitan;
    }

    public int compareTo(Edge e) {
        if (this.weight > e.weight) {
            return 1;
        } else if (this.weight < e.weight) {
            return -1;
        } else {
            return 0;
        }
    }

    public int getVertice() {
        return this.vertice;
    }
    public long getWeight() {
        return this.weight;
    }

    @Override
    public String toString() {
        return this.weight + " " + this.vertice + " " + this.noOfShaman + " " + this.noOfTitan;
    }
}

// https://github.com/stevenhalim/cpbook-code/blob/master/ch4/IntegerTriple.java
class IntegerTriple implements Comparable<IntegerTriple> {
    Integer _first, _second, _third;

    public IntegerTriple(Integer f, Integer s, Integer t) {
        _first = f;
        _second = s;
        _third = t;
    }

    // Compare based off the titan, then shaman, then distance
    public int compareTo(IntegerTriple o) {
        if (!this.third().equals(o.third()))
            return this.third() - o.third();
        else if (!this.second().equals(o.second()))
            return this.second() - o.second();
        else
            return this.first() - o.first();
    }

    public long distance() {
        long shamanPower = _second * 100000000000L;
        long titanPower = _third * 100000000000000L;
        return _first + shamanPower + titanPower;
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
    Integer third() { return _third; }

    public String toString() { return first() + " " + second() + " " + third(); }
}

// https://github.com/stevenhalim/cpbook-code/blob/master/ch4/sssp/IntegerPair.java
class IntegerPair implements Comparable<IntegerPair> {
    Integer _first, _second;

    public IntegerPair(Integer f, Integer s) {
        _first = f;
        _second = s;
    }

    public int compareTo(IntegerPair o) {
        if (!this.first().equals(o.first()))
            return this.first() - o.first();
        else
            return this.second() - o.second();
    }

    Integer first() { return _first; }
    Integer second() { return _second; }
}
