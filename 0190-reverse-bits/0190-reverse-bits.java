public class Solution {
    public int reverseBits(int n) {
        String input = Integer.toBinaryString(n);
       
        String ans = String.format("%32s" , input).replace(' ', '0');
        StringBuilder ans1 = (new StringBuilder(ans)).reverse();
        return (int) Long.parseLong(ans1+"",2);
    }

}