class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        
        for (int i : nums) {
            high += i;
            low = Math.max(i, low);
        }
        
        return 0;
    }
}
