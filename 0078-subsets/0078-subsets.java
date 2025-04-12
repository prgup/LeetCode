class Solution {
    public List<List<Integer>> subsets(int[] nums) {
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println("1"+ ans.toString());
        ans.add(new ArrayList<>());
        System.out.println("2"+ans.toString());
        generate(nums, 0, ans);
        System.out.println("8"+ans.toString());
        return ans;
    }
    void generate (int [] nums, int idx, List<List<Integer>> temp ){
        if  ( idx == nums.length){
            System.out.println("9"+temp.toString());
                    return;
        }
        List<List<Integer>> ans = new ArrayList<>();
        System.out.println("3" + ans.toString());
        for (List<Integer> li : temp){
            ans.add(new ArrayList<>(li));
            System.out.println("4"+ ans.toString());
            li.add(nums[idx]);
            ans.add(new ArrayList<>(li));
            System.out.println("5"+ans.toString());
        }
        System.out.println("6"+temp.toString());
        temp.clear();        
        temp.addAll(ans);
        System.out.println("7"+temp.toString());
        generate (nums, idx+1, temp);
    }
}