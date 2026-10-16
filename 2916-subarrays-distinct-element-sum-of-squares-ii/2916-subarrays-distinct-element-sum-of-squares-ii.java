import java.util.*;
class Solution {
    private static final int MOD = 1_000_000_007;
    private static class Node {
        long sum = 0, sumSq = 0, lazy = 0;
    }
    private Node[] tree;
    public int sumCounts(int[] nums) {
        int n = nums.length;
        tree = new Node[4 * n];
        for (int i = 0; i < tree.length; i++) tree[i] = new Node();
        Map<Integer, Integer> lastSeen = new HashMap<>();
        long totalSumSq = 0;
        for (int i = 0; i < n; i++) {
            int start = lastSeen.getOrDefault(nums[i], -1) + 1;
            update(1, 0, n - 1, start, i, 1);
            lastSeen.put(nums[i], i);
            totalSumSq = (totalSumSq + tree[1].sumSq) % MOD;
        }

        return (int) totalSumSq;
    }
    private void pushDown(int node, int start, int end) {
        if (tree[node].lazy == 0) return;
        int mid = start + (end - start) / 2;
        apply(2 * node, start, mid, tree[node].lazy);
        apply(2 * node + 1, mid + 1, end, tree[node].lazy);
        tree[node].lazy = 0;
    }
    private void apply(int node, int start, int end, long val) {
        long len = end - start + 1;
        tree[node].sumSq = (tree[node].sumSq + 2 * val * tree[node].sum % MOD + val * val % MOD * len % MOD) % MOD;
        tree[node].sum = (tree[node].sum + val * len) % MOD;
        tree[node].lazy = (tree[node].lazy + val) % MOD;
    }
    private void update(int node, int start, int end, int l, int r, long val) {
        if (l <= start && end <= r) {
            apply(node, start, end, val);
            return;
        }
        pushDown(node, start, end);
        int mid = start + (end - start) / 2;
        if (l <= mid) update(2 * node, start, mid, l, r, val);
        if (r > mid) update(2 * node + 1, mid + 1, end, l, r, val);
        tree[node].sum = (tree[2 * node].sum + tree[2 * node + 1].sum) % MOD;
        tree[node].sumSq = (tree[2 * node].sumSq + tree[2 * node + 1].sumSq) % MOD;
    }
}
