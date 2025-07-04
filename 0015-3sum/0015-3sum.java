class Solution {
    public List<List<Integer>> threeSum(int[] nums) {

        Arrays.sort(nums);
        int n = nums.length;
        if (nums[n - 1] < 0 || nums[0] > 0)
            return new ArrayList<>();
        List<List<Integer>> ans = new ArrayList<>();
        for (int i = 0; i < n - 2; i++) {
            if (i > 0 && nums[i - 1] == nums[i])
                continue;
            int right = n - 1;
            int left = i + 1;
            while (left < right) {
                int sum = nums[i] + nums[left] + nums[right];
                if (sum == 0) {
                    List<Integer> temp = new ArrayList<>();
                    temp.add(nums[i]);
                    temp.add(nums[left]);
                    temp.add(nums[right]);
                    ans.add(temp);
                    int current = nums[left];
                    while (nums[left] == current && left < n - 1)
                        left++;
                    while (left < right && nums[right] == nums[right -1]) 
                        right--;
                }
                else if (sum < 0)
                    left++;
                else
                    right--;
            }

        }
        return ans;

    }
}