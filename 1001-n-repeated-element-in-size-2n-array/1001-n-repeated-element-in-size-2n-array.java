class Solution {
    public int repeatedNTimes(int[] nums) {
        Arrays.sort(nums);//nlogn
        int prev =-1;
        for (int i: nums){ //n
            if (i==prev)
            return i;
            prev=i;
        }
        return -1;
        
    }
}