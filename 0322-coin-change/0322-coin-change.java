class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int[][] dp = new int[n][amount + 1];
        // Arrays.stream(dp).forEach(d -> Arrays.fill(d, amount + 1));

        for (int i = 0; i < n; i++) {
            Arrays.fill(dp[i], amount + 1);
            int coin = coins[i];
            dp[i][0] = 0;
            for (int j = 1; j <= amount; j++) {

                if (i > 0)
                    dp[i][j] = dp[i - 1][j];

                if (j >= coin) {
                    int useCurrent = dp[i][j - coin] + 1;
                    dp[i][j] = Math.min(dp[i][j], useCurrent);
                }
            }
        }
        int result = dp[n - 1][amount];
        return result > amount ? -1 : result;
    }
}