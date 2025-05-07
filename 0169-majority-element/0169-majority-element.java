class Solution {
    public int majorityElement(int[] nums) {
        int a=nums[0], b= 1;
        for (int i=1;i<nums.length; i++){
            if (nums[i]==a)
            b++;
            else if (b==0){
                a=nums[i];
                b=1;
            }
            else 
            b--;

        }
        return a;
        
    }
}