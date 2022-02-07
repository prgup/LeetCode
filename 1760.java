class Solution {
    public int minimumSize(int[] nums, int maxOperations) {
        int l=1, r= 1_000_000_000;
        while (l < r){
            int cnt=0, mid = l+(r-l)/2;
            for (int i: nums)
                cnt += ((i-1)/mid);
            if (cnt > maxOperations)
                l=mid+1;
            else r = mid;
        }
        return l;
    }
}