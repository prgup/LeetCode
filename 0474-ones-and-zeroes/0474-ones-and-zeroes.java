class Solution {
    public int findMaxForm(String[] strs, int m, int n) {
        int[][] dp = new int[m+1][n+1];

        for (String str : strs){
            int zero = (int) str.chars().filter(c -> c=='0').count();
            int one = (int) str.chars().filter(c-> c=='1').count();
            for (int i = m ; i>= zero; i--){
                for (int j=n ; j>= one; j--){
                    dp[i][j] = Math.max(dp[i][j], 1+dp[i-zero][j-one]);
                }}
        }
        return dp[m][n];
    }
}