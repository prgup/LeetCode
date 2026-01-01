class Solution {
    public int[] plusOne(int[] digits) {
        int carry=0;
        int n = digits.length-1;
        digits[n]++;
        do {
        int total = digits[n]+carry;
        digits[n] = total%10;
        carry= total/10;
        n--;
        }
        while (carry>0 && n>-1);

        if (carry!=0){
            int [] newDigits = new int[digits.length+1];
            newDigits[0]=carry;
            int i=1;
            for (int digit : digits){
                newDigits[i]=digit;
                i++;
            }
            return newDigits;
        }
        return digits;

        
    }
}