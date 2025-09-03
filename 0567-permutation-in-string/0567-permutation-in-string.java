class Solution {
    public boolean checkInclusion(String s1, String s2) {
        if (s2.length()<s1.length())
        return false;
        int[] count = new int[26];
        for (int i = 0; i < s1.length()-1; i++) {
            count[s2.charAt(i) - 'a']++;
            count[s1.charAt(i) - 'a']--;
        }
        int left = 0, right = s1.length() - 1;
        count[s1.charAt(right)-'a']--;
        while (right < s2.length()) {
            count[s2.charAt(right)-'a']++;
            boolean flag = true;
            for (int i = 0; i < s1.length(); i++) {
                if (count[s1.charAt(i) - 'a'] != 0) {
                    flag = false;
                    break;
                }
            }
            if (flag)
                return true;
            count[s2.charAt(left) - 'a']--;
            right++;
            left++;
        }
        return false;
    }
}