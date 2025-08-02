class Solution {
    public int change(int amount, int[] coins) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];

        for (int i = 0; i < n; i++) {
            int coin = coins[i];
            dp[i][0] = 1;
            for (int j = 1; j <= amount; j++) {
                if (j % coin == 0)
                    dp[i][j] = 1;
                if (i > 0) {
                    dp[i][j] = dp[i - 1][j];
                    if (j >= coin)
                        dp[i][j] += dp[i][j - coin];
                }
            }
        }
        int result = dp[n - 1][amount];
        return result;
    }
}