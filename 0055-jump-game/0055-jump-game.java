class Solution {
    public boolean canJump(int[] nums) {
        int n = nums.length;
        int [] reach = new int[n];
        reach[n-1]=1;
        for (int i=nums.length-2; i >= 0; i--){
            int j= nums[i];
            int k= i, l= Math.min(n-1, i+j);
            while (k < l){
                reach[k]=reach[l];
                k++;
            }
        }
        return reach[0]==1?true:false;
    }
}