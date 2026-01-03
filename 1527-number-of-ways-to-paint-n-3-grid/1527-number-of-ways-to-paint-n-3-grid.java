class Solution {

    private static final int MOD = 1_000_000_007;

    public int numOfWays(int n) {
        int[][][][] dp = new int[n][4][4][4];
        for (int i = 0; i < n; i++) {
            for (int j = 0; j < 4; j++) {
                for (int k = 0; k < 4; k++) {
                    Arrays.fill(dp[i][j][k], -1);
                }
            }
        }

        return solve(0, n, -1, -1, -1, dp);

    }

    private int solve(int row, int n, int prev1, int prev2, int prev3, int[][][][] dp){
        if (row==n)
        return 1;

        if (dp[row][prev1+1][prev2+1][prev3+1] != -1)
        return dp[row][prev1+1][prev2+1][prev3+1];

        int ans=0;
        for (int c1 = 0; c1 < 3; c1++) {
            for (int c2 = 0; c2 < 3; c2++) {
                for (int c3 = 0; c3 < 3; c3++) {
                    if (c1!= c2 && c2 != c3 && c1!= prev1 && c2 !=prev2 && c3!=prev3){
                        ans = (ans%MOD+ solve(row+1, n, c1, c2, c3, dp)%MOD)%MOD;
                    }
                    
                }
            }
        }

        return dp[row][prev1+1][prev2+1][prev3+1]=ans;

        

    }
}