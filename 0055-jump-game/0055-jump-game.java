class Solution {
    public boolean canJump(int[] nums) {
        
        // int idx = nums[0];
        int max = nums[0];
        // int j=1;
        for (int i=1; i<nums.length; i++){
            if (max < i)
            return false;
            max = Math.max(max, nums[i] + i);
        }
        return true;
    }
}