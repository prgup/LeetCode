class Solution {
    public int coinChange(int[] coins, int amount) {
        if (amount == 0)
            return 0;
        int[] ans = new int[amount + 1];
        ans[0] = 1;
        for (int i = 0; i < amount; i++) {
            if (ans[i] == 0)
                continue;
            for (int j : coins) {
                if (j> amount || (i + j) > amount)
                    continue;
                if (ans[i + j] != 0)
                    ans[i + j] = Math.min(ans[i] + 1, ans[i + j]);
                else
                    ans[i + j] = ans[i] + 1;
            }
        }
        return ans[amount] - 1;

    }
}