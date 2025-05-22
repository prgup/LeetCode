public class Solution {
    private static final int[] reverseTable = new int[256];

    static {
        for (int i = 0; i < 256; i++) {
            reverseTable[i] = reverseByte(i);
        }
    }

    private static int reverseByte(int b) {
        int res = 0;
        for (int i = 0; i < 8; i++) {
            res <<= 1;
            res |= (b & 1);
            b >>= 1;
        }
        return res;
    }

    public int reverseBits(int n) {
        int ans=0;
        for (int i=0; i<4; i++){
            int bit = n&255;
            ans<<=8;
            ans|=reverseTable[bit];
            n>>=8;
        }
        return ans;
    }
}
