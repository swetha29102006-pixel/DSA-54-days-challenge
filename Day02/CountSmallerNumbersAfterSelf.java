class Solution {
    int[] bit = new int[20002];

    void add(int i) {
        while (i < bit.length) {
            bit[i]++;
            i += i & -i;
        }
    }

    public List<Integer> countSmaller(int[] nums) {
        int n = nums.length;
        Integer[] ans = new Integer[n];

        return Arrays.asList(ans);
    }
}
