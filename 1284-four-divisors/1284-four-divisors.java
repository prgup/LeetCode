class Solution {

    public int sumFourDivisors(int[] nums) {

        int n = Arrays.stream(nums).max().orElse(0);
        int [] sieve = new int [n+1];

        Arrays.fill(sieve,1);
        sieveOfE(n, sieve);
        Set <Integer> set = new HashSet<>();
        for (int i=2; i<n+1; i++){
            if (sieve[i]==1){
                set.add(i);
            }
        }
        
        // n*n brute force
        //n*sqrt(n)
        //n*log(log(n))  

        int ans = 0;
        for (int i : nums) {

            int c = (int) Math.cbrt(i);
            if ((int) Math.pow(c, 3) == i && set.contains(c)){
                ans += 1+c+c*c+i;
                System.out.println(i);
                continue;
            }
            for (int j : set){
                if (i%j==0 && set.contains(i/j) && (j != i/j)){
                    ans+= 1 + i +j + i/j;
                    System.out.println(i);
                    break;
                }
            }
        }
        return ans;





    }

    void sieveOfE(int n, int [] sieve){

        boolean [] flag = new boolean [n+1];
        Arrays.fill(flag, true);
        for (int i=2; i < Math.sqrt(n)+1; i++){
            if (!flag[i])
            continue;
            for (int j=i*i; j<n+1 ; j+=i){
                if (j%i==0){
                flag[j]=false;
                sieve[j]=0;
                }
            }
        }
    }


}