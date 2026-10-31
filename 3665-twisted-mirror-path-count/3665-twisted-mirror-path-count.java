import java.util.Arrays;
class Solution {
    private int[][][] dp;
    private int m, n;
    private final int MOD = 1_000_000_007;
    public int uniquePaths(int[][] grid) {
        m = grid.length;
        n = grid[0].length;
        dp = new int[m][n][3];
        for (int[][] mat : dp) {
            for (int[] row : mat) {
                Arrays.fill(row, -1);
            }
        }
        return solve(0, 0, 2, grid);
    }
    private int solve(int r, int c, int dir, int[][] grid) {
        if (r >= m || c >= n) return 0;
        if (r == m - 1 && c == n - 1) return 1;
        if (dp[r][c][dir] != -1) return dp[r][c][dir];
        long paths = 0;
        if (grid[r][c] == 0) {
            paths = (paths + solve(r, c + 1, 0, grid)) % MOD;
            paths = (paths + solve(r + 1, c, 1, grid)) % MOD;
        } else {
            if (dir == 0) {
                paths = (paths + solve(r + 1, c, 1, grid)) % MOD;
            } else if (dir == 1) {
                paths = (paths + solve(r, c + 1, 0, grid)) % MOD;
            } else {
                paths = (paths + solve(r, c + 1, 0, grid)) % MOD;
                paths = (paths + solve(r + 1, c, 1, grid)) % MOD;
            }
        }
        return dp[r][c][dir] = (int) paths;
    }
}
