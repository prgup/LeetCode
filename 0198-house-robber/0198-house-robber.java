class Solution {
    public int rob(int[] nums) {
        if (nums.length==1)
        return nums[0];
        int max2=nums[0];
        int max1 = Math.max(nums[0], nums[1]);
        nums[1]=max1;
        for (int i=2; i<nums.length; i++){
            int cur = max2+nums[i];
            nums[i]= (cur>nums[i-1])?cur: max1;
            max1 = nums[i];
            max2 = nums[i-1];
        }
        return Math.max(max1, max2);
    }
}