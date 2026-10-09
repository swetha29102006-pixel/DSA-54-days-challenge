import java.util.Collections;
import java.util.PriorityQueue;

/**
 * LeetCode 295: Find Median from Data Stream
 * Design a data structure that supports adding numbers and finding the median in O(log N) and O(1) time.
 * Time Complexity: O(log N) for addNum, O(1) for findMedian.
 * Space Complexity: O(N) for storing elements in dual priority queues.
 */
public class FindMedianFromDataStream {
    private PriorityQueue<Integer> maxHeap;
    private PriorityQueue<Integer> minHeap;

    public FindMedianFromDataStream() {
        maxHeap = new PriorityQueue<>(Collections.reverseOrder());
        minHeap = new PriorityQueue<>();
    }

    public void addNum(int num) {
        maxHeap.add(num);
        minHeap.add(maxHeap.poll());
        if (maxHeap.size() < minHeap.size()) {
            maxHeap.add(minHeap.poll());
        }
    }

    public double findMedian() {
        if (maxHeap.size() > minHeap.size()) {
            return maxHeap.peek();
        }
        return (maxHeap.peek() + minHeap.peek()) / 2.0;
    }

    public static void main(String[] args) {
        FindMedianFromDataStream finder = new FindMedianFromDataStream();
        finder.addNum(1);
        finder.addNum(2);
        System.out.println("Median (1,2): " + finder.findMedian()); // 1.5
        finder.addNum(3);
        System.out.println("Median (1,2,3): " + finder.findMedian()); // 2.0
    }
}