class Solution {
    public int firstMissingPositive(int[] li) {
        int n = li.length;
        for (int i=0; i<n;i++){
            while (li[i]> 0 && li[i]<n &&  li[i]!=i && li[i]!=li[li[i]] ){
                int temp=li[li[i]];
                li[li[i]]=li[i];
                li[i]=temp;
            }
        }
        // System.out.println(Arrays.toString(li));
        int ans=n;
        for (int i=1 ; i<n; i++){
            if (li[i]!=i){
                ans=i;
                break;
            }
        }

        return (ans<n)?ans:(li[0]==n?n+1:n);
        
    }
}