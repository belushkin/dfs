package coursera.unionfind;

public class SocialNetworkConnectivity {

    private int count;
    private int[] network;
    private int[] size;

    int[][] timestamps = new int[][] {
            {0,1},
            {1,0},
            {5,1},
            {2,3},
            {4,0},
            {3,2},
            {3,4},
            {2,3},
            {4,5},
            {0,5},
            {2,5},
            {2,0},
            {1,5}
    };

    public SocialNetworkConnectivity(int n) {
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

    public int count()
    {
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

        int value = 6;

        SocialNetworkConnectivity socialNetworkConnectivity = new SocialNetworkConnectivity(value);
        for (int i = 0; i < socialNetworkConnectivity.timestamps.length; i++) {
            socialNetworkConnectivity.union(
                    socialNetworkConnectivity.timestamps[i][0],
                    socialNetworkConnectivity.timestamps[i][1]
            );
            if (socialNetworkConnectivity.count() == 1) {
                System.out.println(i);
                break;
            }
        }
    }

}
