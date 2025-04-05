class Solution {
    public int[] twoSum(int[] nums, int target) {
        int n = nums.length;
        int [] li = Arrays.copyOf(nums, n);
        Arrays.sort(li);
        int left = 0, right=n-1;
        while (right>left){
            if (li[right]+li[left]==target)
            break;
            else if (li[right]+li[left] > target)
            right--;
            else
            left++;
        }
        int [] ans = new int[] {-1,-1};
        for (int i=0; i<n; i++){
            if (nums[i]==li[left] && ans[0]==-1)
            ans[0]=i;
            else if (nums[i]== li[right])
            ans[1]=i;

        }
        return ans;
        
    }
}