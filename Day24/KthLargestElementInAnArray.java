import java.util.PriorityQueue;

/**
 * LeetCode 215: Kth Largest Element in an Array
 * Find the kth largest element in an unsorted array using a Min-Heap.
 * Time Complexity: O(N log k) where N is array length.
 * Space Complexity: O(k) for min-heap storage.
 */
public class KthLargestElementInAnArray {
    public int findKthLargest(int[] nums, int k) {
        PriorityQueue<Integer> minHeap = new PriorityQueue<>();
        for (int num : nums) {
            minHeap.add(num);
            if (minHeap.size() > k) {
                minHeap.poll();
            }
        }
        return minHeap.peek();
    }

    public static void main(String[] args) {
        KthLargestElementInAnArray solver = new KthLargestElementInAnArray();
        int[] nums = {3, 2, 1, 5, 6, 4};
        System.out.println("2nd Largest: " + solver.findKthLargest(nums, 2)); // 5
    }
}