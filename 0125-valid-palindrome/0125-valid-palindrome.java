class Solution {
    public boolean isPalindrome(String s) {
        String s2 = s.replaceAll("[^a-zA-Z\\d]", "").toLowerCase();
        String s1 = new StringBuilder(s2).reverse().toString();
        return s1.equals(s2);
    }
}