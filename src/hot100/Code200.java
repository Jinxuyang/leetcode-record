package hot100;

import java.util.ArrayDeque;
import java.util.LinkedList;
import java.util.Queue;

/**
 * @Author Verge
 * @Date 2022/4/6 16:20
 * @Version 1.0
 */
public class Code200 {
    public int numIslands(char[][] grid) {
        boolean[][] visited = new boolean[grid.length][grid[0].length];
        for (int i = 0; i < grid.length; i++) {
            for (int j = 0; j < grid[0].length; j++) {
                if (!visited[i][j] && grid[i][j] == '1') bfs(grid, visited, j, i);
            }
        }
        return res;
    }

    int res = 0;
    public void bfs(char[][] grid, boolean[][] visited, int x, int y) {
        Queue<int[]> queue = new LinkedList<>();
        queue.add(new int[]{x, y});

        while (!queue.isEmpty()) {
            int[] poll = queue.remove();
            x = poll[0];
            y = poll[1];
            if(visited[y][x]) continue;
            if (x + 1 < grid[0].length && !visited[y][x + 1] && grid[y][x + 1] == '1') {
                queue.add(new int[]{x+1,y});
            }

            if (y + 1< grid.length && !visited[y + 1][x] && grid[y + 1][x] == '1') {
                queue.add(new int[]{x,y + 1});
            }

            if (x - 1 >= 0 && !visited[y][x - 1] && grid[y][x - 1] == '1') {
                queue.add(new int[]{x-1,y});
            }

            if (y - 1 >= 0 && !visited[y - 1][x] && grid[y - 1][x] == '1') {
                queue.add(new int[]{x,y - 1});
            }
            visited[y][x] = true;

        }
        res++;
    }
}
