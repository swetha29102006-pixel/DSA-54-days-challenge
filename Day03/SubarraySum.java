import java.util.HashMap;

class Solution {
    public int subarraySum(int[] nums, int k) {
        // HashMap stores prefix sum and its frequency
        HashMap<Integer, Integer> hm = new HashMap<>();

        int prefixSum = 0;

        // Handles subarrays starting from index 0
        hm.put(0, 1);

        int noOfSubArrayPossible = 0;

        for (int i = 0; i < nums.length; i++) {
            prefixSum += nums[i];

            // Find the prefix sum that needs to be removed
            int remove = prefixSum - k;

            // Add the number of matching prefix sums
            if (hm.containsKey(remove)) {
                noOfSubArrayPossible += hm.get(remove);
            }

            // Store current prefix sum frequency
            hm.put(prefixSum, hm.getOrDefault(prefixSum, 0) + 1);
        }

        return noOfSubArrayPossible;
    }
}
