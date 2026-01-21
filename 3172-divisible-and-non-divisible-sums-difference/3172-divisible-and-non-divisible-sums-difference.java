class Solution {
    public int differenceOfSums(int n, int m) {
        int k = n / m;                     // number of multiples of m
        return (n * (n + 1)) / 2           // total sum
               - k * (k + 1) * m;          // 2 * sum(divisible by m)
    }
}
