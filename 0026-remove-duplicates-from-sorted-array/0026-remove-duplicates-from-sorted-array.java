class Solution {
    public int removeDuplicates(int[] nums) {
        int left=0, right=0;
        while (right<nums.length){
            if (nums[left]!=nums[right]){
                int temp = nums[left+1];
                nums[left+1]=nums[right];
                nums[right]=temp;
                left++;
            }
            right++;
        }
        return left+1;
    
    }
}