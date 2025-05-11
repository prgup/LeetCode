class Solution {
    
    public int uniquePaths(int m, int n) {
        int [][] memoization = new int[m+1][n+1];
        int [][] visited = new int[m+1][n+1];
        visited[1][1]=1;
        memoization[1][1]=1;
        return paths(m,n, memoization, visited);
    }
    int paths (int m, int n, int [][] memoization, int [][] visited){
        if (visited[m][n]==1)
        return memoization[m][n];
        if ((m>1) && visited[m-1][n]!=1){
                paths(m-1,n, memoization, visited);
            }
        if ((n>1) && visited[m][n-1]!=1){
                paths(m,n-1, memoization, visited);
        }
        visited[m][n]=1;
        return memoization[m][n]=memoization[m-1][n]+memoization[m][n-1];

    }
}