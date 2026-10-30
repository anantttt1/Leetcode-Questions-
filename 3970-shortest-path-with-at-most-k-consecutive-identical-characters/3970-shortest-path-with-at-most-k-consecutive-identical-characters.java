import java.util.*;
class Solution {
    public int shortestPath(int n, int[][] edges, String labels, int k) {
        List<int[]>[] adj = new ArrayList[n];
        for (int i = 0; i < n; i++) adj[i] = new ArrayList<>();
        for (int[] e : edges) adj[e[0]].add(new int[]{e[1], e[2]});
        int[][] dist = new int[n][k + 1];
        for (int[] row : dist) Arrays.fill(row, Integer.MAX_VALUE);
        PriorityQueue<int[]> pq = new PriorityQueue<>(Comparator.comparingInt(a -> a[0]));
        dist[0][1] = 0;
        pq.offer(new int[]{0, 0, 1});
        while (!pq.isEmpty()) {
            int[] cur = pq.poll();
            int d = cur[0], u = cur[1], count = cur[2];
            if (d > dist[u][count]) continue;
            for (int[] nxt : adj[u]) {
                int v = nxt[0], w = nxt[1];
                int nxtCount = (labels.charAt(v) == labels.charAt(u)) ? count + 1 : 1;
                if (nxtCount <= k && d + w < dist[v][nxtCount]) {
                    dist[v][nxtCount] = d + w;
                    pq.offer(new int[]{d + w, v, nxtCount});
                }
            }
        }
        int ans = Integer.MAX_VALUE;
        for (int c : dist[n - 1]) ans = Math.min(ans, c);
        return ans == Integer.MAX_VALUE ? -1 : ans;
    }
}
