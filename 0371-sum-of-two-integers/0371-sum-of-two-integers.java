class Solution {
    public int getSum(int a, int b) {
        if (b == 0)
            return a;
        int num = a ^ b;
        int carry = (a & b) << 1;
        return getSum(num, carry);

    }
}