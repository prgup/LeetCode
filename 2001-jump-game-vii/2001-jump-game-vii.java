class Solution {
    public boolean canReach(String s, int minJump, int maxJump) {
        int i=0, j=0, n=s.length();
        char [] li = s.toCharArray(); 
        for (i=0; i<n; i++){
            
            if (i==0 || li[i]=='o')//o==ok
                for (j = Math.max(j, i+minJump); j< Math.min(n,i+maxJump+1 );j++)
                    if (li[j]=='0')
                        li[j]='o';
            if (j>n)
                break;
        }
        return li[n-1]=='o';
           
    }
}

//can we done also with sliding window approch