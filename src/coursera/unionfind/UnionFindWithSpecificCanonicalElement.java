package coursera.unionfind;

import java.util.HashMap;
import java.util.Map;

public class UnionFindWithSpecificCanonicalElement {

    private int count;
    private int[] network;
    private int[] size;

    private Map<Integer, Integer> max = new HashMap<>();

    public UnionFindWithSpecificCanonicalElement(int n) {
        count = n;
        network = new int[n];
        size = new int[n];

        for (int i = 0; i < n; i++) {
            network[i] = i;
            size[i] = 1;
        }
    }

    private int root(int p) {
        while (p != network[p])
            p = network[p];
        return p;
    }

    public int find(int component) {
        return max.get(root(component));
    }

    public int count() {
        return count;
    }

    public boolean connected(int p, int q) {
        return root(p) == root(q);
    }

    public void union(int p, int q) {

        int rootP = root(p);
        int rootQ = root(q);

        if (rootP == rootQ) return;

        int maxP = Math.max(max.getOrDefault(rootP, 0), p);
        int maxQ = Math.max(max.getOrDefault(rootQ, 0), q);
        max.put(rootP, Math.max(maxP, q));
        max.put(rootQ, Math.max(maxQ, p));

        if (size[rootP] < size[rootQ]) {
            network[rootP] = rootQ;
            size[rootQ] += size[rootP];
        } else {
            network[rootQ] = rootP;
            size[rootP] += size[rootQ];
        }

        count--;
    }

    public static void main(String[] args) {
        int value = 10;
        UnionFindWithSpecificCanonicalElement u = new UnionFindWithSpecificCanonicalElement(value);
        u.union(1,2);
        u.union(2,3);
        u.union(3,9);
        System.out.println(u.find(3));
        System.out.println(u.find(2));

        u.union(0,4);
        u.union(4,5);
        u.union(5,6);
        System.out.println(u.find(0));

    }
}
