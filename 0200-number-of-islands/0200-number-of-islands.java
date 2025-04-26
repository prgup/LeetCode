class Solution {
    public int numIslands(char[][] grid) {
        int m= grid.length;
        int n = grid[0].length;
        boolean [][] visited = new boolean[m][n];
        int ans=0;
        for (int i=0; i<m; i++){
            for (int j=0; j<n;j++){
                if (grid[i][j]=='1' && !visited[i][j]){
                    visited[i][j]=true;
                    visit(grid, visited, i,j, m, n);
                    ans++;
                }
            }
        }
        return ans;
        
    }
    void visit (char [][] grid, boolean [][] visited,  int i, int j, int m, int n){
        
        for (int [] idx : new int [][] {{0,1}, {0,-1}, {1, 0}, {-1, 0}}){
            if ((i + idx[0]) >= 0 && (i + idx[0]) < m && (j + idx[1]) <n && (j + idx[1]) >=0 && 
            grid[i+idx[0]][j+idx[1]]=='1' &&
            !visited[i + idx[0]][j + idx[1]]){
                visited[i+idx[0]][j+idx[1]]=true;
            visit(grid, visited, i+idx[0],j+idx[1], m, n);
            }
        }
        return ;
    }
}