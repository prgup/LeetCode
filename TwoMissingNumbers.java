/**

You are given an array A of n - 2 integers which are in the range between 1 and n. All numbers appear exactly once, 
except two numbers, which are missing. Find these two missing numbers.

https://florian.github.io//xor-trick/
*/


import java.util.*;

public class TwoMissingNumbers {
    public static void main (String [] argv){
        Scanner sc = new Scanner(System.in);
        int n  = sc.nextInt(); 
        int [] input = new int[n-2];
        int xor =0;
        for (int j=0; j<n-2;j++){
             input[j] = sc.nextInt();
             xor^=input[j];
         }

        for (int i=1; i<=n; i++){
            xor^=i;
        }
        // xor become a^b;

        int i=0;
        String str1 = Integer.toBinaryString(xor);
        //finding pivot, the first 1 from Lhs
        for ( i=str1.length()-1; i>=0; i--){
            if (str1.charAt(i)=='1')
                break;

        }
        int pivot = (int) Math.pow(2, str1.length()-i-1);
        System.out.println(pivot);


        //finding missing elements
        List<Integer> li1 = new ArrayList<>();//till n
        List<Integer> mi1 = new ArrayList<>(); // til all  the elements
        for ( i=1; i<=n; i++){
            if ((i&pivot) >0 )
                li1.add(i);
        }
        for ( int j: input){
             if ((j&pivot) >0 )
                mi1.add(j);
        }
        int ans1 = 0;
        for (int j: li1){
            ans1^=j;
        }
        for (int j: mi1){
            ans1^=j;
        }

        List<Integer> li2 = new ArrayList<>();//till n
        List<Integer> mi2 = new ArrayList<>(); // til all  the elements
        for ( i=1; i<=n; i++){
            if ((i&pivot) ==0 )
                li2.add(i);
        }
        for ( int j: input){
             if ((j&pivot) ==0 )
                mi2.add(j);
        }
        int ans2=0;
        for (int j: li2){
            ans2^=j;
        }
        for (int j: mi2){
            ans2^=j;
        }

        System.out.println("Missing numbers     \n" + ans1 + "     "+ ans2) ;
      
    }
}
