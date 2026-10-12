class Solution {
    public int maxSum(List<Integer> nums, int k) {
        long mod = 1_000_000_007;
        int[] bitCounts = new int[31];
        for (int num : nums) {
            for (int i = 0; i < 31; i++) {
                if (((num >> i) & 1) == 1) {
                    bitCounts[i]++;
                }
            }
        }
        long ans = 0;
        for (int j = 0; j < k; j++) {
            long currentNum = 0;
            for (int i = 0; i < 31; i++) {
                if (bitCounts[i] > 0) {
                    currentNum |= (1L << i);
                    bitCounts[i]--;
                }
            }
            ans = (ans + (currentNum * currentNum)) % mod;
        }
        return (int) ans;
    }
}
