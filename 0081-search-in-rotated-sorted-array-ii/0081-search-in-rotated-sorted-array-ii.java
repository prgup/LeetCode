class Solution {
    public boolean search(int[] nums, int target) {
        int left = 0, right = nums.length - 1;

        while (left <= right) {
            int mid = (left + right) / 2;

            if (nums[mid] == target) return true;

            if (nums[left]==nums[mid] && nums[mid]==nums[right]){
                left++;
                right--;
            }

            else if (nums[left] <= nums[mid]) {
                if (nums[left] <= target && target < nums[mid]) {
                    right = mid - 1; // target is in the left half
                } else {
                    left = mid + 1;
                }
            }
            // Right half is sorted
            else {
                if (nums[mid] < target && target <= nums[right]) {
                    left = mid + 1; // target is in the right half
                } else {
                    right = mid - 1;
                }
            }
        }

        return false;
    }
}
