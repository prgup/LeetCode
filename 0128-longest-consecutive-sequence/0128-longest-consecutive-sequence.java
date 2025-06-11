class Solution {
    public int longestConsecutive(int[] nums) {
        Set <Integer> set = new HashSet<>();
        for (int i: nums){
            set.add(i);
        }
        int ans=0;
        for (int i: set){
            if (set.contains(i-1))
            continue;
            int cnt=1;
            int j=1;
            while (set.contains(j+i)){
                j++;
                cnt++;
            }
            ans= Math.max(ans, cnt);
        }
        return ans;
    }
}