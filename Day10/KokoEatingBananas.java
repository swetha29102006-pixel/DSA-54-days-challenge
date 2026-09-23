class Solution {
    public int minEatingSpeed(int[] piles, int h) {
        if (piles == null || piles.length == 0) {
            return 0;
        }

        int left = 1;
        int right = 0;
        for (int pile : piles) {
            right = Math.max(right, pile);
        }

        // Binary search on answer speed range [1, max(piles)]
        while (left < right) {
            int mid = left + (right - left) / 2;
            long hoursNeeded = getHours(piles, mid);

            if (hoursNeeded <= h) {
                right = mid; // Can finish in time; try slower speed
            } else {
                left = mid + 1; // Cannot finish in time; must eat faster
            }
        }

        return left;
    }

    private long getHours(int[] piles, int speed) {
        long hours = 0;
        for (int pile : piles) {
            // Integer ceiling division: ceil(pile / speed)
            hours += (pile + speed - 1) / speed;
        }
        return hours;
    }
}