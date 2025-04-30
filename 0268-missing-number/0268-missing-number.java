class Solution {
    public int missingNumber(int[] nums) {
        int xor =0, j=0;
        for (int i:nums){
            xor^=i;
            xor^=j;
            j++;
        }
        xor^=j;
        return xor;
        
    }
}