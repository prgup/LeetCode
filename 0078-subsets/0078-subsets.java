class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        //Lexographic // editorial3 //always sorted
        int n = nums.length;
        int pow = 1 << n;
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < pow; i++) {
            // String s = Integer.toBinaryString(i|pow).substring(1);
            List<Integer> subset = new ArrayList<>();
            int j = 0;
            while (j < n) {
                // if (s.charAt(j)=='1')
                if ((i & (1 << j)) != 0)
                    subset.add(nums[j]);
                j++;
            }
            ans.add(subset);
        }
        return ans;

    }
}