class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int left = -1, right = -1, n = s.length(), ans = 0;
        while (right < n - 1) {
            right++;
            cnt[s.charAt(right) - 'A']++;
            int maxA=maxC(cnt);
            while (right - left - k > maxA) {
                left++;
                cnt[s.charAt(left) - 'A']--;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }

    int maxC(int[] nums) {
        int val = 0;
        for (int i : nums) {
            if (i > val)
                val = i;
        }
        return val;
    }
}