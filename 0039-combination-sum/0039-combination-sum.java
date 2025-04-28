class Solution {
    List<List<Integer>> ans = new ArrayList<>();
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        Arrays.sort(candidates);
        List<Integer> temp = new ArrayList<>();
        backtrack ( 0,candidates, target, temp);
        return ans;
    }

    void backtrack (int idx, int [] li, int target, List <Integer> temp){
        if (target==0)
        ans.add(new ArrayList<>(temp));
        if (target<0)
        return;
        for (int i =idx; i<li.length; i++ ){
            if (li[i]>target)
            break;
            temp.add(li[i]);
            backtrack(i, li, target-li[i], temp);
            temp.remove(temp.size()-1);
        }
    }
}