class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        int n = nums.length;

        // dp[i][j] = true if a sum j is possible using the first i numbers
        boolean[][] dp = new boolean[n+1][target + 1];

        // Base case: sum 0 is possible with any number of elements including zero
        for (int i = 0; i <= n; i++) {
            dp[i][0] = true;
        }

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = 1; j <= target; j++) {
                if (j >= curr) {
                    dp[i][j] = dp[i-1][j] || dp[i-1][j - curr];
                } else {
                    dp[i][j] = dp[i-1][j];
                }
            }
        }

        return dp[n][target];
    }
}
