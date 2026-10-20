import java.util.Arrays;
class Solution {
    public int sortableIntegers(int[] nums) {
        int n = nums.length;
        int sumOfK = 0;
        for (int k = 1; k <= n; k++) {
            if (n % k == 0) {
                if (canBeSorted(nums, k)) {
                    sumOfK += k;
                }
            }
        }
        return sumOfK;
    }
    private boolean canBeSorted(int[] nums, int k) {
        int n = nums.length;
        int lastMax = Integer.MIN_VALUE;
        for (int i = 0; i < n; i += k) {
            int breakCount = 0;
            int breakIdx = -1;
            int gMin = Integer.MAX_VALUE;
            int gMax = Integer.MIN_VALUE;
            for (int j = i; j < i + k; j++) {
                gMin = Math.min(gMin, nums[j]);
                gMax = Math.max(gMax, nums[j]);
                if (j < i + k - 1 && nums[j] > nums[j + 1]) {
                    breakCount++;
                    breakIdx = j;
                }
            }
            if (breakCount > 1) return false;
            if (breakCount == 1) {
                if (nums[i + k - 1] > nums[i]) return false;
                gMin = nums[breakIdx + 1];
                gMax = nums[breakIdx];
            }
            if (gMin < lastMax) return false;
            lastMax = gMax;
        }
        return true;
    }
}
