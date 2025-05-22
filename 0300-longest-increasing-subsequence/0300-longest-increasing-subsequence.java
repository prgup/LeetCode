class Solution {
    public int lengthOfLIS(int[] nums) {
        int n = nums.length;
        int [] ans = new int[n];
        Arrays.fill(ans,1);
        for (int i=n-2; i>-1; i--){
            int j=i+1;
            while (j<n){
                if (nums[j]>nums[i]){
                    ans[i]=Math.max(ans[i], ans[j]+1);
                }
                j++;
            }

        }
        System.out.println(Arrays.toString(ans));
        int result=0;
        for (int i: ans){
            result=Math.max(i, result);
        }
        return result;
        
            
        
    }
}