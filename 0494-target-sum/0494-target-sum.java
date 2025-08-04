class Solution {
    public int findTargetSumWays(int[] nums, int target) {
        int sum = Arrays.stream(nums).sum();
        if (Math.abs(target) > sum || (sum - target) % 2 != 0)
            return 0;
        return helper(nums, target, 0, 0);

    }

    int helper(int[] nums, int target, int idx, int current) {
        if (idx>=nums.length)
        return target==current?1:0;

        int positive = helper(nums, target, idx+1, current+nums[idx]);
        int negative = helper(nums, target, idx+1, current-nums[idx]);
        return positive + negative;

    }
}