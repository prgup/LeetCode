class Solution {
    public int lengthOfLongestSubstring(String s) {
        Map <Character, Integer> map = new HashMap<>();
        int left=0, ans=0,right=0;
        for (char c: s.toCharArray()){
            // right++;
            if (map.containsKey(c) && map.get(c)>=left){
                System.out.println(right+" "+left);
            ans = Math.max(right-left, ans);
            left = map.get(c)+1;
            }
            map.put(c, right);
            right++;
        }
        ans= Math.max(right-left, ans);
        
        return ans;
        
    }
}