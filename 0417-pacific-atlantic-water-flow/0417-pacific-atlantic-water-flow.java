class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] height) {
        int row = height.length, col = height[0].length;
        int[][] pacific = new int[height.length][height[0].length];
        int[][] atlantic = new int[height.length][height[0].length];
        for (int i = 0; i < row; i++) {
            pacific[i][0] = 1;
            atlantic[row - i - 1][col - 1] = 1;
        }
        for (int j = 0; j < col; j++) {
            pacific[0][j] = 1;
            atlantic[row - 1][j] = 1;
        }
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] == 1)
                    dfs(i, j, height, pacific);
                if (atlantic[i][j] == 1)
                    dfs(i, j, height, atlantic);
            }
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < row; i++) {
            for (int j = 0; j < col; j++) {
                if (pacific[i][j] == 1 && atlantic[i][j] == 1) {
                    List<Integer> li = new ArrayList<>();
                    li.add(i);
                    li.add(j);
                    ans.add(li);
                }
            }
        }
        return ans;
    }

    public void dfs(int i, int j, int[][] height, int[][] flow) {

        for (int[] temp : new int[][] { { -1, 0 }, { 1, 0 }, { 0, -1 }, { 0, 1 } }) {
            int i1 = i + temp[0];
            int j1 = j + temp[1];
            if (i1 < 0 || j1 < 0 || i1 >= height.length || j1 >= height[0].length || flow[i1][j1] == 1)
                continue;
            if (height[i1][j1] >= height[i][j]) {
                flow[i1][j1] = 1;
                dfs(i1, j1, height, flow);
            }
        }
    }
}