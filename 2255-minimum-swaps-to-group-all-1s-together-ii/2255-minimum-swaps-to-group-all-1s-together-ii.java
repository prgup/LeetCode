class Solution {
    public int minSwaps(int[] nums) {

        int one = 0, zero = 0, count = 0;
        int n = nums.length;

        for (int i : nums) {
            if (i == 1)
                count++;
        }

        if (count==0 || count==n)
        return 0;

        int left = 0, right = 0;

        int ans = Integer.MAX_VALUE;

        for ( right = 0; right < n + count; right++) {
            int num = nums[right % n];
            if (num == 0)
                zero++;
            while (right - left >= count) {
                int num1 = nums[left];
                if (num1 == 0)
                    zero--;
                left++;
            }
            if (right>=count)
                ans = Math.min(ans, zero);

        }
        return ans;

    }
}