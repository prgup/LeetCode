class Solution {
    public int maxProduct(int[] nums) {
        int n= nums.length;
        int prefix= nums[0];
        int suffix =nums[n-1];
        int ans = Math.max(prefix, suffix);
        for (int i=1; i< nums.length; i++){
            if (nums[i-1]==0)
            prefix = nums[i];
            else
            prefix*=nums[i];
            if (nums[n-i]==0)
            suffix = nums[n-i-1];
            else
            suffix*=nums[n-i-1];
            ans  = Math.max (ans, Math.max(prefix, suffix));

        }
        return ans;
        
    }
}