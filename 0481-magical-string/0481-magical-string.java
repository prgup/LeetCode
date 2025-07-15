class Solution {
    public int magicalString(int n) {
        
        int[] magic = new int[n + 2];
        magic[0] = 1; magic[1]=2; magic[2]=2;
        int read = 2, write = 3;
        int current = 1;
        int countOnes = 1;

        while (write < n) {
            int repeat = magic[read++];
            for (int i = 0; i < repeat && write < n; i++) {
                magic[write++] = current;
                if (current == 1) countOnes++;
            }
            current = 3 - current;
        }

        return countOnes;
    }
}
