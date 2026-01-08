class Solution {

    public int sumFourDivisors(int[] nums) {

        int n = Arrays.stream(nums).max().orElse(0);//n
        int [] sieve = new int [n+1];

        Arrays.fill(sieve,1);
        sieve[0]=0;
        sieve[1]=0;
        sieveOfE(n, sieve);
        
        int ans = 0;
        for (int i : nums) {

            int c = (int) Math.cbrt(i);
            if ((int) Math.pow(c, 3) == i && sieve[c]==1){
                ans += 1+c+c*c+i;
                System.out.println(i);
                continue;
            }
            for (int j =2; j*j<=i+1; j++ ){
                if (i%j==0 && sieve[i/j]==1 && sieve[j]==1 && (j != i/j)){
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