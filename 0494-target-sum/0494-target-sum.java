class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if ((target + sum) % 2 != 0 || Math.abs(target) > sum)
            return 0;
        return dpHelper(nums, (target + sum) / 2);
    }

    int dpHelper(int[] nums, int target) {
        int dp[] = new int[target + 1];
        dp[0] = 1;
        for (int i : nums) {
            for (int j = target; j >= 0; j--) {
                if (j >= i)
                    dp[j] += dp[j - i];
            }
        }
        return dp[target];
    }
}