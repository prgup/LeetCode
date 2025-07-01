class Solution {
    public int numOfSubarrays(int[] arr) {
        final int MOD = 1_000_000_007;
        int even=1, odd=0;
        int ans = 0;
        int sum=0;
        for (int i : arr){
            sum +=(i%2);
            if (sum%2==0){
                ans = (ans+odd)%MOD;
                even++;
            }
            else {
                ans = (ans+even)%MOD;
                odd++;
            }
        }
        return ans;
    
        
    }
}