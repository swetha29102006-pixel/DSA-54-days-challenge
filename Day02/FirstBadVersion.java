public class Solution extends VersionControl {
    public int firstBadVersion(int n) {
        if (n == 1) return 1;

        int l = 0;
        int r = n;

        int fBR = -1;

        while (l <= r) {
            int mid = l + (r - l) / 2;

            boolean res = isBadVersion(mid);

            if (res) {
                fBR = mid;
                r = mid - 1;
            }
        }

        return fBR;
    }
}
