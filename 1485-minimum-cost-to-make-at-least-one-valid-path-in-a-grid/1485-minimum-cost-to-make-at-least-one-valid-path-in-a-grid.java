class Solution {
    public int minCost(int[][] grid) {
        int m = grid.length, n = grid[0].length;
        int[][] dir = {{0,1}, {0,-1}, {1,0}, {-1,0}}; // Right, Left, Down, Up

        int[][] cost = new int[m][n];
        for (int[] row : cost) Arrays.fill(row, Integer.MAX_VALUE);
        cost[0][0] = 0;

        Deque<int[]> dq = new ArrayDeque<>();
        dq.offerFirst(new int[]{0, 0});

        while (!dq.isEmpty()) {
            int[] curr = dq.pollFirst();
            int x = curr[0], y = curr[1];

            for (int d = 0; d < 4; d++) {
                int nx = x + dir[d][0], ny = y + dir[d][1];
                if (nx < 0 || ny < 0 || nx >= m || ny >= n) continue;

                // Cost is 0 if direction matches the current cell's arrow
                int newCost = cost[x][y] + (grid[x][y] != d + 1 ? 1 : 0);
                if (newCost < cost[nx][ny]) {
                    cost[nx][ny] = newCost;
                    if (grid[x][y] == d + 1)
                        dq.offerFirst(new int[]{nx, ny}); // prioritize 0-cost moves
                    else
                        dq.offerLast(new int[]{nx, ny});
                }
            }
        }

        return cost[m - 1][n - 1];
    }
}
