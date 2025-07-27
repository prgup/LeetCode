class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0)
            return false;

        int target = total / 2;
        int n = nums.length;

        // dp[i][j] = true if a sum j is possible using the first i numbers
        boolean[] dp = new boolean[target + 1];

        // Base case: sum 0 is possible with any number of elements including zero
        dp[0] = true;

        for (int i = 1; i <= n; i++) {
            int curr = nums[i - 1];
            for (int j = target; j >= curr; j--) {
                //This ensures that each number is only used once per iteration.
                // Prevents overwriting dp[j - num] before itâs used to compute dp[j].
                dp[j] = dp[j] || dp[j - curr];
            }
        }

        return dp[target];
    }
}
