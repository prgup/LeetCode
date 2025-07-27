class Solution {
    public boolean canPartition(int[] nums) {
        int total = Arrays.stream(nums).sum();
        if (total % 2 != 0) return false;

        int target = total / 2;
        Boolean[][] memo = new Boolean[nums.length][target + 1];
        
        boolean ans =canPartitionHelper(nums, 0, target, memo);
        return ans;
    }

    private boolean canPartitionHelper(int[] nums, int index, int target, Boolean[][] memo) {
        if (target == 0) return true;
        if (index >= nums.length || target < 0) return false;

        if (memo[index][target] != null) return memo[index][target];

        // Include or exclude the current number
        boolean result = canPartitionHelper(nums, index + 1, target - nums[index], memo) ||
                         canPartitionHelper(nums, index + 1, target, memo);

        memo[index][target] = result;
        return result;
    }
}
