class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);//nlogn
        
        int mid = nums.length/2;
        int prev =nums[mid-2];
        for (int i=mid-1; i<mid+2; i++){
            if (prev==nums[i]){
                return prev;
            }
            prev=nums[i];

        }
        return -1;
        
    }
}