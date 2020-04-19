import java.util.*;

class Solution {

    public static void main(String[] args) {
        Solution solution = new Solution();

        char[][] grid = {
                {'1','1','1','1','0'},
                {'1','1','0','1','0'},
                {'1','1','0','0','0'},
                {'0','0','0','0','0'}
        };

        System.out.println(solution.numIslands(grid));;
    }

    public int numIslands(char[][] grid) {

        int[][] dirs = {{-1,0}, {0,1}, {1,0}, {0,-1}};
//        PriorityQueue<int[][]> pQueue = new PriorityQueue<>();
//        pQueue.add()
        int islands = 0;

        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (grid[i][j] == '1') {
                    islands += 1;
                    Queue<int[]> q = new LinkedList<>();
                    q.add(new int[]{i,j});
                    grid[i][j] = '0';

                    while (!q.isEmpty()) {
                        int[] value = q.poll();
                        int y = value[0];
                        int x = value[1];

                        for (int[] dir: dirs) {
                            if (x + dir[1] >= 0 && x+dir[1] < grid[0].length && y+dir[0] >= 0 && y+dir[0] < grid.length) {
                                if (grid[y + dir[0]][x + dir[1]] == '1') {
                                    grid[y + dir[0]][x + dir[1]] = '0';
                                    q.add(new int[]{y + dir[0],x + dir[1]});
                                }
                            }
                        }
                    }
                }
            }
        }
        return islands;
    }
}