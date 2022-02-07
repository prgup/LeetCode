class Solution {
    public int canCompleteCircuit(int[] gas, int[] cost) {
        //Arrays.copyOfRange(li, 0, li.length);
        int ans=-1, till=0,sum=0;
        boolean flag = true;
        for (int i=0; i<gas.length; i++){
            gas[i]-=cost[i];
            till+=gas[i];
            sum+=gas[i];
            if (sum<0){
                flag =true;
                sum=0;
                ans= -1;
            }
            else if (sum >=0 && flag){
                flag= false;
                ans=i;
            }
        }
       
        return (till <0)?-1:ans;
    }
}