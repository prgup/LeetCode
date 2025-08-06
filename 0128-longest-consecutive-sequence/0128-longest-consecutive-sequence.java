class Solution {
    public int longestConsecutive(int[] nums) {

        // Set<Integer> set = new HashSet<>();
        // Arrays.stream(nums).forEach(i -> set.add(i));

        // int startCount = (int) Arrays.stream(nums).filter(c-> !set.contains(c-1)).count();
        // List<Integer> startElement = set.stream().filter(c -> !set.contains(c - 1)).collect(Collectors.toList());

        // int ans = 0;
        // for (int current : startElement) {
        //     int tempCount = 0;
        //     while (set.contains(current)) {
        //         current++;
        //         tempCount++;
        //     }
        //     ans = Math.max(tempCount, ans);
        // }
        // return ans;


        Set<Integer> set = Arrays.stream(nums).boxed().collect(Collectors.toSet());
        return set.stream()
                .filter(n -> !set.contains(n - 1))
                .mapToInt(start -> {
                    int count = 0;
                    while (set.contains(start + count))
                        count++;
                    return count;
                })
                .max()
                .orElse(0);

    }
}