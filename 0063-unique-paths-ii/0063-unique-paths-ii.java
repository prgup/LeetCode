class Solution {
    public int uniquePathsWithObstacles(int[][] oGrid) {
        //leetcode 62 for basics
        int m = oGrid.length;
        int n = oGrid[0].length;
        int [] dp = new int[n];
        dp[n-1]=1;
        for (int i=m-1; i>=0; i--){
            if (oGrid[i][n-1]==1)
            dp[n-1]=0;
            for (int j=n-2; j>=0; j--){
                dp[j] = dp[j]+dp[j+1];
                if (oGrid[i][j]==1)
                dp[j]=0;
            }
        }
        return  dp[0];
        
    }
}