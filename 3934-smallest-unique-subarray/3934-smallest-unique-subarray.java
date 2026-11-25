class Solution {
    private static final long MOD = 1_000_000_007L;
    private static final long BASE = 100_003L;
    public int smallestUniqueSubarray(int[] nums) {
        int n = nums.length;
        int low = 1, high = n, ans = n;
        while (low <= high) {
            int mid = low + (high - low) / 2;
            if (hasUnique(nums, mid)) {
                ans = mid;
                high = mid - 1;
            } else {
                low = mid + 1;
            }
        }
        return ans;
    }
    private boolean hasUnique(int[] nums, int len) {
        int n = nums.length;
        long hash = 0, power = 1;
        for (int i = 0; i < len; i++) {
            hash = (hash * BASE + nums[i]) % MOD;
            if (i < len - 1) power = (power * BASE) % MOD;
        }
        Map<Long, Integer> freq = new HashMap<>();
        freq.put(hash, 1);
        for (int i = len; i < n; i++) {
            hash = (hash - (nums[i - len] * power) % MOD + MOD) % MOD;
            hash = (hash * BASE + nums[i]) % MOD;
            freq.put(hash, freq.getOrDefault(hash, 0) + 1);
        }
        for (int count : freq.values()) {
            if (count == 1) return true;
        }
        return false;
    }
}
