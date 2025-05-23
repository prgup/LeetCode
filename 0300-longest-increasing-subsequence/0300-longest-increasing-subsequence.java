class Solution {
    public int lengthOfLIS(int[] nums) {
        List<Integer> list = new ArrayList<>();
        list.add(nums[0]);
        for (int i : nums) {
            if (list.get(list.size() - 1) < i) {
                list.add(i);
            } else {
                int idx = Collections.binarySearch(list, i);
                if (idx<0)
                idx=(-idx-1);
                list.set(idx, i);
            }
        }
        return list.size();

    }
}