class Solution {
    public int splitArray(int[] nums, int k) {
        int low = 0, high = 0;
        
        for (int i : nums) {
            high += i;
            low = Math.max(i, low);
        }
        
        return find(low, high, nums, k);
    }
    
    private int find(int l, int h, int n[], int k) {
        if (l > h) return l;
        
        return 0;
    }
}
