package lc;

import java.util.*;
// 腐烂橘子
public class lc994 {
    int[] dr = new int[]{1,-1,0,0};
    int[] dc = new int[]{0,0,1,-1};

    public int orangesRotting(int[][] grid) {
        int res = 0;
        Queue<int[]> queue = new LinkedList<>();
        for(int i = 0; i < grid.length; i++){
            for(int j =0;j<grid[0].length;j++){
                if(grid[i][j] == 2){
                    queue.offer(new int[]{i,j});
                }
            }
        }

        while(!queue.isEmpty()){
            int len = queue.size();
            for(int i = 0;i < len;i++){
                int[] ind = queue.poll();
                int startx = ind[0];
                int starty = ind[1];
                for(int j = 0;j<4;j++){
                    int nx = startx + dr[j];
                    int ny = starty + dc[j];
                    if(nx >= 0 && ny >= 0 && nx < grid.length && ny < grid[0].length && grid[nx][ny]==1){
                        grid[nx][ny] = 2;
                        queue.add(new int[]{nx,ny});
                    }
                }
            }
            res++;
        }

        for(int i = 0;i < grid.length;i++){
            for(int j = 0;j < grid[0].length;j++){
                if(grid[i][j] == 1){
                    return -1;
                }
            }
        }

        return res;
    }

    public static void main(String[] args) {
        lc994 solution = new lc994();

        // 测试用例 1：空网格
        int[][] grid1 = {};
        System.out.println("Test Case 1: " + solution.orangesRotting(grid1)); // 期望输出：0

        // 测试用例 2：全是新鲜橘子，没有腐烂橘子
        int[][] grid2 = {
                {1, 1, 1},
                {1, 1, 1},
                {1, 1, 1}
        };
        System.out.println("Test Case 2: " + solution.orangesRotting(grid2)); // 期望输出：-1

        // 测试用例 3：全是腐烂橘子
        int[][] grid3 = {
                {2, 2, 2},
                {2, 2, 2},
                {2, 2, 2}
        };
        System.out.println("Test Case 3: " + solution.orangesRotting(grid3)); // 期望输出：0

        // 测试用例 4：没有橘子
        int[][] grid4 = {
                {0, 0, 0},
                {0, 0, 0},
                {0, 0, 0}
        };
        System.out.println("Test Case 4: " + solution.orangesRotting(grid4)); // 期望输出：0

        // 测试用例 5：存在新鲜橘子和腐烂橘子
        int[][] grid5 = {
                {2, 1, 0},
                {1, 1, 0},
                {0, 1, 1}
        };
        System.out.println("Test Case 5: " + solution.orangesRotting(grid5)); // 期望输出：4

        // 测试用例 6：新鲜橘子无法被腐烂
        int[][] grid6 = {
                {2, 0, 1},
                {0, 0, 0},
                {1, 0, 2}
        };
        System.out.println("Test Case 6: " + solution.orangesRotting(grid6)); // 期望输出：-1

        PriorityQueue<Integer> pq = new PriorityQueue<>(new Comparator<Integer>() {
            @Override
            public int compare(Integer o1, Integer o2) {
                return o2 - o1;
            }
        });
        ArrayList list = new ArrayList();
        list.add(0, 1);
    }
}
