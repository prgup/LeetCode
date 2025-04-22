class Solution {
    public int maxSubArray(int[] li) {
        int ans =li[0];
        for (int i=1; i<li.length; i++){
            // ans = Math.max(ans, li)
            li[i] = Math.max(li[i], li[i]+ li[i-1]);
            ans = Math.max(ans,li[i]);
        }
        return ans;

        
    }
}