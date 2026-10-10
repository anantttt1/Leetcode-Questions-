class Solution {
    public long minSumSquareDiff(int[] nums1, int[] nums2, int k1, int k2) {
        int n = nums1.length;
        long k = (long) k1 + k2;
        int[] buckets = new int[100001]; 
        long sum = 0;
        int maxDiff = 0;
        for (int i = 0; i < n; i++) {
            int diff = Math.abs(nums1[i] - nums2[i]);
            if (diff > 0) {
                buckets[diff]++;
                sum += diff;
                maxDiff = Math.max(maxDiff, diff);
            }
        }
        if (sum <= k) return 0;
        for (int d = maxDiff; d > 0 && k > 0; d--) {
            if (buckets[d] == 0) continue;
            long needed = (long) buckets[d];
            if (k >= needed) {
                buckets[d - 1] += buckets[d];
                buckets[d] = 0;
                k -= needed;
            } else {
                int take = (int) k;
                buckets[d - 1] += take;
                buckets[d] -= take;
                k = 0;
            }
        }
        long ans = 0;
        for (int d = 1; d <= maxDiff; d++) {
            if (buckets[d] > 0) {
                ans += (long) buckets[d] * d * d;
            }
        }
        return ans;
    }
}
