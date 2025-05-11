class Solution {
    public int uniquePaths(int m, int n) {
        //At any cell (i, j), you only need:
        //dp[j] â number of paths from the cell below (i+1, j)
        //dp[j + 1] â number of paths from the cell to the right (i, j+1)


        int [] dp = new int[n];
        dp[n-1]=1;

        for (int i=m-1; i>=0; i--){
            for (int j=n-2; j>=0; j--){
                dp[j] =dp[j]+dp[j+1];
            }
        }
        return  dp[0];
    }
}