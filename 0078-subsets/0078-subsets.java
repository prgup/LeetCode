class Solution {
    private int n;
    List<List<Integer>> ans = new ArrayList<>();

    public void backtrack (int [] nums, List<Integer> curr, int idx){
        ans.add(new ArrayList<>(curr));
        // ans.add(curr); // good error
        for (int i=idx; i<n; i++){
            curr.add(nums[i]);
            backtrack(nums, curr, i+1);
            curr.remove(curr.size()-1);
        }
    }
    public List<List<Integer>> subsets(int[] nums) {
        n = nums.length;
        List<Integer> curr = new ArrayList<>();
        backtrack(nums, curr, 0);
        return ans;

    }
}