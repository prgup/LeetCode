class Solution {
    public List<List<Integer>> combinationSum(int[] candidates, int target) {
        List<List<Integer>> [] dp = new ArrayList[target+1];
        for (int i=0; i<=target; i++){
            dp[i] = new ArrayList<>();
        }
        dp[0].add(new ArrayList<>());

        for (int candidate: candidates){
            for (int i=candidate; i<=target; i++){
                for (List<Integer> comb : dp[i-candidate]){
                    List<Integer> newComb = new ArrayList<>(comb);
                    newComb.add(candidate);
                    dp[i].add(newComb);
                }
            }
        }
        return dp[target];
        
    }
}