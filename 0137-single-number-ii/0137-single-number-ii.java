class Solution {
    public int singleNumber(int[] nums) {
        int one=0, two=0, three=0;
        for (int i:nums){
            two|=(one&i);
            one^=i;
            three=one&two;
            one&=(~three);
            two&=(~three);
        }
        return one;
    }
}