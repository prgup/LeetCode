class Solution {
    public boolean isHappy(int n) {
        Set <Integer> set = new HashSet<>();
        set.add(n);
        while (true){
            if (n==1)
            return true;
            n = squareHelper(n);
            if (!set.add(n))
            return false;
        }

    }
    private int squareHelper(int n){
        int ans=0;
        while(n>0){
            int i = n%10;
            ans += (i*i);
            n=n/10;
        }
        return ans;
    }
}