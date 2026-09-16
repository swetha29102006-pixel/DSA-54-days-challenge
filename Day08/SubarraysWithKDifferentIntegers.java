class Solution {
    public int subarraysWithKDistinct(int[] nums, int k) {
        return check(nums, k);
    }

    public int check(int[] nums, int k) {
        int l = 0;
        int r = 0;
        int cnt = 0;
        HashMap<Integer, Integer> h = new HashMap<>();

        for (r = 0; r < nums.length; r++) {
            h.put(nums[r], h.getOrDefault(nums[r], 0) + 1);
        }

        return cnt;
    }
}
