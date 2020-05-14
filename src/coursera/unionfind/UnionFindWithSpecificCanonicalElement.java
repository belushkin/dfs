package coursera.unionfind;

public class UnionFindWithSpecificCanonicalElement {

    private int count;
    private int[] network;
    private int[] size;

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

        u.union(0,4);
        u.union(4,5);
        u.union(5,6);

    }
}
