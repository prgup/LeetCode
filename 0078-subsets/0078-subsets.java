class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        ans.add(new ArrayList<>()); // start with empty subset
        generate(nums, 0, ans);
        return ans;
    }

    void generate(int[] nums, int idx, List<List<Integer>> ans) {
        if (idx == nums.length) return;

        int size = ans.size();
        for (int i = 0; i < size; i++) {
            List<Integer> newSubset = new ArrayList<>(ans.get(i));
            newSubset.add(nums[idx]);
            ans.add(newSubset);
        }

        generate(nums, idx + 1, ans);
    }
}
