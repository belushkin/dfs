import java.util.Arrays;
import java.util.Comparator;
import java.util.PriorityQueue;

public class Dijkstra {

    class VertexComparator implements Comparator<Vertex> {
        public int compare(Vertex v1, Vertex v2) {
            if (v1.value > v2.value)
                return 1;
            else if (v1.value < v2.value)
                return -1;
            return 0;
        }
    }

    class Vertex {
        public int[] coord;
        public int value;

        public Vertex(int[] coord, int value) {
            this.coord = coord;
            this.value = value;
        }
    }

    public static void main(String[] args) {
        Dijkstra dijkstra = new Dijkstra();
        int[][] grid1 = {
                {1, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] grid2 = {
                {1, 4, 3},
                {3, 5, 1},
                {4, 5, 2}
        };
        int[][] grid3 = {
                {1, 4},
                {3, 5}
        };
        int[][] grid4 = {
                {1, 4, 3, 2},
                {5, 3, 5, 1},
                {1, 4, 5, 2},
                {1, 4, 5, 2}
        };
        int[][] grid5 = {
                {1},
                {2},
        };
        int[][] grid6 = {
                {0}
        };
        int[][] grid7 = {
                {1}
        };
        int[][] grid8 = {
                {0, 3, 1},
                {1, 5, 1},
                {4, 2, 1}
        };
        int[][] grid9 = {
                {5,4,2,9,6,0,3,5,1,4,9,8,4,9,7,5,1},
                {3,4,9,2,9,9,0,9,7,9,4,7,8,4,4,5,8},
                {6,1,8,9,8,0,3,7,0,9,8,7,4,9,2,0,1},
                {4,0,0,5,1,7,4,7,6,4,1,0,1,0,6,2,8},
                {7,2,0,2,9,3,4,7,0,8,9,5,9,0,1,1,0},
                {8,2,9,4,9,7,9,3,7,0,3,6,5,3,5,9,6},
                {8,9,9,2,6,1,2,5,8,3,7,0,4,9,8,8,8},
                {5,8,5,4,1,5,6,6,3,3,1,8,3,9,6,4,8},
                {0,2,2,3,0,2,6,7,2,3,7,3,1,5,8,1,3},
                {4,4,0,2,0,3,8,4,1,3,3,0,7,4,2,9,8},
                {5,9,0,4,7,5,7,6,0,8,3,0,0,6,6,6,8},
                {0,7,1,8,3,5,1,8,7,0,2,9,2,2,7,1,5},
                {1,0,0,0,6,2,0,0,2,2,8,0,9,7,0,8,0},
                {1,1,7,2,9,6,5,4,8,7,8,5,0,3,8,1,5},
                {8,9,7,8,1,1,3,0,1,2,9,4,0,1,5,3,1},
                {9,2,7,4,8,7,3,9,2,4,2,2,7,8,2,6,7},
                {3,8,1,6,0,4,8,9,8,0,2,5,3,5,5,7,5},
                {1,8,2,5,7,7,1,9,9,8,9,2,4,9,5,4,0},
                {3,4,4,1,5,3,3,8,8,6,3,5,3,8,7,1,3}
        };

        System.out.println(dijkstra.minPathSum(grid1));
        System.out.println(dijkstra.minPathSum(grid2));
        System.out.println(dijkstra.minPathSum(grid3));
        System.out.println(dijkstra.minPathSum(grid4));
        System.out.println(dijkstra.minPathSum(grid5));
        System.out.println(dijkstra.minPathSum(grid6));
        System.out.println(dijkstra.minPathSum(grid7));
        System.out.println(dijkstra.minPathSum(grid8));
        System.out.println(dijkstra.minPathSum(grid9));
    }

    public int minPathSum(int[][] grid) {
        PriorityQueue<Vertex> pq = new
                PriorityQueue<>(
                        grid.length*grid[0].length,
                new VertexComparator()
        );

        int[][] dirs    = {{0,1}, {1,0}};
        int[][] A       = new int[grid.length][grid[0].length];

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                A[i][j] = (i == 0 && j == 0) ? grid[i][j] : Integer.MAX_VALUE;
                pq.add(new Vertex(new int[]{i,j}, A[i][j]));
            }
        }

        while (!pq.isEmpty()) {
            Vertex v = pq.poll();
            int y = v.coord[0];
            int x = v.coord[1];
            for (int[] dir: dirs) {
//                System.out.println((x + dir[1]) + " " + (y + dir[0]) + " " + v.value);
                if (x + dir[1] >= 0 && x + dir[1] < grid[0].length && y + dir[0] >= 0 && y + dir[0] < grid.length) {
                    int new_y = y + dir[0];
                    int new_x = x + dir[1];

//                    System.out.println(grid[new_y][new_x] + " " + v.value);

                    if (A[new_y][new_x] > (A[y][x] + grid[new_y][new_x])) {
                        A[new_y][new_x] = A[y][x] + grid[new_y][new_x];
                        pq.add(new Vertex(new int[]{new_y,new_x}, A[new_y][new_x]));
                    }
                }
            }
        }
        return A[grid.length-1][grid[0].length-1];
    }
}
