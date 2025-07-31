class Solution {
    int [][][] dp;
    public int findMaxForm(String[] strs, int m, int n) {
        int row = strs.length;
        dp = new int [row+1][m+1][n+1];
        for (int i =0; i<row+1; i++)
            for (int j=0; j<m+1; j++)
                for (int k=0; k<n+1; k++)
                    dp[i][j][k]=-1;
    
        int[][] count = new int[row][2];

        for (int i = 0; i < row; i++) {
            count[i][0] = (int) strs[i].chars().filter(c -> c == '0').count();
            count[i][1] = (int) strs[i].chars().filter(c -> c == '1').count();
        }

        return helper(strs, 0, 0, 0, m, n, count);

    }

    int helper(String[] strs, int idx, int zero, int one, int m, int n, int[][] count) {
        if (idx >= strs.length || zero > m || one > n)
            return 0;
        int with=0;
        if (dp[idx][zero][one]!= -1)
        return dp[idx][zero][one];
        if ((zero + count[idx][0] <= m) && (one + count[idx][1] <= n ))
            with = 1+ helper(strs, idx + 1, zero + count[idx][0], one + count[idx][1], m, n, count);
        int without = helper(strs, idx + 1, zero, one, m, n, count);
        int ans =  Math.max(with, without);
        dp[idx][zero][one]=ans;
        return ans;
    }
}