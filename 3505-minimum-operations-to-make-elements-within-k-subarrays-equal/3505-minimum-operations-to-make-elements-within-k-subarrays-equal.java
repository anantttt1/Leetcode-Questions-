import java.util.*;
public class Solution {
    public long minOperations(int[] nums, int x, int k) {
        int n = nums.length;
        long INF = (long) 1e16;
        long[] windowCost = new long[n];
        Arrays.fill(windowCost, INF);
        TreeMap<Integer, Integer> left = new TreeMap<>();
        TreeMap<Integer, Integer> right = new TreeMap<>();
        int leftCount = 0, rightCount = 0;
        long leftSum = 0, rightSum = 0;
        int targetLeft = (x + 1) / 2;
        for (int i = 0; i < n; i++) {
            if (left.isEmpty() || nums[i] <= left.lastKey()) {
                left.put(nums[i], left.getOrDefault(nums[i], 0) + 1);
                leftSum += nums[i];
                leftCount++;
            } else {
                right.put(nums[i], right.getOrDefault(nums[i], 0) + 1);
                rightSum += nums[i];
                rightCount++;
            }
            if (i >= x) {
                int out = nums[i - x];
                if (left.containsKey(out)) {
                    int cnt = left.get(out);
                    if (cnt == 1) left.remove(out);
                    else left.put(out, cnt - 1);
                    leftSum -= out;
                    leftCount--;
                } else {
                    int cnt = right.get(out);
                    if (cnt == 1) right.remove(out);
                    else right.put(out, cnt - 1);
                    rightSum -= out;
                    rightCount--;
                }
            }
            while (leftCount > targetLeft) {
                int val = left.lastKey();
                int cnt = left.get(val);
                if (cnt == 1) left.remove(val);
                else left.put(val, cnt - 1);
                leftSum -= val;
                leftCount--;
                right.put(val, right.getOrDefault(val, 0) + 1);
                rightSum += val;
                rightCount++;
            }
            while (leftCount < targetLeft && rightCount > 0) {
                int val = right.firstKey();
                int cnt = right.get(val);
                if (cnt == 1) right.remove(val);
                else right.put(val, cnt - 1);
                rightSum -= val;
                rightCount--;
                left.put(val, left.getOrDefault(val, 0) + 1);
                leftSum += val;
                leftCount++;
            }

            if (i >= x - 1) {
                long median = left.lastKey();
                long cost = (median * leftCount - leftSum) + (rightSum - median * rightCount);
                windowCost[i] = cost;
            }
        }
        long[][] dp = new long[n + 1][k + 1];
        for (int i = 0; i <= n; i++) {
            Arrays.fill(dp[i], INF);
            dp[i][0] = 0;
        }
        for (int i = 1; i <= n; i++) {
            for (int j = 1; j <= k; j++) {
                dp[i][j] = dp[i - 1][j];
                if (i >= x && windowCost[i - 1] != INF) {
                    dp[i][j] = Math.min(dp[i][j], dp[i - x][j - 1] + windowCost[i - 1]);
                }
            }
        }
        return dp[n][k] >= INF ? -1 : dp[n][k];
    }
}
