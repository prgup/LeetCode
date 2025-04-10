class Solution {
    public String longestPalindrome(String s) {
        int n=s.length();
        
        int ans=1, l=0, r=0;
        for (int i=0;i<n; i++){
            boolean even = true, odd = true;
            int l1=i,l2=i-1, r1=i+1,r2=i+1;
               
            
            while (even || odd){
                if (l1<0 || r1>=n)
                        even=false;  
             if (l2<0 || r2>=n)
                        odd=false;
                if (even){
                    if (s.charAt(l1)==s.charAt(r1)){
                        if (ans <r1-l1+1){
                            r=r1;
                            l=l1;
                            ans=r1-l1+1;
                        }
                        l1--;
                        r1++;
                    }
                    else 
                        even=false;
                   
                }
                if (odd){
                     if (s.charAt(l2)==s.charAt(r2)){
                         if (ans <r2-l2+1){
                            r=r2;
                            l=l2;
                            ans=r2-l2+1;
                        }
                        l2--;
                        r2++;
                    }
                    else 
                        odd=false;
                   
                }
            }
        }
        // System.out.println(l+" "+r);
        return s.substring(l,r+1);
        
    }
}