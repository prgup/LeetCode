class Solution {
    int [] memoization;
    public int rob(int[] nums) {
        int n = nums.length;
        if (n == 1)
            return nums[0];
        memoization = new int[n];
        Arrays.fill(memoization,-1);
        helper(nums, 0, n - 2);
        int ans = memoization[0];
        Arrays.fill(memoization,-1);
        helper(nums, 1, n - 1);
        return Math.max(memoization[1],ans);
    }

    int helper(int[] nums, int idx, int end) {
        if (idx > end)
            return 0;
        if (memoization[idx]==-1)
        memoization[idx]= Math.max(helper(nums, idx + 1, end), nums[idx] + helper(nums, idx + 2, end));
        return memoization[idx];
    }
}