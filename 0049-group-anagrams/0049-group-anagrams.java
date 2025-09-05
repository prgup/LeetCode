class Solution {
    public List<List<String>> groupAnagrams(String[] strs) {
        Map<String, List<String>> map = new HashMap<>();
        for (String str : strs){
            int [] charCount = new int[26];
            for (int i=0; i<str.length(); i++){
                charCount[str.charAt(i)-'a']++;
            }
            String charString=Arrays.toString(charCount);
            map.computeIfAbsent(charString, k -> new ArrayList<>()).add(str);
        }
        List<List<String>> ans = new ArrayList<>(map.values());
        return ans; 
    }
}