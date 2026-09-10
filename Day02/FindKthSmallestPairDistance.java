import java.util.Arrays;

class Solution {
    public int smallestDistancePair(int[] numbers, int k) {
        Arrays.sort(numbers);

        int minDistance = 0;
        int maxDistance = numbers[numbers.length - 1] - numbers[0];

        while (minDistance < maxDistance) {
            int midDistance =
                minDistance + (maxDistance - minDistance) / 2;
        }

        return minDistance;
    }
}
