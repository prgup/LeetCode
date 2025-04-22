class Solution {
    public int maxProfit(int[] prices) {
        int n = prices.length;
        int low = prices[0];
        int high = prices[0];
        int ans =0;
        for (int i=0; i<n; i++){
            low = Math.min(prices[i], low);
            ans = Math.max(ans, prices[i]- low);
        }
        return ans;
        
    }
}