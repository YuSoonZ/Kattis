import java.io.*;
import java.util.*;
import java.math.BigDecimal;

public class treehouses {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int n = Integer.parseInt(token[0]);     // Number of treehouses
        int e = Integer.parseInt(token[1]);     // Number of treehouses that are close enough that they can go by foot
        int p = Integer.parseInt(token[2]);     // Number of cables that are already in place
        ArrayList<DoublePair> coordinates = new ArrayList<>();
        ArrayList<Edge> distance = new ArrayList<>();
        UnionFind UFDS = new UnionFind(n);

        // Adding the coordinate of the points
        for (int i = 0; i < n; i++) {
            token = br.readLine().split(" ");
            double x = Double.parseDouble(token[0]);
            double y = Double.parseDouble(token[1]);
            coordinates.add(new DoublePair(x, y));
        }

        // First e of them are connected --> can be travelled by foot
        for (int i = 1; i < e; i++) {
            UFDS.unionSet(i - 1, i);
        }

        // 1-based indexing to 0-based indexing
        // Connected via cables already (if any)
        for (int i = 0; i < p; i++) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]);
            int b = Integer.parseInt(token[1]);
            UFDS.unionSet(a - 1, b - 1);
        }

        // Find the shortest distance between 1 edge to another and add into the AL
        for (int i = 0; i < n; i++) {
            for (int j = i + 1; j < n; j++) {
                BigDecimal temp = dist(coordinates.get(i), coordinates.get(j));
                Edge edge = new Edge(i, j, temp);
                distance.add(edge);
            }
        }
        Collections.sort(distance, new Comparator<Edge>() {
            @Override
            public int compare(Edge o1, Edge o2) {
                return o1.d.compareTo(o2.d);
            }
        });
        kruskal(distance, n, UFDS);
    }

    // Adapted from https://github.com/stevenhalim/cpbook-code/blob/master/ch4/mst/kruskal.java
    public static void kruskal(ArrayList<Edge> dist, int numOfTreehouses, UnionFind UFDS) {

        BigDecimal mst_cost = BigDecimal.valueOf(0);
        double num_taken = 0;             // no edge has been taken
//        UnionFind UF = new UnionFind(numOfTreehouses);             // all V are disjoint sets
        for (int i = 0; i < dist.size() ; ++i) {                // up to O(E)
            //System.out.println(mst_cost);
            Edge front = dist.get(i);
            if (!UFDS.isSameSet(front.vertice1, front.vertice2)) { // check
                mst_cost = mst_cost.add(front.d);                 // add w of this edge
                UFDS.unionSet(front.vertice1, front.vertice2);// link them
                ++num_taken;                               // 1 more edge is taken
            }
            if (num_taken == numOfTreehouses - 1) break;               // optimization
        }

        // note: the number of disjoint sets must eventually be 1 for a valid MST
        System.out.printf("%.6f%n", mst_cost);
    }
    public static BigDecimal dist(DoublePair p1, DoublePair p2) {
        // Distance in a triangle
        double d1 = Math.pow(p1._first - p2._first, 2);
        double d2 = Math.pow(p1._second - p2._second, 2);
        return BigDecimal.valueOf(Math.sqrt(d1 + d2));
    }

    // https://github.com/stevenhalim/cpbook-code/blob/master/ch4/mst/kruskal.java
    // Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
    static class UnionFind {                                              // OOP style
        private ArrayList<Integer> p, rank, setSize;
        private int numSets;

        public UnionFind(int N) {
            p = new ArrayList<Integer>(N);
            rank = new ArrayList<Integer>(N);
            setSize = new ArrayList<Integer>(N);
            numSets = N;
            for (int i = 0; i < N; i++) {
                p.add(i);
                rank.add(0);
                setSize.add(1);
            }
        }

        public int findSet(int i) {
            if (p.get(i) == i) return i;
            else {
                int ret = findSet(p.get(i)); p.set(i, ret);
                return ret;
            }
        }

        public Boolean isSameSet(int i, int j) { return findSet(i) == findSet(j); }

        public void unionSet(int i, int j) {
            if (!isSameSet(i, j)) { numSets--;
                int x = findSet(i), y = findSet(j);
                // rank is used to keep the tree short
                if (rank.get(x) > rank.get(y)) { p.set(y, x); setSize.set(x, setSize.get(x) + setSize.get(y)); }
                else                           { p.set(x, y); setSize.set(y, setSize.get(y) + setSize.get(x));
                    if (rank.get(x) == rank.get(y)) rank.set(y, rank.get(y) + 1); } } }
        public int numDisjointSets() { return numSets; }
        public int sizeOfSet(int i) { return setSize.get(findSet(i)); }
    }

    // Adapted from https://github.com/stevenhalim/cpbook-code/blob/master/ch4/mst/IntegerPair.java
    static class DoublePair {
        Double _first, _second;

        public DoublePair(Double f, Double s) {
            _first = f;
            _second = s;
        }

        Double first() { return _first; }
        Double second() { return _second; }

        @Override
        public String toString() {
            return this._first + " " + this._second;
        }
    }

    static class Edge implements Comparable<Edge> {
        int vertice1;
        int vertice2;
        BigDecimal d;

        public Edge(int v1, int v2, BigDecimal d) {
            this.vertice1 = v1;
            this.vertice2 = v2;
            this.d = d;
        }

        @Override
        public int compareTo(Edge other) {
            return this.d.compareTo(other.d);
        }

        @Override
        public String toString() {
            return this.vertice1 + " " + this.vertice2 + " " + d;
        }

        public int getVertice1() {
            return this.vertice1;
        }

        public int getVertice2() {
            return this.vertice2;
        }

        public BigDecimal getD() {
            return this.d;
        }
    }
}