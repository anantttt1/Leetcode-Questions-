import java.util.ArrayList;
import java.util.Arrays;
import java.util.List;
class Solution {
    public List<String> maxNumOfSubstrings(String s) {
        int n = s.length();
        int[] left = new int[26];
        int[] right = new int[26];
        Arrays.fill(left, n);
        Arrays.fill(right, -1);
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            left[idx] = Math.min(left[idx], i);
            right[idx] = i;
        }
        List<String> res = new ArrayList<>();
        int lastRight = -1;
        for (int i = 0; i < n; i++) {
            int idx = s.charAt(i) - 'a';
            if (i != left[idx]) {
                continue;
            }
            int newRight = checkInterval(s, i, left, right);
            if (newRight == -1) {
                continue;
            }
            if (i <= lastRight && !res.isEmpty()) {
                res.set(res.size() - 1, s.substring(i, newRight + 1));
            } else {
                res.add(s.substring(i, newRight + 1));
            }
            lastRight = newRight;
        }
        return res;
    }
    private int checkInterval(String s, int start, int[] left, int[] right) {
        int maxRight = right[s.charAt(start) - 'a'];
        for (int j = start; j <= maxRight; j++) {
            int currentIdx = s.charAt(j) - 'a';
            if (left[currentIdx] < start) {
                return -1;
            }
            maxRight = Math.max(maxRight, right[currentIdx]);
        }
        return maxRight;
    }
}
