class Solution {
    public int jump(int[] nums) {
        int jump = 0;
        int n = nums.length;
        int lastJump = 0;
        int reach = 0;
        for (int i = 0; i < n - 1; i++) {
            // reach = Math.max(reach, nums[i] + i * ((nums[i] == 0) ? 0 : 1));
            reach = Math.max(reach, nums[i] + i);
            if (i == lastJump) {
                lastJump = reach;
                jump++;
                if (lastJump >= n-1)
                break;
            }
        }
        return jump;

    }
}