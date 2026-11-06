import java.util.Arrays;
import java.util.HashMap;
import java.util.Map;
public class Solution {
    public int[] countServers(int n, int[][] logs, int x, int[] queries) {
        int q=queries.length;
        int[] result = new int[q];
        int[][] sortedQueries = new int[q][2];
        for (int i = 0; i < q; i++) {
            sortedQueries[i][0] = queries[i];
            sortedQueries[i][1] = i;
        }
        Arrays.sort(logs, (a, b) -> Integer.compare(a[1], b[1]));
        Arrays.sort(sortedQueries, (a, b) -> Integer.compare(a[0], b[0]));
        Map<Integer, Integer> activeServers = new HashMap<>();
        int left = 0;
        int right = 0;
        for (int i = 0; i < q; i++) {
            int queryTime = sortedQueries[i][0];
            int originalIndex = sortedQueries[i][1];
            int windowStart = queryTime - x;
            int windowEnd = queryTime;
            while (right < logs.length && logs[right][1] <= windowEnd) {
                int serverId = logs[right][0];
                activeServers.put(serverId, activeServers.getOrDefault(serverId, 0) + 1);
                right++;
            }
            while (left < logs.length && logs[left][1] < windowStart) {
                int serverId = logs[left][0];
                if (activeServers.containsKey(serverId)) {
                    activeServers.put(serverId, activeServers.get(serverId) - 1);
                    if (activeServers.get(serverId) == 0) {
                        activeServers.remove(serverId);
                    }
                }
                left++;
            }
            result[originalIndex] = n - activeServers.size();
        }
        return result;
    }
}
