class Solution {
    public int[] decrypt(int[] code, int k) {
        int n = code.length;
        int[] ans = new int[n];
        if (k == 0) {
            return ans;
        }
        int start = k > 0 ? 1 : n + k;
        int end = k > 0 ? k : n - 1;
        int currentWindowSum = 0;
        for (int i = start; i <= end; i++) {
            currentWindowSum += code[i];
        }
        for (int i = 0; i < n; i++) {
            ans[i] = currentWindowSum;
            currentWindowSum -= code[start % n];
            start++;
            end++;
            currentWindowSum += code[end % n];
        }        
        return ans;
    }
}
