import java.io.*;
import java.util.*;

public class swaptosort {
    public static void main(String[] args) throws IOException {
        BufferedReader br = new BufferedReader(new InputStreamReader(System.in));
        String[] token = br.readLine().split(" ");
        int N = Integer.parseInt(token[0]);
        int K = Integer.parseInt(token[1]);
        UnionFind UNF = new UnionFind(N);

        while (K > 0) {
            token = br.readLine().split(" ");
            int a = Integer.parseInt(token[0]) - 1;
            int b = Integer.parseInt(token[1]) - 1;
            UNF.unionSet(a, b);
            K--;
        }

        boolean possible = true;
        for (int i = 0; i < N / 2; i++) {
            if (UNF.findSet(i) != UNF.findSet(N - 1 - i)) {
                possible = false;
                break;
            }
        }

        System.out.println(possible ? "Yes" : "No");
    }
}


// Union-Find Disjoint Sets Library written in OOP manner, using both path compression and union by rank heuristics
class UnionFind {                                              // OOP style
    private ArrayList<Integer> p, rank, setSize;
    private int numSets;

    public UnionFind(int N) {
        p = new ArrayList<>(N);
        rank = new ArrayList<>(N);
        setSize = new ArrayList<>(N);
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
            return ret; } }

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
