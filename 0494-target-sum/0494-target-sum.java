public class Solution {

    public int findTargetSumWays(int[] nums, int target) {
        int totalSum = Arrays.stream(nums).sum();

        if (Math.abs(target)>totalSum || (totalSum-target)%2!=0)
        return 0;
        
        int[] dp = new int[2 * totalSum + 1];

        dp[ totalSum] = 1; 
      
        for (int index = 0; index < nums.length; index++) {
            int[] next = new int[2 * totalSum + 1];
            for (int sum = 0; sum <= 2*totalSum; sum++) {
                if (dp[sum] > 0) {
                    next[sum + nums[index] ] += dp[sum ];
                    next[sum - nums[index] ] += dp[sum ];
                }
            }
            dp = next;
        }

        return dp[target + totalSum];
    }
}