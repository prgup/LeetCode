
//testing extension LeetHub 2.0
class Solution {
    public int kthSmallest(int[][] matrix, int k) {
        int row = matrix.length;
        int col = row;
        if (k == row * col)
            return matrix[row - 1][col - 1];
        PriorityQueue<int[]> list = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        list.add(new int[] { matrix[0][0], 0, 0 });
        int ans = matrix[0][0];
        while (k > 0) {
            int[] cur = list.poll();
            ans = cur[0];
            k--;
            int x = cur[1], y = cur[2];
            if (x == row - 1 || y == col - 1)
                continue;
            else if (x == y) {
                list.add(new int [] {matrix[x+1][y], x + 1, y });
                list.add(new int [] {matrix[x+1][y+1], x + 1, y + 1 });
                list.add(new int [] { matrix[x][y+1], x, y + 1 });
            } else {
                x += ((x > y) ? 1 : 0);
                y += (x < y) ? 1 : 0;
                list.add( new int [] { matrix[x][y], x, y  });
            }
        }
        return ans;

    }
}