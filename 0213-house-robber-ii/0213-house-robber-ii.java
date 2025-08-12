class Solution {
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        return Math.max(
                robLinear(nums, 0, n - 2),
                robLinear(nums, 1, n - 1));
    }

    private int robLinear(int[] nums, int start, int end) {
        int[] memo = new int[nums.length];
        Arrays.fill(memo, -1);
        return helper(nums, start, end, memo);
    }

    private int helper(int[] nums, int idx, int end, int[] memo) {
        if (idx > end)
            return 0;
        if (memo[idx] == -1)
            memo[idx] = Math.max(
                    helper(nums, idx + 1, end, memo),
                    nums[idx] + helper(nums, idx + 2, end, memo));
        return memo[idx];
    }

}