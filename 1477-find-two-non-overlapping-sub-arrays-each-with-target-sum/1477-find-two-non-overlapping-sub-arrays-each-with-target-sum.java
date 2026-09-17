class Solution {
    public int minSumOfLengths(int[] arr, int target) {
        int n = arr.length;
        int[] dp = new int[n];
        final int INF = 100000000;
        java.util.Arrays.fill(dp, INF);
        int minTotalLength = INF;
        int currentSum = 0;
        int left = 0;
        for (int right=0;right<n;right++) {
            currentSum+=arr[right];
            while (currentSum>target) {
                currentSum-=arr[left];
                left++;
            }
            if (currentSum==target) {
                int currentLen = right - left + 1;
                if (left > 0 && dp[left - 1] != INF) {
                    minTotalLength = Math.min(minTotalLength, currentLen + dp[left - 1]);
                }
                if (right > 0) {
                    dp[right] = Math.min(dp[right - 1], currentLen);
                } else {
                    dp[right] = currentLen;
                }
            } else {
                if (right > 0) {
                    dp[right] = dp[right - 1];
                }
            }
        }
        return minTotalLength >= INF ? -1 : minTotalLength;
    }
}
