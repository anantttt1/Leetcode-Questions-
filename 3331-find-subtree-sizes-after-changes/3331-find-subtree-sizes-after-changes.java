class Solution {
    public int[] findSubtreeSizes(int[] parent, String s) {
        int n = parent.length;
        List<Integer>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) {
            adj[i] = new ArrayList<>();
        }
        for (int i = 1; i < n; i++) {
            adj[parent[i]].add(i);
        }
        int[] ans = new int[n];
        int[] lastSeen = new int[26];
        Arrays.fill(lastSeen, -1);
        dfs(0, -1, adj, s, lastSeen, ans);
        return ans;
    }
    private void dfs(int u, int p, List<Integer>[] adj, String s, int[] lastSeen, int[] ans) {
        int c = s.charAt(u) - 'a';
        int prev = lastSeen[c];
        int targetParent = prev != -1 ? prev : p;
        lastSeen[c] = u;
        ans[u] = 1;
        for (int v : adj[u]) {
            dfs(v, u, adj, s, lastSeen, ans);
        }
        lastSeen[c] = prev;
        if (targetParent != -1) {
            ans[targetParent] += ans[u];
        }
    }
}
