class Solution {
    public List<List<Integer>> pacificAtlantic(int[][] heights) {
        int row = heights.length, col = heights[0].length;
        boolean [][] flowPac = new boolean[row][col];
        boolean [][] flowAt = new boolean[row][col];
        for (int i=0; i<row; i++){
            dfs(flowPac, heights, i, 0, row, col);
            dfs(flowAt, heights, i, col-1, row, col);
        }
        for (int i=0; i<col; i++){
            dfs(flowPac, heights, 0, i, row, col);
            dfs(flowAt, heights, row-1, i, row, col);
        }
        List<List<Integer>> ans = new ArrayList<>();
        for (int i=0; i<row; i++){
            for (int j=0; j<col; j++){
                if (flowPac[i][j] && flowAt[i][j]){
                    ans.add(Arrays.asList(i,j));
                }
            }}
        return ans;

    }

    private void dfs (boolean [][] flow, int [][] heights, int i, int j, int row, int col){
        flow[i][j]=true;
        for (int [] li : new int [][] {{-1,0}, {1,0},{0,-1},{0,1}}){
            int a = i+li[0];
            int b= j+li[1];
            if (a<0 || a>=row || b<0 || b>=col)
                continue;
            else if (flow[a][b] || heights[i][j] > heights[a][b])
            continue;
            dfs(flow, heights, a, b, row, col);
            }
    }
}