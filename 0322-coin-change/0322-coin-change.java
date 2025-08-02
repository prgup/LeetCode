class Solution {
    public int coinChange(int[] coins, int amount) {
        int n = coins.length;
        int [][] dp = new int[n][amount+1];
        Arrays.stream(dp).forEach(d -> Arrays.fill(d, amount+1));
        
        for (int i=0; i<n ; i++){
            dp[i][0]=0;
            int coin = coins[i];
            for (int j=1; j<=amount; j++){
                if (i>0){
                    int old = dp[i-1][j];
                    if (j>=coin) {
                        int temp = Math.min(1+dp[i][j-coin], dp[i-1][j-coin]+1);
                        old = Math.min(temp,old);
                    }
                    dp[i][j]= Math.min(old, dp[i][j]);
                }
                else if (j>=coin)
                    dp[i][j]= Math.min(dp[i][j], 1+ dp[i][j-coin]);
            }
        }
        return dp[n-1][amount]<(amount+1)?dp[n-1][amount]:-1;
        
    }
}