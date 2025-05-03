class Solution {
    public List<Integer> findDuplicates(int[] nums) {
        for (int i =0; i<nums.length; i++){
            //putting value to it's original idx place
            while (nums[i]!= nums[nums[i]-1]){
            int j = nums[i]; 
            int temp = nums[j-1]; 
            nums[j-1] = j; 
            nums[i] = temp;
            }
        }
        System.out.println(Arrays.toString(nums));
        List <Integer> ans = new ArrayList<>();
        for (int i=0; i<nums.length; i++){
            if (nums[i]!= i+1 )
            ans.add(nums[i]);
        }
        return ans;
    }
}