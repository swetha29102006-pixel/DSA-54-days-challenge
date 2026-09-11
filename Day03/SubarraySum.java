import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        HashMap<Integer, Integer> hm = new HashMap<>();

        int prefixSum = 0;

        hm.put(0, 1);

        int noOfSubArrayPossible = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];
        }

        return noOfSubArrayPossible;
    }
}
