class Solution {
    public int[] productExceptSelf(int[] nums) {

        int n = nums.length;
        int[] res = new int[n];

        int pre = 1;

        for(int i = 0; i < n; i++){
            res[i] = pre;
            pre *= nums[i];
        }
    }
}
