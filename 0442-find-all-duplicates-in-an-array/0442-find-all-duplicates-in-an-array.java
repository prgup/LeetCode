class Solution {
    //Sign Marking Trick 
    public List<Integer> findDuplicates(int[] nums) {
        List<Integer> ans = new ArrayList<>();
        for (int i:nums){
            int idx= Math.abs(i);
            if (nums[idx-1]<0)
            ans.add(Math.abs(i));
            nums[idx-1]=-nums[idx-1];

        }
        return ans;
        
    }
}