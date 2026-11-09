import java.util.*;
class Solution {
    public List<Integer> busiestServers(int k, int[] arrival, int[] load) {
        int[] counts = new int[k];
        PriorityQueue<int[]> busy = new PriorityQueue<>((a, b) -> Integer.compare(a[0], b[0]));
        TreeSet<Integer> free = new TreeSet<>();
        for (int i = 0; i < k; i++) free.add(i);
        int maxRequests = 0;
        for (int i = 0; i < arrival.length; i++) {
            int start = arrival[i];
            int end = start + load[i];
            while (!busy.isEmpty() && busy.peek()[0] <= start) {
                free.add(busy.poll()[1]);
            }
            if (free.isEmpty()) continue;
            Integer server = free.ceiling(i % k);
            if (server == null) server = free.first();
            counts[server]++;
            maxRequests = Math.max(maxRequests, counts[server]);
            busy.offer(new int[]{end, server});
            free.remove(server);
        }
        List<Integer> result = new ArrayList<>();
        for (int i = 0; i < k; i++) {
            if (counts[i] == maxRequests) result.add(i);
        }
        return result;
    }
}
