class Solution {
    public int characterReplacement(String s, int k) {
        int[] cnt = new int[26];
        int left = -1, right = -1, n = s.length(), ans = 0, maxA = 0;
        while (right < n - 1) {
            right++;
            cnt[s.charAt(right) - 'A']++;
            maxA = Math.max(maxA, cnt[s.charAt(right) - 'A']);
            while (right - left - k > maxA) {
                left++;
                cnt[s.charAt(left) - 'A']--;
            }
            ans = Math.max(ans, right - left);
        }
        return ans;
    }
}