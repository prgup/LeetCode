class Solution {
    public int removeDuplicates(int[] nums) {
        int left=1, prev=nums[0];
        boolean flag = false;
        int n = nums.length;
        for (int i=1; i<n ;i++){
            if ( nums[i] != prev && nums[i] > prev){
                nums[left] = nums[i];
                left++;
                prev=nums[i];
            }
    
        }
        return left;
        
        
    }
}